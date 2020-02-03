package com.qa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.BasePage;

public class ForgotPasswordPage extends BasePage{
	
	//page elements
	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath="//button[@id='reset-button']//i18n-string[contains(text(),'Reset your password')]")
	WebElement resetYourPasswordButton;
	
	@FindBy(xpath="//a[contains(text(),'hubspot.com/login')]")
	WebElement goBackToLoginButton;
	
	//class constructor
	
	public ForgotPasswordPage() {
		PageFactory.initElements(driver, this);
	}
	
	//page methods
	
	public void resetPassword() {
		
		email.sendKeys("anything.something@gmail.com");
		
	}
	
	public void goBackToLoginPage() {
		goBackToLoginButton.click();
	}

}
