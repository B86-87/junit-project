package com.myfirstproject.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadExcel {
//    Workbook > Worksheet > Row > Cell
    @Test
    public void readExcel() throws IOException {
//        Path of the workbook
        String path = "./src/test/java/resources/capitals.xlsx";
//        String path = ".\\src\\test\\java\\resources\\capitals.xlsx";// windows

//        Access the file
        FileInputStream fileInputStream = new FileInputStream(path);

//        Open the workbook
        Workbook workbook = WorkbookFactory.create(fileInputStream);

//        Open the first worksheet
        Sheet sheet1 = workbook.getSheetAt(0);//getting the first sheet in the excel. index stars at 0.
//        Sheet sheet1 = workbook.getSheet("Sheet1");//getting by name

//        Go to the first row
        Row row1 = sheet1.getRow(0);//index starts at 0

//        Go to the first cell
        Cell cell1 = row1.getCell(0);//index starts at 0
        System.out.println(cell1);//Prints Country

//        Go to row 1 cell 2 and print
        Cell r1c2 = row1.getCell(1);
        System.out.println(r1c2);//Capital
//        Go to row 2,  cell 1  and assert if the data equal to USA
        String r2c1 = sheet1.getRow(1).getCell(0).toString();//we can chain the methods
        System.out.println(r2c1);
        Assert.assertEquals("USA",r2c1);
//        Go to row3 cell2-chain the row and cell
        Cell r3c2 = sheet1.getRow(2).getCell(1);
        System.out.println(r3c2);

//        Find the number of row
        int numberOfRow = sheet1.getLastRowNum() + 1;//index starts at 0
        System.out.println(numberOfRow);

//        Find the number of used row
        int physicalRowNum=sheet1.getPhysicalNumberOfRows();//index starts at 1. returns only the used row count
        System.out.println(physicalRowNum);

//        Print country, capitol key value pairs as map object
        Map<String,String> capitals = new HashMap<>();

//        loop the country-capital sheet
//        starting row number = 1(EXCLUDE THE HEADER)
        for (int rowNum = 1;rowNum < numberOfRow; rowNum++){

//            String country = sheet1.getRow(rowNum).getCell(0).toString();
//            System.out.println(country);
//            String capital = sheet1.getRow(rowNum).getCell(1).toString();
//            System.out.println(capital);
////            Adding teh key value pairs in the map
//            capitals.put(country,capital);

//            We can shorten the code like this
            capitals.put(sheet1.getRow(rowNum).getCell(0).toString(), sheet1.getRow(rowNum).getCell(1).toString());

        }
        System.out.println(capitals);

    }
}
