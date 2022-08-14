package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumClass {

    public static void main(String[] args) {
//        1. this class should know which driver
//        will be used. And where is that driver

//        SET UP DRIVER
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");//MAC
//        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");//WINDOWS

//        2. CREATE CHROMEDRIVER
        WebDriver driver = new ChromeDriver();

//        3. Now that we set and created chromedriver, we can use that driver for
//        automation of the test cases
        driver.get("https://www.amazon.com");

    }
}
