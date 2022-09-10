package com.myfirstproject.homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Synchronization3 extends TestBase {

    @Test
    public void test3(){
//     No need to use explicit wait, implicit wait is enough
//        This is test case is done using implicit wait

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
//        Click on remove button
        WebElement removeButton=driver.findElement(By.xpath("(//button[@type='button'])"));
        removeButton.click();
//        And verify the message is equal to “It's gone!”
//      This is where I need to wait
//      What is our expected condition???
//      Expected condition is to wait for the It's gone element
        Assert.assertEquals("It's gone!",driver.findElement(By.xpath("//p[@id='message']")).getText());
        WebElement addButton=driver.findElement(By.xpath("(//button[@type='button'])[1]"));
        addButton.click();
        Assert.assertEquals("It's back!",driver.findElement(By.xpath("//p[@id='message']")).getText());

    }
    @Test
    public void test33(){
//     No need to use explicit wait, implicit wait is enough
//     But as example  This is test case is done using explicit wait
//     CREATE WAIT OBJECT
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
//        Click on remove button
        WebElement removeButton=driver.findElement(By.xpath("(//button[@type='button'])"));
        removeButton.click();
//        And verify the message is equal to “It's gone!”
        //This is where I need to wait
        //What is our expected condition???
        //Expected condition is to wait for the It's gone element
        WebElement goneMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
//        WebElement goneMessage=driver.findElement(By.xpath("//p[@id='message']"));
        String goneMessageText=goneMessage.getText();
        Assert.assertEquals(goneMessageText,"It's gone!");
//        Then click on Add button
        WebElement addButton=driver.findElement(By.xpath("(//button[@type='button'])[1]"));
        addButton.click();

//        And verify the message is equal to “It's back!”
        WebElement backMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
//        WebElement backMessage=driver.findElement(By.xpath("//p[@id='message']"));
        String backMessageText=backMessage.getText();
        Assert.assertEquals(backMessageText,"It's back!");


    }
}
