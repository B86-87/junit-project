package com.myfirstproject.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Day09_WriteExcel {

    @Test
    public void writeExcel() throws IOException {
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

//        Create a cell on the 3rd column (2nd index) on the first row
        Cell r1c3 = row1.createCell(2);
//        Write “POPULATION” on that cell
        r1c3.setCellValue("POPULATION");
//        Create a cell on the 2nd row 3rd cell(index2), and write 150000
        sheet1.getRow(1).createCell(2).setCellValue("150000");

//        Create a cell on the 3rd row 3rd cell(index2), and write 250000
        sheet1.getRow(2).createCell(2).setCellValue("250000");
//        Create a cell on the 4th row 3rd cell(index2), and write 54000
        sheet1.getRow(3).createCell(2).setCellValue("54000");
//        Write and save the workbook

        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);
//        Close the file
        fileInputStream.close();
        fileOutputStream.close();
//        Close the workbook
        workbook.close();
    }
}
