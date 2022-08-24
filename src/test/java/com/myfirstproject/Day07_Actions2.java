package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day07_Actions2 extends TestBase {


    @Test
    public void hoverOverTest(){
//    Given user is on the https://www.amazon.com/
        driver.get("https://www.amazon.com/");
//    When use click on “Account” link
        WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountList).perform();
        driver.findElement(By.linkText("Account")).click();

//    Then verify the page title contains “Your Account”
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Your Account"));


    }


}
