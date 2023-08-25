package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class GetAttributes {

    public static void main (String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println(driver.findElement(By.xpath("//i[contains(@class,'left')]")).getAttribute("class"));
        driver.findElement(By.xpath("//i[contains(@class,'left')]")).click();
        if(driver.findElement(By.xpath("//i[contains(@class,'right')]")).getAttribute("class").contains("right"))
        {
            System.out.println("Toggle off");
            Assert.assertTrue(true);
        }else {
            System.out.println("Toggle not off");
            Assert.fail();
        }






    }

}
