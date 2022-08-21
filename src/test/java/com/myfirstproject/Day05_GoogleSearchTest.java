package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Day05_GoogleSearchTest extends TestBase {

    @Test
    public void searchTest(){
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("porcelain teapot"+ Keys.ENTER);//search then click Enter

        //Rest is homework



    }

}
