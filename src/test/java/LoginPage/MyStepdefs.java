package LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MyStepdefs {

    private WebDriver driver;

    @Before()
    public void startDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("Customer navigates to the webpage")
    public void customerNavigatesToTheWebpage() {
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

    @After()
        public void teardown(){
            driver.quit();
        }



}
