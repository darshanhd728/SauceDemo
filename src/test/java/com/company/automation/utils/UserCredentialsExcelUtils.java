package com.company.automation.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class UserCredentialsExcelUtils {

    private static Workbook workbook;
    private static Sheet sheet;

    public static Object[][] getTestData(String sheetName){

        Object[][] data = null;

        try{
            FileInputStream fis = new FileInputStream("src/test/resources/testdata/loginCredentials.xlsx");
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);

            int rows = sheet.getPhysicalNumberOfRows();
            int cols = sheet.getRow(0).getPhysicalNumberOfCells();

            data = new Object[rows -1][cols];

            for(int i =1; i< rows; i++) {
                for(int j = 0; j<cols; j++){
                    data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }
}
