package com.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.base.BasePage;
import com.qa.pages.ForgotPasswordPage;
import com.qa.pages.LoginPage;


public class ForgotPasswordPageTest extends BasePage{
	
	public LoginPage loginPage;
	public ForgotPasswordPage forgotPasswordPage;
	
	
	public ForgotPasswordPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
		forgotPasswordPage=new ForgotPasswordPage();
		loginPage.clickOnForgotMyPasswordLink();
		//driver.navigate().refresh();
	}
	
	@Test(enabled=true)
	public void resetPasswordTest() {
		
		forgotPasswordPage.resetPassword();
		driver.findElement(By.xpath("//i18n-string[@data-key='login.requestReset.header']")).submit();
		String helpText=driver.findElement(By.xpath("//i18n-string[@data-key='login.requestReset.success.header']")).getText();
		
		System.out.println(helpText);
		Assert.assertEquals(helpText, "Help is on the way","Customized message : Something is wrong while resetting the password");
	}
	
	@Test(enabled=false)
	public void goBackToLoginPageTest() {
		forgotPasswordPage.goBackToLoginPage();
		String actual=driver.getTitle();
        Assert.assertEquals(actual, "HubSpot Login");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
