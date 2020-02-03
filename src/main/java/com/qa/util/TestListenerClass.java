package com.qa.util;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.commons.io.FileUtils;

import com.qa.base.BasePage;

public class TestListenerClass extends BasePage implements ITestListener{
	
	String filePath = "C:\\Users\\parmod.kumar\\git\\HubSpot\\HubSpot\\screenshots";

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Exception occured ...."+result.getTestName()+"test failed");
		String methodName=result.getMethod().toString().trim();
		ITestContext context=result.getTestContext();
		WebDriver driver=(WebDriver)context.getAttribute("driver");
		getScreenShot(methodName,driver);
		
	}
	
	public void getScreenShot(String methodName,WebDriver driver) {
		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 try {
				FileUtils.copyFile(scrFile, new File(filePath+methodName+".png"));
				System.out.println("***Placed screen shot in "+filePath+" ***");
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
