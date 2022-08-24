package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day07_Actions1 extends TestBase {

    @Test
    public void contextClickTest(){
//        Given user is on the https://the-internet.herokuapp.com/context_menu
        driver.get("https://the-internet.herokuapp.com/context_menu");
//        When use Right clicks on the box
        WebElement box = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(box).perform();
//        Then verify the alert message is “You selected a context menu”
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals("You selected a context menu",alertText);
//        Then accept the alert
        driver.switchTo().alert().accept();
    }
}
