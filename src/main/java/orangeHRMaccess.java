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
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //closes on window
        driver.close();
        //closes everything
        driver.quit();



    }

}
