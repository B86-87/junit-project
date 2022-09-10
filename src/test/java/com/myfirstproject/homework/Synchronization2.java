package com.myfirstproject.homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Synchronization2 extends TestBase {
    @Test
    public void test2(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(By.xpath("//button")).click();
        WebElement helloWord=driver.findElement(By.xpath("//h4[.='Hello World!']"));
        Assert.assertEquals(helloWord.getText(),"Hello World!");
        //All is good. We don't need to use explicit wait. //Implicit wait solved the issue
        //Cause the element is not hidden(No display:none on Hello World).
        //The entire element <h4>Hello World!</h4> just renders late

    }
}
