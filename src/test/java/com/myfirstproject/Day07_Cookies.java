package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class Day07_Cookies extends TestBase {

    @Test
    public void cookieTest(){
        driver.get("https://www.amazon.com");
//1. Find the total number of cookies
        Set<Cookie> allCookies = driver.manage().getCookies();
        int cookieSize = allCookies.size();
        System.out.println("Original Cookie Size : "+cookieSize); //Mine is 7
//2. Print all the cookies
        for (Cookie eachCookie : allCookies){
            System.out.println("Cookie : "+eachCookie);
        }
        for (Cookie eachCookie : allCookies){
            System.out.println("Cookie Name : "+eachCookie.getName());
        }
        for (Cookie eachCookie : allCookies){
            System.out.println("Cookie Value : "+eachCookie.getValue());
        }
//3. Get the cookies by their name
        System.out.println("COOKIE NAMED : "+driver.manage().getCookieNamed("i18n-prefs"));
//4. Add new cookie
        Cookie cookie = new Cookie("My-Fav-Cookie","White-Chcololatte");
        driver.manage().addCookie(cookie);
        Set<Cookie> newCookies = driver.manage().getCookies();
        System.out.println("New Cookie Size : "+newCookies.size());

//5. Delete cookie by name
        driver.manage().deleteCookieNamed("session-id");
        Set<Cookie> newCookies1 = driver.manage().getCookies();
        System.out.println("New Cookie Size : "+newCookies1.size());


//6. Delete all of the cookies
        driver.manage().deleteAllCookies();
        Set<Cookie> newCookies2 = driver.manage().getCookies();
        System.out.println("New Cookie Size : "+newCookies2.size());
    }

}
