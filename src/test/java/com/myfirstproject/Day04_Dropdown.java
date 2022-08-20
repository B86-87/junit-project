package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Day04_Dropdown {

//Go to https://the-internet.herokuapp.com/dropdown
//1.Create method selectByIndexTest and Select Option 1 using index
//2.Create method selectByValueTest Select Option 2 by value
//3.Create method selectByVisibleTextTest Select Option 1 value by visible text
//4.Create method printAllTest Print all dropdown value
//5.Verify the dropdown has Option 2 text
//6.Create method printFirstSelectedOptionTest Print first selected option
//7.Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void selectByIndexTest(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
//        1. locate the dropdown
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));

//        2. Crete Select class
        Select select = new Select(dropdownElement);

//        3. Select any option using select object

//        Create method selectByIndexTest and Select Option 1 using index
        select.selectByIndex(1);//index starts at 0

    }

    @Test
    public void selectByValueTest(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
//        1. locate the dropdown
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));

//        2. Crete Select class
        Select select = new Select(dropdownElement);

//        3. Select any option using select object
//       Create method selectByValueTest Select Option 2 by value
        select.selectByValue("2"); //selecting Option 2

    }

    @Test
    public void selectByVisibleText(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
//        1. locate the dropdown
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));

//        2. Crete Select class
        Select select = new Select(dropdownElement);

//        3. Select any option using select object
//        Create method selectByVisibleTextTest Select Option 1 value by visible text
        select.selectByVisibleText("Option 1");
    }
}
