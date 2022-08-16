package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_WebDriverManager {

    public static void main(String[] args) {
//        1. Setup chrome driver. NO LONGER System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");
        WebDriverManager.chromedriver().setup();


//        REST IS THE SAME
//        2. Create WebDriver object
        WebDriver driver = new ChromeDriver();


//        3. Write your test cases
        driver.get("https://www.amazon.com");
    }
}
