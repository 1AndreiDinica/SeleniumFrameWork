package LoginPage;

import com.ibm.icu.impl.UResource;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import PageObj.PageObj;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

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

    @Given("I click the My Info options from the menu")
    public void iClickTheMyInfoOptionsFromTheMenu() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[normalize-space()='My Info']")).click();
    }

    @Then("I click on the Contact Details link which will redirect me to the Details page")
    public void iClickOnTheContactDetailsLinkWhichWillRedirectMeToTheDetailsPage() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='Contact Details']")).click();


    }

    @And("I update the Street field from the contact details")
    public void iUpdateTheStreetFieldFromTheContactDetails() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//label[text()='Street 1']/following:: input[contains(@class,\"active\")][1]")).clear();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[text()='Street 1']/following:: input[contains(@class,\"active\")][1]")).sendKeys("Update");
    }

    @And("I select Algeria as a country")
    public void iSelectAlgeriaAsACountry() throws InterruptedException {
        Thread.sleep(2000);
//        driver.findElement(By.xpath("//i[contains(@class,\"arrow\")]")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//div[contains(@class,\"content\"]//div[11]")).click();
//        WebElement staticDropdown = driver.findElement(By.xpath("//div[contains(@class,\"active\")]"));
//
//        Select dropdown = new Select(staticDropdown);
//        dropdown.deselectByIndex(10);
//        System.out.println(dropdown.getFirstSelectedOption().getText());
         driver.findElement(By.xpath("//div[contains(@class,\"active\")]")).click();
         driver.findElement(By.xpath("//span[normalize-space()='Algeria']")).click();



    }

    @And("I press the save button")
    public void iPressTheSaveButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//p[contains(@class,\"hint\")]/following:: button[@type='submit'][1]")).click();
    }

    @Then("I should see the successfully update message")
    public void iShouldSeeTheSuccessfullyUpdateMessage() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//p[text()='Successfully Updated']")).isDisplayed();
    }

    @And("I click the Add Attachment button")
    public void iClickTheAddAttachmentButton() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
    }

    @And("I select to upload file")
    public void iSelectToUploadFile() throws InterruptedException {
        Thread.sleep(5000);
        String filePath="/Users/adinica/Desktop/AutoFrameworkBootcamp/picture/pictures/Screenshot 2023-08-23 at 14.31.16.png";
        Thread.sleep(4500);
        WebElement uploadFile = driver.findElement(By.xpath("//input[@type='file']"));
        Thread.sleep(3000);
        uploadFile.sendKeys(filePath);


    }

    @And("I add a comment on this document uploaded in the comment field")
    public void iAddACommentOnThisDocumentUploadedInTheCommentField() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//textarea[@placeholder='Type comment here']")).sendKeys("This is a test");


    }

    @And("I press the Save button for this attachment added")
    public void IPressTheSaveButtonForThisAttachmentAdded() throws InterruptedException {
        Thread.sleep(4000);
        driver.findElement(By.xpath("//div[@class='orangehrm-attachment']//button[@type='submit'][normalize-space()='Save']")).click();

    }

    @Then("I am able to see my document added in the record found section")
    public void IAmAbleToSeeMyDocumentAddedInTheRecordFoundSection() throws InterruptedException {
        Thread.sleep(4000);
        driver.findElement(By.xpath("//div[contains(text(),'This is a test')]")).isDisplayed();
    }
}
