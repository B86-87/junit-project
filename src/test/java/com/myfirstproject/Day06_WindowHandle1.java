package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Set;

public class Day06_WindowHandle1 extends TestBase {


    @Test
    public void windowHandleTest() throws InterruptedException {
//        Given user is on the https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");
//        Verify the window1 URL is https://the-internet.herokuapp.com/windows
        String window1URL = driver.getCurrentUrl();
        Assert.assertEquals("https://the-internet.herokuapp.com/windows",window1URL);

//        GET WINDOW 1 HANDLE
        String window1Handle = driver.getWindowHandle();//getting the id of window 1
        System.out.println(window1Handle);



//        click on the click here link
        driver.findElement(By.linkText("Click Here")).click();
//        NEW TAB OPENS. SO WE HAVE TO SWITCH TO THAT WINDOW TO PERFORM TEST ON THAT PAGE

        Set<String> allWindowHandles = driver.getWindowHandles();

        System.out.println(allWindowHandles);
        for (String eachHandle : allWindowHandles){
            if(!eachHandle.equals(window1Handle)) {
                driver.switchTo().window(eachHandle);
                break;
            }
        }

//        Verify the window2 URL is https://the-internet.herokuapp.com/windows/new
        String window2URL = driver.getCurrentUrl();
        Assert.assertEquals("https://the-internet.herokuapp.com/windows/new",window2URL);
        String window2Handle = driver.getWindowHandle();//getting the id of window2

//        At this point driver is on window
//        GO BACK TO WINDOW 1 AND PRINT URL.
        driver.switchTo().window(window1Handle);
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);
        //        GO BACK TO WINDOW 2 AND PRINT URL
        driver.switchTo().window(window2Handle);
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);
        //        GO BACK TO WINDOW 1 AND PRINT URL
        driver.switchTo().window(window1Handle);
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);
        //        GO BACK TO WINDOW 1 AND PRINT URL
        driver.switchTo().window(window2Handle);
        System.out.println(driver.getCurrentUrl());

    }


}
