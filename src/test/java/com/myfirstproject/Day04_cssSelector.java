package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day04_cssSelector {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @Test
    public void cssTest(){
        driver.get("http://a.testaddressbook.com/sign_in");
//        Find the username using css selector
//        tag[attribute='value']
        driver.findElement(By.cssSelector("input[id='session_email']")).sendKeys("testtechproed@gmail.com");

//        input.form-control can be used to find teh same element
//        .form-control can be used to find teh same element. . means class
//        Find the password using css selector

        driver.findElement(By.cssSelector("input#session_password")).sendKeys("Test1234!");//  # means id
//        #session_password can be used instead of input#session_password

//        Find log in button using css selector
        driver.findElement(By.cssSelector("input[name='commit']")).click();
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
