package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day08_FileDownloadTest extends TestBase {

    @Test
    public void downloadTest() throws InterruptedException {
//        Go to https://the-internet.herokuapp.com/download
        driver.get("https://the-internet.herokuapp.com/download");
//        Download flower.png file
        driver.findElement(By.linkText("usa.png")).click();//down loads the image

//        Then verify if the file downloaded successfully
        Thread.sleep(1000);//waiting for the download to complete

        String homeDirectory = System.getProperty("user.home");
        String filePath = homeDirectory+"/Downloads/usa.png";//MAC
//        String filePath = "/Users/techproed/Downloads/usa.png";//MAC


//        String path = homeDirectory+"\\Downloads\\usa.png";//WINDOWS
        boolean isDownloaded = Files.exists(Paths.get(filePath));
        Assert.assertTrue(isDownloaded);


    }


}
