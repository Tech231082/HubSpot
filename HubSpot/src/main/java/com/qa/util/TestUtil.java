package com.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtil {
	public static int PAGE_LOAD_TIMEOUT=20;
	public static int IMPLICITLY_WAIT=20;
	
	public static String filePath = "C:\\Users\\parmod.kumar\\git\\HubSpot\\HubSpot\\screenshots";
	
	public static void getScreenShot(String methodName,WebDriver driver) {
		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 try {
				FileUtils.copyFile(scrFile, new File(filePath+methodName+System.currentTimeMillis()+"\\"+".png"));
				System.out.println("***Placed screen shot in "+filePath+" ***");
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
 
}
