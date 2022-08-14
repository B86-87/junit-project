package com.myfirstproject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;

public class Day01_BasicNavigations {
//Steps:
//Create a new class under : BasicNavigations
//Create main method
//Set Path
//Create chrome driver
//Maximize the window
//Open google home page https://www.walmart.com/.
//On the same class, Navigate to amazon home page https://www.amazon.com/
//Navigate back to google
//Navigate forward to amazon
//Refresh the page
//Close/Quit the browser

    public static void main(String[] args) throws InterruptedException {
//        set driver and path
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");//mac
//        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");//windows

//        create webdriver object
        WebDriver driver = new ChromeDriver();

//        Maximize the window
        driver.manage().window().maximize();

//        start your test case
        driver.get("https://www.youtube.com/"); //get("URL") -> go to a URL

//        Wait for 3 seconds at this point
        Thread.sleep(3000);

//       On the same class, Navigate to amazon home page https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");
        Thread.sleep(3000);

//     Navigate back to youtube
        driver.navigate().back();
        Thread.sleep(3000);

//      Navigate forward to amazon
        driver.navigate().forward();
        Thread.sleep(3000);

//      Refresh the page
        driver.navigate().refresh();

//      Close/Quit the browser
//        driver.close();
//        OR
        driver.quit();

        /*
        * 1. What is the difference between get and navigate?
        * Similarities: Both opens a page URL.
        * Differences : 1. get() accepts the string url, navigate can be used with to()
        *               2. get() cannot be used to going back, forward, and refresh; navigate can be used for going back,forward, and refresh
        *               3. get() accepts only string parameter; navigate accepts string OR URL as parameter
        *
        * 2. What is the difference between close and quit ?
        *               1. close -> closes only ACTIVE WORKING WINDOW
        *               2. quit -> closes ALL working windows
        *
        *
        * */

    }

}
