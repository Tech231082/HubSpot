package com.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class WebEventListener implements WebDriverEventListener {

	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before Navigation to  "+driver.getCurrentUrl());
		
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigated to  "+driver.getCurrentUrl());
		
	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("before Navigating Back to : "+driver.getCurrentUrl());
		
	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("After Navigating Back to : "+driver.getCurrentUrl());
		
	}

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("before Navigating forward "+driver.getCurrentUrl());
		
	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println("after Navigating forward "+driver.getCurrentUrl());
		
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		System.out.println("before Navigating refresh "+driver.getCurrentUrl());
		
	}

	public void afterNavigateRefresh(WebDriver driver) {
		System.out.println("After Navigating refresh "+driver.getCurrentUrl());
		
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Finding the element "+element);
		
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("After finding element "+element);
		
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Before clicking on  element..... "+element.getTagName());
		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Element clicked .... "+element.toString());
		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable throwable, WebDriver driver) {
		System.out.println("Exception occured "+throwable.getMessage());
		TestUtil.getScreenShot();
		//TestUtil.getScreenShot(methodName, driver);
		/*try {
			TestUtil.getScreenShot(methodName, driver);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}*/
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub
		
	}
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getTestName()+"test failed");
		String methodName=result.getMethod().toString().trim();
		ITestContext context=result.getTestContext();
		WebDriver driver=(WebDriver)context.getAttribute("driver");
		//TestUtil.getScreenShot();
		
	}
	

}
