package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Day09_WebTables extends TestBase {
    private static Logger logger = LogManager.getLogger(Day09_WebTables.class.getName());

    @Test
    public void printTable(){
//    https://the-internet.herokuapp.com/tables
        logger.info("Going to the main page");
        driver.get("https://the-internet.herokuapp.com/tables");
//    Task 1 : Print the entire table

        logger.info("***Print Entire Table***");
//        System.out.println("***Print Entire Table***");
        String table = driver.findElement(By.xpath("//table[@id='table1']")).getText();
        System.out.println(table);

        logger.info("***Print All Table Data***");
//        System.out.println("***Print All Table Data***");
        List<WebElement> allData = driver.findElements(By.xpath("//table[@id='table1']//td"));
        for (WebElement eachData : allData){
            System.out.println(eachData.getText());
        }
        System.out.println("10th data in the table : " + allData.get(10).getText());

        logger.info("TESTING COMPLETE. YAAAAAYYYYYYYYY");
    }


//    Task 2 : Print All Rows
    @Test
    public void printAllRows(){
        driver.get("https://the-internet.herokuapp.com/tables");
        System.out.println("***Print All Rows***");

        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']//tr"));

        int count =1;
        for (WebElement eachRow : allRows){
            System.out.println("Row Num "+count+" => "+eachRow.getText());
            count++;
        }

        System.out.println("Row 4 data ===>>> "+allRows.get(3).getText() );
//    Task 3 : Print Last row data only
        System.out.println("Last Row ===>>> "+allRows.get(allRows.size()-1).getText());
    }


//    Task 4 : Print column 5 data in the table body
    @Test
    public void printColumns(){
        driver.get("https://the-internet.herokuapp.com/tables");
        System.out.println("***Print Column 5***");

        List<WebElement> column5 = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td[5]"));
        for (WebElement each : column5){
            System.out.println(each.getText());
        }

    }

    @Test
    public void printDataTest(){
        printData(2,3);//fbach@yahoo.com
        printData(4,5);//http://www.timconway.com
        printData(4,5,"table1");//table 1 4th row,5th col
        printData(4,5,"table2");//table 2 4th row, 5th col

    }
//    Task 5 : Write a method that accepts 2 parameters
    public void printData(int rowNum, int colNum){

        driver.get("https://the-internet.herokuapp.com/tables");

                                //table[@id='table1']//tbody//tr[5]//td[5]
                                //table[@id='table1']//tbody//tr[1]//td[2]
                                //table[@id='table1']//tbody//tr[2]//td[3]
        String xPath = "//table[@id='table1']//tbody//tr["+rowNum+"]//td["+colNum+"]";
        WebElement targetElement = driver.findElement(By.xpath(xPath));
        System.out.println(targetElement.getText());
    }

    public void printData(int rowNum, int colNum, String tableID){
        driver.get("https://the-internet.herokuapp.com/tables");
        String xPath = "//table[@id='"+tableID+"']//tbody//tr["+rowNum+"]//td["+colNum+"]";
        WebElement targetElement = driver.findElement(By.xpath(xPath));
        System.out.println(targetElement.getText());
    }




//    Parameter 1 = row number
//    Parameter 2 = column number
//    printData(2,3);  => prints data in 2nd row 3rd column
}
