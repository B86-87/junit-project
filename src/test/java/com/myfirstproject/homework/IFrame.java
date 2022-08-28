package com.myfirstproject.homework;

import com.myfirstproject.utilities.TestBase;
import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
public class IFrame extends TestBase {
    @Test
    public void iframeTest() throws InterruptedException {

        driver.get("https://html.com/tags/iframe/");

        Actions actions=new Actions(driver);

        //Need to scroll down the page, otherwise the iframe of play button is not displayed
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //Locating and switching to the iframe. Because play button is inside the frame
        WebElement firstIFrame=driver.findElement(By.xpath("//div[@class='render']//iframe"));
        driver.switchTo().frame(firstIFrame);

        //Locating and clicking teh play button
        WebElement playButton=driver.findElement(By.xpath("//button[@aria-label='Play']"));
        playButton.click();

//      playing for 5 seconds
        Thread.sleep(5000);

//        moving over the video so pause can display
        actions.moveToElement(driver.findElement(By.xpath("//video[@class='video-stream html5-main-video']")));
        Thread.sleep(1000);

//        clicking on the video to pause
        driver.findElement(By.xpath("//video[@class='video-stream html5-main-video']")).click();
    }
}
