package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.WindowType;

public class Day06_WindowHandle2 extends TestBase {


    @Test
    public void newWindowTest(){

//     Open techproeducation on window 1
        driver.get("https://www.techproeducation.com");
        System.out.println("TechPro Title : "+driver.getTitle());
        String techProHandle = driver.getWindowHandle();



//        Open amazon on a new window 2
        driver.switchTo().newWindow(WindowType.WINDOW);//create and switch a new window
        driver.get("https://www.amazon.com");
        System.out.println("Amazon Title : "+driver.getTitle());
        String amazonHandle= driver.getWindowHandle();

//      Open linkedin on a new window 3
        driver.switchTo().newWindow(WindowType.WINDOW);//create and switch a new window
        driver.get("https://www.linkedin.com");
        System.out.println("Linkedin Title : "+driver.getTitle());
        String linkedinHandle = driver.getWindowHandle();

        driver.switchTo().window(techProHandle);




    }


}
