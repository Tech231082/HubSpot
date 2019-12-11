package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BasePage;

public class ReportsPage extends BasePage{
	
	//page objects
	@FindBy(xpath="//div//h1[@class='private-header__heading']")
	WebElement reportsLabel;
	
	public ReportsPage() {
		PageFactory.initElements(driver, this);
	}
	
	//page methods
	public boolean validateReportsLabel() {
		return reportsLabel.isDisplayed();
	}
	
	public String getReportsPageTitle() {
		return driver.getTitle();
	}

}
