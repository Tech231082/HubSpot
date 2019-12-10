package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BasePage;

public class ForgotPasswordPage extends BasePage{
	
	//page elements
	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath="//i18n-string[@data-key='login.requestReset.header']")
	WebElement resetYourPasswordButton;
	
	@FindBy(xpath="//span[contains(text(),'Go back to ')]")
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
