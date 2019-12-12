package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.BasePage;

public class LoginPage extends BasePage{
	
	//Obeject repo /page factory
	@FindBy(xpath="//input[@id='username1']")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//button[@id='loginBtn']")
	WebElement loginButton;
	
	@FindBy(xpath="//i18n-string[contains(text(),'Forgot my password')]")
	WebElement forgotPassword;
	
	@FindBy(xpath="//i18n-string[@data-key='login.signupLink.cta']")
	WebElement signUpButton;
	
	@FindBy(xpath="//i18n-string[contains(text(),'Privacy Policy')]")
	WebElement privacyPolicyLink;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//methods 
	public String validateLoginPageTitle() {
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.titleIs("HubSpot Login"));
		 String title=driver.getTitle();
		return title;
	}
	
	public SignUpPage clickOnSignUpLink() {
		signUpButton.click();
		return new SignUpPage();
	}
	
    public ForgotPasswordPage clickOnForgotMyPasswordLink() {
    	forgotPassword.click();
    	return new ForgotPasswordPage();
	}
    
    public PrivacyPolicyPage clickOnPrivacyPolicyLink() {
    	privacyPolicyLink.click();
    	return new PrivacyPolicyPage();
		
	}

   public HomePage login(String uname,String pass) {
	   username.sendKeys(uname);
	   password.sendKeys(pass);
	   loginButton.click();
	   
	   return new HomePage();
   }

}
