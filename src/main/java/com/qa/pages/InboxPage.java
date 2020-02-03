package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BasePage;

public class InboxPage extends BasePage{
	
	//page elements
	@FindBy(xpath="//i18n-string[@data-key='conversations-inbox-ui.zero-state.connectNewChannel.title']")
	WebElement sayHelloLabel;
	
	@FindBy(xpath="//i18n-string[@data-key='conversations-inbox-ui.floating-email-communicator.buttonLabel']")
	WebElement composeButton;
	
	//constructor
	public InboxPage() {
		PageFactory.initElements(driver, this);
	}
	
	//methods
	
	public boolean validateHelloLabel() {
		return sayHelloLabel.isDisplayed();
	}
	
	public void validateComposeButton() {
		composeButton.click();
	}

	public String getInboxPageTitle() {
		return driver.getTitle();
	}
}
