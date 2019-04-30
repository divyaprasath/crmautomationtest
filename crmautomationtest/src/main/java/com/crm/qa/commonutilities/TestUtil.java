package com.crm.qa.commonutilities;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static String TESTDATA_SHEET_PATH = "C:\\Users\\Prasath\\eclipse-workspace\\crmautomationtest\\src\\main\\java\\com\\crm\\qa\\testdata\\crmtestdata.xlsx";
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	public static Sheet sheet;
	public static Workbook book;

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i=0; i<sheet.getLastRowNum(); i++) {
        	for (int j=0; j<sheet.getRow(0).getLastCellNum(); j++){
        		data[i][j] = sheet.getRow(i+1).getCell(j) .toString();        	
        		}
        }
        return data; 
	}
   
}
