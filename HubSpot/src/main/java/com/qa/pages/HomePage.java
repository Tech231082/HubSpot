package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.base.BasePage;

public class HomePage extends BasePage{
	
	//page Objects /object repo
	
	@FindBy(xpath="//span[@data-key='getting-started-ui.header.welcomeToHubSpot']//span[2]")
	WebElement userLabel;
	
	@FindBy(xpath="//a[@id='account-menu']")
	WebElement primaryLink;
	
	@FindBy(xpath="//div[@class='nav-left']//a[@id='nav-primary-contacts-branch']")
	WebElement contactsLink;
	
	@FindBy(xpath="//ul//li[3]//a[@id='nav-primary-conversations-branch']")
	WebElement conversationsLink;
	
	@FindBy(xpath="//ul//li[4]//a[@id='nav-primary-marketing-branch']")
	WebElement marketingLink;
	
	@FindBy(xpath="//ul//li[5]//a[@id='nav-primary-sales-branch']")
	WebElement salesLink;
	
	@FindBy(xpath="//ul//li[6]//a[@id='nav-primary-services-branch']")
	WebElement serviceLink;
	
	@FindBy(xpath="//ul//li[7]//a[@id='nav-primary-automation-branch']")
	WebElement automationLink;
	
	@FindBy(xpath="//ul//li[8]//a[@id='nav-primary-reports-branch']")
	WebElement reportsLink;
	
	@FindBy(xpath="//input[@id='navSearch-input']")
	WebElement searchBox;
	
	@FindBy(xpath="//img[@class=' nav-avatar ']")
	WebElement imageIcon;
	
	//page factory initialization
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//methods
	public String validateHomePageTitle() {
		String title=driver.getTitle();
		System.out.println(title);
		return title;
	}
	
	public boolean validateUserLabelPresent() {
		
		System.out.println(userLabel.getText());
		
		boolean flag=userLabel.isDisplayed();
		return flag;
	}
	
	public void validatClickOnPrimaryLink() {
		primaryLink.click();
	}
	
	public ContactsPage validatClickOnContactsLink() {
		contactsLink.click();
		driver.findElement(By.xpath("//li[@class='expandable active']//div[@class='secondary-nav expansion']//ul//li//div[contains(text(),'Contacts')] ")).click();
		return new ContactsPage();
	}
	
	public InboxPage validatClickOnConversationsLink() {
		conversationsLink.click();
		driver.findElement(By.xpath("//li[@class='expandable active']//div[@class='secondary-nav expansion']//ul//li//a[@id='nav-secondary-inbox'] ")).click();
		return new InboxPage();
	}
	
	public void validatClickOnAutomationLink() {
		automationLink.click();
	}
	
	public ReportsPage validatClickOnReportssLink() {
		reportsLink.click();
		driver.findElement(By.xpath("//li[@class='expandable active']//div[@class='secondary-nav expansion']//ul//li//div[contains(text(),'Reports')] ")).click();
		return new ReportsPage();
	}
	
	public void validatClickOnServicessLink() {
		serviceLink.click();
	}
	public void validatClickOnSalessLink() {
		salesLink.click();
	}
	
	public void validatSearchBox() {
		searchBox.click();
		searchBox.sendKeys("HubSpot Inc");
		WebElement searchResults=driver.findElement(By.xpath("//div[@class='navSearch-headerText']"));
		System.out.println(searchResults.getText());
		
	}
	
	public void validatClickOnImageIcon() {
		imageIcon.click();
		driver.findElement(By.xpath("//a[@id='signout']")).click();
	}

	
}
