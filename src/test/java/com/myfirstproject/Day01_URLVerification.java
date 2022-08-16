package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_URLVerification {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://techproeducation.com/");

//        Getting the page URL
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://techproeducation.com/";

//        verify
        if (actualURL.equals(expectedURL)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("ACTUAL URL "+actualURL);
            System.out.println("EXPECTED URL "+expectedURL);
        }
        driver.quit();
    }
}
