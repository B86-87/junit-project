package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Day10_Screenshot2 extends TestBase {

    @Test
    public void takeScreenshotTest() throws IOException {
        driver.get("https://www.techproeducation.com");

//        Take screenshot of the logo

        WebElement logo=driver.findElement(By.xpath("//div[@data-id='898ce2e']"));
//        1. take screenshot
        File image = logo.getScreenshotAs(OutputType.FILE);

//        2. save screenshot
//        path
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+currentTime+"image.png";
        FileUtils.copyFile(image,new File(path));
    }

    @Test
    public void takeScreenShotTest2() throws IOException {
        driver.get("https://www.techproeducation.com");

//        Take screenshot of the logo
        WebElement logo=driver.findElement(By.xpath("//div[@data-id='898ce2e']"));
        takeScreenshotOfElement(logo);

//        Take screenshot of social media section
        WebElement socials=driver.findElement(By.xpath("//div[@data-id='d7545f2']"));
        takeScreenshotOfElement(socials);
    }

//    Creating a reusable method
//    @params: WebElement
//    takes screenshot
    public void takeScreenshotOfElement(WebElement element) throws IOException {
//        1. take screenshot
        File image = element.getScreenshotAs(OutputType.FILE);

//        2. save screenshot
//        path
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+currentTime+"image.png";
        FileUtils.copyFile(image,new File(path));
    }
}
