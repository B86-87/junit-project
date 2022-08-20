package com.myfirstproject;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Day04_RadioButton {

    WebDriver driver;
    Faker faker = new Faker();
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void accountSignUp(){
        driver.get("https://facebook.com");
//        click on 'Create new account'
        driver.findElement(By.linkText("Create new account")).click();
//        driver.findElement(By.xpath("Xpath of the popup")).click();

//       locating first name and entering a data
        driver.findElement(By.name("firstname")).sendKeys(faker.name().firstName());

//        locating the last nae and entering data
        driver.findElement(By.name("lastname")).sendKeys(faker.name().lastName());

//       locating and entering the mobile number
        driver.findElement(By.name("reg_email__")).sendKeys(faker.phoneNumber().phoneNumber());

//        locating and entering the new password
        driver.findElement(By.name("reg_passwd__")).sendKeys(faker.internet().password());

//        Jan 10 2000
//        MONTH
//        1. locate the month dropdown
        WebElement month = driver.findElement(By.id("month"));
//        2. create select
        Select selectMonth=new Select(month);
//        3. select your option using select object
        selectMonth.selectByVisibleText("Jan");

//        DAY
//        1. locate the day dropdown
        WebElement day = driver.findElement(By.id("day"));
//        2. create select
        Select selectDay = new Select(day);
//        3. select the day using select object
        selectDay.selectByVisibleText("10");

//        YEAR
//        1. locate the year dropdown
        WebElement year = driver.findElement(By.id("year"));
//        2. create select
        Select selectYear = new Select(year);
//        3. select the day using select object
        selectYear.selectByVisibleText("2000");


//        Selecting gender and clicking
        driver.findElement(By.xpath("//input[@value='2']")).click();

//        locating Sign Up and clicking
        driver.findElement(By.name("websubmit")).click();







    }
}
