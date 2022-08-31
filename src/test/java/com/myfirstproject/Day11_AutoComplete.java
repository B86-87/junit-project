package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Day11_AutoComplete extends TestBase {

    @Test
    public void autoCompleteTest(){

        driver.get("https://jqueryui.com/autocomplete/");
        driver.switchTo().frame(0);
        WebElement inputBox = driver.findElement(By.id("tags"));
        inputBox.sendKeys("Apple");

//        ui-menu-item WILL ONLY BE AVAILABLE AFTER USER TYPE IN THE INPUT
//        TESTER SHOULD MAE A GOOD MANUAL TESTING TO GET OBSERVE THE BEHAVIOUR TO LOCATE THE ELEMENT
        WebElement succession = driver.findElement(By.className("ui-menu-item"));
//        succession.click();//works

//        ALTERNATIVELY i can click with JS
        clickByJS(succession);

    }

    @Test
    public void autoCompleteTest2(){

        driver.get("https://jqueryui.com/autocomplete/");
        driver.switchTo().frame(0);
        WebElement inputBox = driver.findElement(By.id("tags"));
        inputBox.sendKeys("A");

//        ui-menu-item WILL ONLY BE AVAILABLE AFTER USER TYPE IN THE INPUT
//        TESTER SHOULD MAE A GOOD MANUAL TESTING TO GET OBSERVE THE BEHAVIOUR TO LOCATE THE ELEMENT
        List<WebElement> succession = driver.findElements(By.className("ui-menu-item"));

//        Click option Java
        for (WebElement each : succession){
            System.out.println(each.getText());
            if (each.getText().equals("Java")){
                each.click();
                break;
            }
        }
    }
}
