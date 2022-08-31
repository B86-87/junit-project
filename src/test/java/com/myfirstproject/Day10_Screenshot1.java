package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Day10_Screenshot1 extends TestBase {

    @Test
    public void takeScreenshotTest() throws IOException {

        driver.get("https://www.amazon.com");
        takeScreenShot();

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Porcelain Teapot"+ Keys.ENTER);
        takeScreenShot();
    }



    public void takeScreenShot() throws IOException {
//        1. Take screenshot
        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

//        ALTERNATIVELY WE CAN DO SAME CODE IN 2 LINES
//        TakesScreenshot ts = (TakesScreenshot)driver;
//        File image = ts.getScreenshotAs(OutputType.FILE);

//       2. Save screenshot
//        getting the current time as string to use in teh screenshot name, previous screenshots will be kept
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

//        Path of screenshot save folder               folder / folder    /file name
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+currentTime+"image.png";
        FileUtils.copyFile(image,new File(path));
    }

}
