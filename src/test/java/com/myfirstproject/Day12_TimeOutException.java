package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Day12_TimeOutException {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void noSuchTest(){
        driver.get("https://www.techproeducation.com");


        driver.findElement(By.id("abc123"));//NoSuchElementException because element is not found
//        When you use implicit wait, and element is not found within given time, then still throws NoSuchElementException
    }

    @Test
    public void timeOutTest1(){
        driver.get("https://www.techproeducation.com");

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("abc123")));
//        when you use explicit wait, and element is not found within the given time, then throws TimeoutException
    }

    @Test
    public void timeOurTest2(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//div[@id='start']//button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//        my locator is correct but tie explicit wait time is not enough, then throws TimeoutException
        boolean isTrue = wait.until(ExpectedConditions.textToBe(By.xpath("//div[@id='finish']//h4"),"Hello World!"));
        Assert.assertTrue(isTrue);


    }

}
