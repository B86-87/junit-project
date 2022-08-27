package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class Day08_Actions3 extends TestBase {

    @Test
    public void pageUpDownTest() throws InterruptedException {
//        Go to techproeducation
        driver.get("https://www.amazon.com");
//        Scroll the page down

//        PAGE_DOWN  = scrollDown
        Actions actions = new Actions(driver);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        actions.sendKeys(Keys.PAGE_DOWN).perform();



//        We can chain multiple actions methods. Then we should use build().perform()
//        .build() is used when there are multiple commands on the same actions
//        .perform() is used when there is single or multiple commands on the same actions
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();

        Thread.sleep(2000);

//        ARROW_DOWN = scrollDown
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);

//        Scroll the page up
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.ARROW_UP).perform();

    }
}
