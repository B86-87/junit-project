package com.myfirstproject;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Day10_ExtentReports extends TestBase {

    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;

    @BeforeClass
    public static void extentSetUp(){
        //      REPORT  PATH
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/reports/"+currentTime+"html_report.html";

//        creating HTML report in the path
        extentHtmlReporter = new ExtentHtmlReporter(path);
//        creating extent reports object for generating the Entire reports with configuration
        extentReports = new ExtentReports();

//        ***************
//        adding custom System Info
        extentReports.setSystemInfo("Test Environment","Regression");
        extentReports.setSystemInfo("Application","TechProEd");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Team","Eagles");
        extentReports.setSystemInfo("SQA","John Fox");

//        adding more custom info
        extentHtmlReporter.config().setReportName("TechProEd home page");
        extentHtmlReporter.config().setDocumentTitle("TechProEd extent reports");
//        ********************

//        DONE WITH CONFIGURATION
        extentReports.attachReporter(extentHtmlReporter);

//        REPORT IS DONE. NOW CREATING EXTENT TEST TO LOG INFO IN THE TEST CASE
//        Creating extent test
        extentTest= extentReports.createTest("My Extent Reporter","Regression Test Report");
    }



    @Test
    public void extentReportsTest(){


//        DONE WITH REPORT SET UP. FROM NOW ON USE extentTest object to log information

        extentTest.pass("PASS");
        extentTest.info("INFO");
        extentTest.fail("FAIL");
        extentTest.skip("SKIP");
        extentTest.warning("WARNING");


        extentTest.pass("Going to the application URL");
        driver.get("https:www.techproeducation.com");

        extentTest.pass("Searching QA");
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("QA"+ Keys.ENTER);

        extentTest.pass("Verifying URL has QA keyword");
        Assert.assertTrue(driver.getCurrentUrl().contains("QA"));

        extentTest.pass("Closing the browser");
        driver.quit();


//        Generating the report
        extentReports.flush();


    }
}

