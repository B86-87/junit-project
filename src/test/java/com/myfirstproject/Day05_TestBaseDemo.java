package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;

public class Day05_TestBaseDemo extends TestBase {

    @Test
    public void test1(){
        driver.get("https://www.techproeducation.com");
        System.out.println(driver.getTitle());
    }

    @Test
    public void test2(){
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
    }
}
