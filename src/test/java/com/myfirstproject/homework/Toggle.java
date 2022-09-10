package com.myfirstproject.homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

public class Toggle extends TestBase {
    @Test
    public void effectsTest() throws InterruptedException {
        driver.get("https://jqueryui.com/toggle/");
        driver.switchTo().frame(0);
        String before = driver.findElement(By.xpath("//div[@id='effect']//p")).getText();
        System.out.println("Before : "+before);
        driver.findElement(By.xpath("//button[@id='button']")).click();

        Thread.sleep(2000);
        String after = driver.findElement(By.xpath("//div[@id='effect']//p")).getText();
        System.out.println("After : "+after);

        driver.findElement(By.xpath("//button[@id='button']")).click();
        Thread.sleep(2000);
        String after1 = driver.findElement(By.xpath("//div[@id='effect']//p")).getText();
        System.out.println("After1 : "+after1);



    }
}
