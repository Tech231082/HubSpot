package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.BasePage;

public class SignUpPage extends BasePage{
	
	@FindBy(xpath="//input[starts-with(@id,'uid-firstName-')]")
	WebElement firstname;
	
	@FindBy(xpath="//input[starts-with(@id,'uid-lastName-')]")
	WebElement lastname;
	
	@FindBy(xpath="//input[starts-with(@id,'uid-email-')]")
	WebElement email;
	
	@FindBy(xpath="//button[@class='uiButton private-button--primary private-loading-button layout-submit-button text-center private-button--"
			+ "primary private-button private-button--default private-button--non-link']")
	WebElement nextButton;
	
	

	//page factory elements initialization
	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//methods
	
	
	
	public void signUp(String fname,String lname,String emailID ) {
		/*WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visi);*/
		driver.findElement(By.xpath("//i18n-string[@data-key='login.signupLink.cta']")).click();
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		email.sendKeys(emailID);
		
		nextButton.click();
		
		String text=driver.findElement(By.xpath("//i18n-string[@data-key='core.emailVerification.checkYourEmail.title']")).getText();
		System.out.println(text);
		
	}
	
	
	
}
