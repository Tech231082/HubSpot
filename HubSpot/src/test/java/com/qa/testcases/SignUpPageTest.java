package com.qa.testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BasePage;
import com.qa.pages.LoginPage;
import com.qa.pages.SignUpPage;

public class SignUpPageTest extends BasePage{
	
	public LoginPage loginPage;
	public SignUpPage signUpPage;
	
	public SignUpPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
		signUpPage=new SignUpPage();
		
	}
	
	@Test
	public void validateSignUpTest() {
		loginPage.clickOnSignUpLink();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		signUpPage.signUp("some", "thing", "someone.everything@gmail.com");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
