package com.myfirstproject.homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Accordion extends TestBase {
    @Test
    public void accordion() throws InterruptedException {
        driver.get("https://jqueryui.com/accordion/");
//        And user moves the target element(Drag me to my target) in to  destination(Drop here)
//        We need to use Actions class to drag and drop


//        Elements are inside the iframe, so switch first
        driver.switchTo().frame(0);

        WebElement section2 = driver.findElement(By.id("ui-id-3"));


        Actions actions = new Actions(driver);
        actions.click(section2).perform();

//        Thread.sleep(1);
        String text = driver.findElement(By.xpath("//p[contains(text(),'Sed non urna.')]")).getText();
        System.out.println(text);

    }
}
