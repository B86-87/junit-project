package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class Day11_JSExecutor extends TestBase {

    @Test
    public void scrollIntoViewTest() throws InterruptedException {
        driver.get("https://techproeducation.com/");
        Thread.sleep(3000);

        WebElement weOffer = driver.findElement(By.xpath("//*[.='WE OFFER']"));

//        1. Create jsexecutor object
        JavascriptExecutor js = (JavascriptExecutor)driver;

//        2. Execute JS commend
        js.executeScript("arguments[0].scrollIntoView(true);",weOffer);

        Thread.sleep(3000);
//        Scroll over to the Search input that is at the top of the page
        WebElement searchBox = driver.findElement(By.xpath("//input[@type='search']"));
        js.executeScript("arguments[0].scrollIntoView(true);",searchBox);
    }

//    IMPORTANT
    @Test
    public void scrollIntoViewTest2() throws InterruptedException {
        driver.get("https://techproeducation.com/");
        Thread.sleep(3000);
        WebElement weOffer = driver.findElement(By.xpath("//*[.='WE OFFER']"));
        scrollIntoViewJS(weOffer);//coming form TestBase
        Thread.sleep(3000);
        WebElement searchBox = driver.findElement(By.xpath("//input[@type='search']"));
        scrollIntoViewJS(searchBox);//coming from TestBase
    }

    @Test
    public void scrollAllTheWayTest() throws InterruptedException, IOException {
        driver.get("https://techproeducation.com/");
        Thread.sleep(3000);
        scrollAllDownByJS();
        takeScreenShot();
        Thread.sleep(3000);
        scrollAllUpByJS();
        takeScreenShot();
    }

//    IMPORTANT
    @Test
    public void clickByJSTests(){
        driver.get("https://techproeducation.com/");
        WebElement LMSLogin = driver.findElement(By.linkText("LMS Login"));
        clickByJS(LMSLogin);
    }

    @Test
    public void setValueByJSTest(){
        driver.get("https://techproeducation.com/");
        WebElement searchBox = driver.findElement(By.xpath("//input[@type='search']"));
        setValueByJS(searchBox,"QA");
    }

//    A LITTLE IMPORTANT
    @Test
    public void getValueByJStest(){
        driver.get("https://www.carettahotel.com/");
        WebElement checkIn = driver.findElement(By.id("checkin_date"));
//        System.out.println(checkIn.getText());//returns empty
       getValueByJS("checkin_date");//returns the value of the element whose id=checkin_date
    }

    @Test
    public void changeBackgroundColorJSTest(){
        driver.get("https://www.carettahotel.com/");
        WebElement checkAvailability = driver.findElement(By.xpath("//input[@type='submit']"));
        changeBackgroundColorByJS(checkAvailability,"red");


        WebElement loginButton = driver.findElement(By.xpath("//a[.='Log in']"));
        addBorderWithJS(loginButton,"5px solid yellow");

    }




}
