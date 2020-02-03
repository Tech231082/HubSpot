package com.qa.testData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;

import com.qa.base.BasePage;

public class TestDataClass extends BasePage{
	
	static Workbook book;
	static Sheet sheet;
	//static JavascriptExecutor js;
	
	public static String testDataSheetPath="C:\\Users\\parmod.kumar\\eclipse-workspace\\HubSpot\\src\\main\\java\\com\\qa\\testData\\hubspot.xlsx";
	
	public static Object[][] getTestData(String sheetName) {
		
	 FileInputStream fis=null;
		try {
			fis=new FileInputStream(testDataSheetPath);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		try {
			book=WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		sheet=book.getSheet(sheetName);		
		int rowCount=sheet.getLastRowNum();
		int colCount=sheet.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[rowCount][colCount];
		
		for(int i=0;i<rowCount;i++) {
			for(int j=0;j<colCount;j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
	
		return data;
	}

}
