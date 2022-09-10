package com.myfirstproject.homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Synchronization4 extends TestBase {

    @Test
    public void test4(){
//        EXPLICIT WAIT MUST BE USER IMPLICIT WAIT CANNOT HANDLE CAUSE OF THE
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //    Click enable Button
        driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
//        Assert.assertTrue(driver.findElement(By.xpath("//input[@type='text']")).isEnabled()); //FAILS SO EXPLICIT MUST BE USED
        //    And verify the message is equal to “It's enabled!”
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement enabledMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        String enabledMessageText=enabledMessage.getText();
        Assert.assertEquals(enabledMessageText,"It's enabled!");

        //    And verify the textbox is enabled (I can type in the box)
        WebElement textBox=driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertTrue(textBox.isEnabled());//isEnables checks if an element is enable. Returns true if enabled, returns false if disabled.

//        click on disable button
        driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
        Assert.assertTrue(!driver.findElement(By.xpath("//input[@type='text']")).isDisplayed());

    }


}
