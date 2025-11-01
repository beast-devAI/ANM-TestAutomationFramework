package com.sgm.utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.text.DefaultFormatter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class ExcelReader {


    private static final String filePath = "src/main/resources/SGMTestUserData.xlsx";

    static XSSFSheet sheet;

    static String sheetName = "Login_creds";

    public static String[][] getTestDataFromExcel() throws IOException, ParseException {

        sheet = new XSSFWorkbook(new FileInputStream(new File(filePath))).getSheet(sheetName);

        int totalNoOfRows = sheet.getPhysicalNumberOfRows();
        int totalNoOfcolums = sheet.getRow(0).getLastCellNum();

        String[][] data = new String[totalNoOfRows - 1][totalNoOfcolums];


        for (int i = 0; i < totalNoOfRows - 1; i++) {

            for (int j = 0; j < totalNoOfcolums; j++) {

                data[i][j] =sheet.getRow(i + 1).getCell(j).getStringCellValue() ;

            }


        }


        return data;

    }


}
