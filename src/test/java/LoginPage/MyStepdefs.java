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

    @Given("I click on the Leave link on the menu")
    public void iClickOnTheLeaveLinkOnTheMenu() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.linkText("Leave")).click();
    }

    @And("I click on the button with the three dots in the employee record")
    public void iClickOnTheButtonWithTheThreeDotsInTheEmployeeRecord() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[contains(@class,\"border\")]/following:: i[contains(@class,\"vertical\")]")).click();
        
    }

    @And("I select to Add Comment from that list")
    public void iSelectToAddCommentFromThatList() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//p[normalize-space()='Add Comment']")).click();
        
    }

    @And("I enter a comment in the Leave Request Comments section")
    public void iEnterACommentInTheLeaveRequestCommentsSection() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//textarea[@placeholder='Comment here']")).sendKeys("This is a Test");

        
    }

    @And("I save the comment")
    public void iSaveTheComment() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();

        
    }

    @Then("I should be able to see the confirmation message that the comment was added")
    public void iShouldBeAbleToSeeTheConfirmationMeesageThatTheCommentWasAdded() throws InterruptedException {
        Thread.sleep(2500);
        driver.findElement(By.xpath("//p[normalize-space()='Successfully Saved']")).isDisplayed();
    }

    @And("I select the Contact Details link which will redirect me to the contact Details")
    public void iSelectTheContactDetailsLinkWhichWillRedirectMeToTheContactDetails() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.linkText("Contact Details")).click();
    }

    @And("I tick the checkbox to select one record saved in the Record Found")
    public void iTickTheCheckboxToSelectOneRecordSavedInTheRecordFound() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='oxd-table-card-cell-checkbox']//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']")).click();
    }

    @And("I press the Delete button to delete the record")
    public void iPressTheDeleteButtonToDeleteTheRecord() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='Delete Selected']")).click();

    }

    @And("I press Yes to confirm this deletion")
    public void iPressYesToConfirmThisDeletion() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Yes, Delete']")).click();
    }

    @Then("I should receive the confirmation message that the record has been deleted successfully")
    public void iShouldReceiveTheConfirmationMessageThatTheRecordHasBeenDeletedSuccessfully() throws InterruptedException {
        Thread.sleep(2500);
        driver.findElement(By.xpath("//p[normalize-space()='Successfully Deleted']")).isDisplayed();
    }

    @Given("I click the Admin link")
    public void iClickTheAdminLink() throws InterruptedException {
        Thread.sleep(2400);
        driver.findElement(By.linkText("Admin")).click();

    }

    @And("I click the Configuration dropdown menu button")
    public void iClickTheConfigurationDropdownMenuButton() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[normalize-space()='Configuration']")).click();
    }

    @And("I click the Language Package option")
    public void iClickTheLanguagePackageOption() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='Language Packages']")).click();

    }

    @And("I click on the Translate button for Spanish")
    public void iClickOnTheTranslateButtonForSpanish() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[contains(text(),'Spanish - Español')]/following::button[normalize-space()='Translate']")).click();
    }

    @Then("I should be redirected to the language Customization page")
    public void iShouldBeRedirectedToTheLanguageCustomizationPage() throws InterruptedException {
        Thread.sleep(3000);
        String urlpage = driver.getCurrentUrl();
        String urlactual = "https://opensource-demo.orangehrmlive.com/web/index.php/admin/languageCustomization/7";
        Assert.assertEquals(urlpage,urlactual);
    }

    @And("I click the Add button to add a new language to the packages")
    public void iClickTheAddButtonToAddANewLanguageToThePackages() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
    }

    @And("I select the Colognian from the list")
    public void iSelectTheColognianFromTheList() throws InterruptedException {
        Thread.sleep(30000);
        driver.findElement(By.xpath("//i[contains(@class,\"arrow\")]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[normalize-space()='Aghem (Cameroon)']")).click();


    }

    @And("I press the Save to add this new language to my packages")
    public void iPressTheSaveToAddThisNewLanguageToMyPackages() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
        
    }

    @Then("I should be able to see the confirmation message that the language was succesfully saved")
    public void iShouldBeAbleToSeeTheConfirmationMessageThatTheLanguageWasSuccesfullySaved() throws InterruptedException {
        Thread.sleep(2800);
        driver.findElement(By.xpath("//p[normalize-space()='Successfully Saved']")).isDisplayed();
    }

    @Given("I select the Change Password option from drop-down user profile menu")
    public void iSelectTheChangePasswordOptionFromDropDownUserProfileMenu() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//i[contains(@class,\"userdropdown-icon\")]")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Change Password")).click();

    }
    @And("I enter the current password in the Current Password field")
    public void iEnterTheCurrentPasswordInTheCurrentPasswordField() throws InterruptedException {
        Thread.sleep(2500);
        driver.findElement(By.xpath("//div[contains(@class,\"gutters\")]//following:: input[@type='password'][1]")).sendKeys("admin123");
    }
    @And("I confirm the new password")
    public void iConfirmTheNewPassword() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[contains(@class,\"gutters\")]//following:: input[@type='password'][3]")).sendKeys("admin1234");
    }

    @And("I press the Save button to update the password")
    public void iPressTheSaveButtonToUpdateThePassword() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
    }

    @And("I enter in the Password field a new password")
    public void iEnterInThePasswordFieldANewPassword() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[contains(@class,\"gutters\")]//following:: input[@type='password'][2]")).sendKeys("admin1234");
    }

    @Then("I should be able to see the confirmation message it was saved")
    public void iShouldBeAbleToSeeTheConfirmationMessageItWasSaved() throws InterruptedException {
        Thread.sleep(2500);
        driver.findElement(By.xpath("//p[normalize-space()='Successfully Saved']")).isDisplayed();
    }

    @And("I select a specific period for which i want to see the records")
    public void iSelectASpecificPeriodForWhichIWantToSeeTheRecords() throws InterruptedException {
        Thread.sleep(3000);
        WebElement fieldOne =driver.findElement(By.xpath("//div[contains(@class,\"space\")]//following::input[@placeholder='yyyy-mm-dd'][1]"));
        fieldOne.sendKeys(Keys.SHIFT,Keys.ARROW_UP);
        fieldOne.sendKeys(Keys.DELETE);
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//div[contains(@class,\"space\")]//following::input[@placeholder='yyyy-mm-dd'][1]")).clear();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(@class,\"space\")]//following::input[@placeholder='yyyy-mm-dd'][1]")).sendKeys("2022-01-14");
        Thread.sleep(2001);
        WebElement fieldTwo =driver.findElement(By.xpath("//div[contains(@class,\"space\")]//following::input[@placeholder='yyyy-mm-dd'][2]"));
        fieldTwo.sendKeys(Keys.SHIFT,Keys.ARROW_UP);
        fieldTwo.sendKeys(Keys.DELETE);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(@class,\"space\")]//following::input[@placeholder='yyyy-mm-dd'][2]")).sendKeys("2022-07-30");


    }
    @And("I select to see only leave with Pending Approval status")
    public void iSelectToSeeOnlyLeaveWithPendingApprovalStatus() throws InterruptedException {
        Thread.sleep(2500);
        driver.findElement(By.xpath("//span[normalize-space()='Pending Approval']")).isDisplayed();
    }

    @And("I set Leave Type as US Vacation")
    public void iSetLeaveTypeAsUSVacation() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[contains(@class,\"active\")]//following ::i[contains(@class,\"arrow\")][2]")).click();
        Thread.sleep(2500);
        driver.findElement(By.xpath("//span[normalize-space()='US - Vacation']")).click();
    }

    @And("I press search button")
    public void iPressSearchButton() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
    }

    @Then("I should see all the records with all the data entered")
    public void iShouldSeeAllTheRecordsWithAllTheDataEntered() {
        String recordFound = driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span']")).getText();
        String wordPresent = "Records Found";
        if (recordFound.toLowerCase().contains(wordPresent.toLowerCase())) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }

    }

    @And("I select a specific period")
    public void iSelectASpecificPeriod() throws InterruptedException {
        Thread.sleep(3000);
        WebElement fieldOne =driver.findElement(By.xpath("//div[contains(@class,\"space\")]//following::input[@placeholder='yyyy-mm-dd'][1]"));
        fieldOne.sendKeys(Keys.SHIFT,Keys.ARROW_UP);
        fieldOne.sendKeys(Keys.DELETE);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(@class,\"space\")]//following::input[@placeholder='yyyy-mm-dd'][1]")).sendKeys("2021-12-01");
        Thread.sleep(2001);
        WebElement fieldTwo =driver.findElement(By.xpath("//div[contains(@class,\"space\")]//following::input[@placeholder='yyyy-mm-dd'][2]"));
        fieldTwo.sendKeys(Keys.SHIFT,Keys.ARROW_UP);
        fieldTwo.sendKeys(Keys.DELETE);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(@class,\"space\")]//following::input[@placeholder='yyyy-mm-dd'][2]")).sendKeys("2023-12-31");
    }

    @And("I select Leave type as CAN Personal")
    public void iSelectLeaveTypeAsCANPersonal() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[contains(@class,\"active\")]//following ::i[contains(@class,\"arrow\")][2]")).click();
        Thread.sleep(2500);
        driver.findElement(By.xpath("//span[normalize-space()='CAN - Personal']")).click();
    }

    @And("I enter Anthony Nolan in the Employee Name field")
    public void iEnterAnthonyNolanInTheEmployeeNameField() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[contains(@placeholder,\"Type\")]")).sendKeys("Anthony Nolan");
    }

    @And("I press the Search button")
    public void iPressTheSearchButton() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();

    }

    @And("I click the Reset button")
    public void iClickTheResetButton() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='Reset']")).click();
    }

    @Then("I should see a pop-up message that says no records founds")
    public void iShouldSeeAPopUpMessageThatSaysNoRecordsFounds() throws InterruptedException {
        Thread.sleep(2001);
        driver.findElement(By.xpath("//p[normalize-space()='No Records Found']")).isDisplayed();
    }

    @And("I select Job Titles options from the Job menu dropdown")
    public void iSelectJobTitlesOptionsFromTheJobMenuDropdown() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[normalize-space()='Job']")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Job Titles")).click();
    }

    @And("I click the Add button to add a new job")
    public void iClickTheAddButtonToAddANewJob() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
    }

    @And("I add a name for the job in the Job Title field")
    public void iAddANameForTheJobInTheJobTitleField() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(@class,\"row\")]//following:: input[contains(@class,\"active\")]")).sendKeys("Title Test");
    }

    @And("I add a Job description")
    public void iAddAJobDescription() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//textarea[@placeholder='Type description here']")).sendKeys("This is a job");

    }

    @And("I add a Job Specification file")
    public void iAddAJobSpecificationFile() throws InterruptedException {
        Thread.sleep(5000);
        String filePath="/Users/adinica/Desktop/AutoFrameworkBootcamp/picture/pictures/Screenshot 2023-08-23 at 14.31.16.png";
        Thread.sleep(4500);
        WebElement uploadFile = driver.findElement(By.xpath("//input[@type='file']"));
        Thread.sleep(3000);
        uploadFile.sendKeys(filePath);
    }

    @And("I click the Save button to add the new job")
    public void iClickTheSaveButtonToAddTheNewJob() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
    }

    @Then("I should see the confirmation message that the job was successfully added")
    public void iShouldSeeTheConfirmationMessageThatTheJobWasSuccessfullyAdded() throws InterruptedException {
        Thread.sleep(2001);
        driver.findElement(By.xpath("//p[normalize-space()='Successfully Saved']")).isDisplayed();
    }
}
