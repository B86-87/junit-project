package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Day07_Authentication extends TestBase {

    @Test
    public void basicAuthTest(){
//        https://username:password@URL
//        username : admin
//        password : admin
//        url   : the-internet.herokuapp.com/basic_auth
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth"); //This should let us log in

//        Verify the login is successful
        String message = driver.findElement(By.xpath("//p")).getText();
        Assert.assertTrue(message.contains("Congratulations!"));
    }
}
