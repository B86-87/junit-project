package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_LocatorsIntro {

    @Test
    public void login(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

//        going to the URL
        driver.get("http://a.testaddressbook.com/sign_in");

//        Locating teh email input
        driver.findElement(By.id("session_email")).sendKeys("testtechproed@gmail.com");

//        Location the password input
        driver.findElement(By.id("session_password")).sendKeys("Test1234!");

//        Location the Submit Button
        driver.findElement(By.name("commit")).click();

//        close the driver
        driver.quit();

    }

}
