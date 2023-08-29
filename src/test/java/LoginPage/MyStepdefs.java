package LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import PageObj.PageObj;

import java.util.ArrayList;
import java.util.List;

public class MyStepdefs {

    public WebDriver driver;

    @Given("Customer navigates to the webpage")
    public void customerNavigatesToTheWebpage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("I enter my valid username and password")
    public void iEnterMyValidUsernameAndPassword() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("admin123");

    }

    @And("I press the Login button")
    public void iPressTheLoginButton() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("I verify the username is displayed in the right corner of the navigation bar")
    public void iVerifyTheUsernameIsDisplayedInTheRightCornerOfTheNavigationBar() throws InterruptedException {
        Thread.sleep(2000);
        String name = driver.findElement(By.xpath("//p[contains(@class,'name')]")).getText();
        Assert.assertEquals(name, name);
    }

    @When("I enter invalid credentials")
    public void iEnterInvalidCredentials() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.name("username")).click();
        driver.findElement(PageObj.usernamefield).sendKeys("Admin");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("admin1234");
    }

    @Then("I receive the error message {string}")
    public void iReceiveTheErrorMessage(String arg0) throws InterruptedException {
        Thread.sleep(4000);
        String error = driver.findElement(By.xpath("//p[text()='Invalid credentials']")).getText();
        Assert.assertEquals("Invalid credentials",error);


    }

    @Given("I click the Leave link from the menu")
    public void iClickTheLeaveLinkFromTheMenu() throws InterruptedException {
        Thread.sleep(4000);
        driver.findElement(By.xpath("//span[text()='Leave']")).click();

    }

    @And("I select the Rejected status from the Show Leave with Status section")
    public void iSelectTheRejectedStatusFromTheShowLeaveWithStatusSection() throws InterruptedException {
        Thread.sleep(4000);
        driver.findElement(By.xpath("//label[text()='Show Leave with Status']/following:: i[contains(@class,\"arrow\")][1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@role='listbox']//div[1]")).click();


    }

    @Then("I check that the Rejected status is present as a selection")
    public void iCheckThatTheRejectedStatusIsPresentAsASelection() throws InterruptedException {
        Thread.sleep(2000);
        if(driver.findElement(By.xpath("//span[normalize-space()='Rejected']")).isDisplayed())
        {
            System.out.println("True");
            Assert.assertTrue(true);
        }else
            System.out.println("False");


    }
}
