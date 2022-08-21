package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

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
//4.Create method printAllTest Print all dropdown value
    @Test
    public void printAllTest(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //        1. locate the dropdown
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));

//        2. Crete Select class
        Select select = new Select(dropdownElement);

//        get all of the dropdown options
        List<WebElement> allOptions = select.getOptions();
        for (WebElement eachOption : allOptions){
            System.out.println(eachOption.getText());

        }

        //5.Verify the dropdown has Option 2 text
        boolean flag =false;
        for (WebElement eachOption : allOptions){
//            checking if Option 2 is in the dropdown
//            if it is in the dropdown, then flag=true, then assertion will pass
            if(eachOption.getText().equals("Option 2")){
                flag=true;
                System.out.println("Option 2 EXIST");
            }
        }
        Assert.assertTrue(flag);//FAILS if flag is false. PASS if flag is true. It will be true if dropdown has option 2

//        6.Create method Print first selected option
        WebElement firstSelectedOption = select.getFirstSelectedOption();
        System.out.println("DEFAULT SELECTED OPTION : "+firstSelectedOption.getText());

//        7.Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.
        int dropdownSize = allOptions.size();
        System.out.println("Dropdown Size : "+dropdownSize);
//        Below assertion prints "Expected Is Not Equal Actual" if expected is not equal to actual
        Assert.assertEquals("Expected Is Not Equal Actual",3,dropdownSize);


    }
    @After
    public void tearDown(){
        driver.quit();
    }


}
