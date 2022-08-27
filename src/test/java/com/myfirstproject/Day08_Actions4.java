package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day08_Actions4 extends TestBase {

//    Create a class: Action4
//    Create a method dragAndDropTest
//    Given user is on https://jqueryui.com/droppable/
//    And user moves the target element(Drag me to my target) in to destination(Drop here)

    @Test
    public void dragAndDropTest(){
        driver.get("https://jqueryui.com/droppable/");

//        the elements are inside the iframe so switch to the iframe
        driver.switchTo().frame(0);

//        locations the source adn hte target
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

//        use actions to drag the source on teh target
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source,target).perform();

    }

    @Test
    public void clickAndHoldTest(){
        driver.get("https://jqueryui.com/droppable/");

//        the elements are inside the iframe so switch to the iframe
        driver.switchTo().frame(0);

//        locations the source adn hte target
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

//        use actions to drag the source on teh target
        Actions actions = new Actions(driver);

//        actions.clickAndHold(source).moveToElement(target).build().perform();//WORKS!
        actions.clickAndHold(source).moveByOffset(462,-18).build().perform();

    }



}
