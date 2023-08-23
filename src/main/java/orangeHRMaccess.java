import org.example.loginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class orangeHRMaccess {


    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = null;
        loginPage loginPage = new loginPage(driver);
        driver = new ChromeDriver();
        driver.get("https://www.softwaretestinghelp.com/selenium-webdriver-commands-selenium-tutorial-17/");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Admin");



    }

}
