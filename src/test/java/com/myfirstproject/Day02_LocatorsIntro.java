package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Day02_LocatorsIntro {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
//        Adding implicitly wait to help wait issue
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void login(){

//        going to the URL
        driver.get("http://a.testaddressbook.com/sign_in");

//        Locating teh email input
        driver.findElement(By.id("session_email")).sendKeys("testtechproed@gmail.com");

//        Location the password input
        driver.findElement(By.id("session_password")).sendKeys("Test1234!");

//        Location the Submit Button
        driver.findElement(By.name("commit")).click();

//        Then verify that the expected user id testtechproed@gmail.com
//        (USE getText() method to get the text from the page)
        String actualIdText = driver.findElement(By.className("navbar-text")).getText();
        String expectedIdText = "testtechproed@gmail.com";
        Assert.assertEquals(expectedIdText,actualIdText);

//        Verify the Addresses and Sign Out texts are displayed
        WebElement addressElement = driver.findElement(By.linkText("Addresses"));
        Assert.assertTrue(addressElement.isDisplayed());

        WebElement actualSignOutLink = driver.findElement(By.linkText("Sign out"));
        Assert.assertTrue(actualSignOutLink.isDisplayed());

//        Find the number of total link on the page
//        a tag is used to create link
        List<WebElement> linkList=driver.findElements(By.tagName("a"));//returns the total number of link on the page
        int numOfLink = linkList.size();
        System.out.println("Number of link : "+numOfLink);

//        Print all link names
        for (WebElement eachElement: linkList){
            System.out.println(eachElement.getText());
        }

//        Sign out from the page
        driver.findElement(By.xpath("//a[@data-test='sign-out']")).click();

//        We are able to click on the signout button
//        We need to assert the sign out functionality works
//        We can locate a core element for assertion
//        Or we can use URL for assertion
//        Sign out URL: http://a.testaddressbook.com/
//        Assert that after click on signout, the URL should be http://a.testaddressbook.com/sign_in

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.equals("http://a.testaddressbook.com/sign_in"));


        /*
        * getText() is used to get teh text of a webelement. This returns a string
        * isDisplayed() is used to check if an element is on the page or nor. This returns a boolean
        * */
    }

}
