package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day06_Iframe extends TestBase {

    @Test
    public void iframeTest(){
//        Go to https://the-internet.herokuapp.com/iframe
        driver.get("https://the-internet.herokuapp.com/iframe");
//        Verify the Bolded text contains “Editor”
        String pageHeader = driver.findElement(By.xpath("//h3[.='An iFrame containing the TinyMCE WYSIWYG Editor']")).getText();
        Assert.assertTrue(pageHeader.contains("Editor"));
//        Locate the text box
//        SWITCH TO THE FRAME FIRST

//          1. BY INDEX : switch to the first iframe
//        driver.switchTo().frame(0);
//          2. BY ID/NAME. using id
//        driver.switchTo().frame("mce_0_ifr");

//        3. BY WEB ELEMENT
        WebElement iframe=driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe);

//        WE ARE NOW INSIDE THE FIRST IFRAME
//        IT MEANS WE CAN INTERACT WITH THE ELEMENTS INSIDE THE IFRAME
        WebElement box = driver.findElement(By.xpath("//p"));
//        Delete the text in the text box
        box.clear();//clear - > clears the box. deletes teh texts

//        Type “This text box is inside the iframe”
        box.sendKeys("This text box is inside the iframe");

//        Verify the text Elemental Selenium text is displayed on the page

//        !!! driver is still in the iframe. we need to exit
        driver.switchTo().parentFrame();//takes to parent level
//        driver.switchTo().defaultContent();//takes to root level
        WebElement elementalSelenium = driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elementalSelenium.isDisplayed());

    }
}
