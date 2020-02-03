package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BasePage;

public class PrivacyPolicyPage extends BasePage{
	
	//page objects
	@FindBy(xpath="//div[@class='hsg-page-header__text']//h1[contains(text(),'Legal Stuff')]")
	WebElement hubSpotPrivacyPolicyLabel;
	
	
	public PrivacyPolicyPage() {
		PageFactory.initElements(driver, this);
	}
	
	//page methods
	public boolean validateHubSpotPrivacyPolicyLabel() {
		boolean b=hubSpotPrivacyPolicyLabel.isDisplayed();
		return b;
	}
	
	public String getHubSpotPrivacyPolicyPageTitle() {
		return driver.getTitle();
	}
	

}
