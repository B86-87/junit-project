package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_GetPageSource {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();
        String pageSource = driver.getPageSource();// getPageSource(); returns the page source as String
//        System.out.println(pageSource);

        if (pageSource.contains("Registry")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("PAGE SOURCE ==>>> " +pageSource);
            System.out.println("EXPECTED WORD ===>>> Registry");
        }

        driver.quit();
    }
}
