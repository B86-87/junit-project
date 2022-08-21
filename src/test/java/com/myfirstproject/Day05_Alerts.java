package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Day05_Alerts extends TestBase {

    @Test
    public void acceptAlert() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
//        acceptAlert() => click on the first alert,
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

//        verify the text “I am a JS Alert” ,
        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);
        Assert.assertEquals("I am a JS Alert",alertText );

//        click OK ,
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

//        and Verify “You successfully clicked an alert”
        String result = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals("You successfully clicked an alert",result);
        Assert.assertEquals("You successfully clicked an alert",result);
        Assert.assertTrue(result.equals("You successfully clicked an alert"));
    }

    @Test
    public void dismissAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //    dismissAlert()=> click on the second alert,
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        //    verify text "I am a JS Confirm”,
        String text = driver.switchTo().alert().getText();
        Assert.assertEquals("I am a JS Confirm",text);
        //    click cancel,
        driver.switchTo().alert().dismiss();
        //    and Verify “You clicked: Cancel”
        String  result = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals("You clicked: Cancel",result);
    }


    @Test
    public void sendKeysAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //    sendKeysAlert()=> click on the third alert,
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        //    verify text “I am a JS prompt”,
        String text = driver.switchTo().alert().getText();
        Assert.assertEquals("I am a JS prompt",text);
        //    type “Hello World”,
        driver.switchTo().alert().sendKeys("Hello World");
        //    click OK,
        driver.switchTo().alert().accept();
        //    and Verify “You entered: Hello World”
        String result = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals("You entered: Hello World",result);
    }
}
