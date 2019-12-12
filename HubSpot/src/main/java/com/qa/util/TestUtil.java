package com.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.base.BasePage;

public class TestUtil extends BasePage{
	public static int PAGE_LOAD_TIMEOUT=20;
	public static int IMPLICITLY_WAIT=20;
	
	public static String filePath = "C:\\Users\\parmod.kumar\\git\\HubSpot\\HubSpot";
	
	public static void getScreenShot() {
		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 try {
				FileUtils.copyFile(scrFile, new File(filePath+"\\screenshots1\\"+System.currentTimeMillis()+".png"));
				System.out.println("***Screenshot taken ******* ");
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
 
}
