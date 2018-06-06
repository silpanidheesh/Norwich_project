package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.apache.commons.io.CopyUtils;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.utils.FileUtil;
import com.qa.base.TestBase;

public class testUtil extends TestBase {
	public testUtil() throws IOException {
		super();
		}
	public static long pageLoadTimeout=100;
	public static long implicitWait=50;
	public static String testDataSheetPath="G:\\acsl\\my_norwich\\src\\main\\java\\com\\qa\\testData\\myNorwichTestData.xlsx";
	static Workbook wbk;
	static Sheet sheet;
	public void waitForClick(WebElement elementPath) {
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(elementPath));
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("kfiDocumentLink")));
	}
	
	public static Object[][] getTestData(String sheetName) throws IOException{
		FileInputStream file=null;
		try {
			file=new FileInputStream(testDataSheetPath);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wbk=WorkbookFactory.create(file);
		}catch(InvalidFormatException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		sheet=wbk.getSheet(sheetName);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();			
				}
		}
	return data;
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir=System.getProperty("user.dir");
		FileUtils.copyFileToDirectory(srcfile, new File(currentDir+"/screenshots/"+ System.currentTimeMillis()+".png"));

	}

	
}
