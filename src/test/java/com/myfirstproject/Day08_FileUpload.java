package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day08_FileUpload extends TestBase {

    @Test
    public void fileUploadTest(){
//        When user goes to https://the-internet.herokuapp.com/upload
        driver.get("https://the-internet.herokuapp.com/upload");
//        When user selects an image from the desktop
        String filePath = "/Users/techproed/Desktop/logo.jpeg";//MAC

//        Locating the choose file button
        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));
//        sending the path of a file to the button
        chooseFileButton.sendKeys(filePath);

//        And click on the upload button
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();

//        Then verify the File Uploaded!  Message displayed
        Assert.assertTrue(driver.findElement(By.xpath("//h3[.='File Uploaded!']")).getText().equals("File Uploaded!"));

    }
}
