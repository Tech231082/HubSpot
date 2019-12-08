package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.BasePage;

public class ContactsPage extends BasePage{
	
	//contacts page page factory/or
	@FindBy(xpath="//i18n-string[@data-key='genericTypes.capitalized.CONTACT']")
	WebElement contactLabel;
	
	@FindBy(xpath="//span[contains(text(),'Create contact')]")
    WebElement createContact;	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//page methods
	public boolean validateContactLabelPresent() {
		return contactLabel.isDisplayed();
	}

	public String createContacts(String email,String firstname,String lastname,String job) {
		createContact.click();
		String childWindow=driver.getWindowHandle();
		System.out.println(childWindow);
		driver.switchTo().window(childWindow);
		
		WebElement emailID=driver.findElement(By.xpath("//input[starts-with(@id,'UIFormControl-')][@data-field='email']"));
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(emailID));
		
		emailID.sendKeys(email);
		
		
		driver.findElement(By.xpath("//input[starts-with(@id,'UIFormControl-')][@data-field='firstname']")).sendKeys(firstname);
		driver.findElement(By.xpath("//input[starts-with(@id,'UIFormControl-')][@data-field='lastname']")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[starts-with(@id,'UIFormControl-')][@data-field='jobtitle']")).sendKeys(job);
		driver.findElement(By.xpath("//div[@class='private-spinner private-loading-button__spinner private-spinner--primary UILoadingSpinner__SpinnerOuter-cg1l6x-0 lhGoru']//div[@class='UILoadingSpinner__ResultSpinner-cg1l6x-3 hmrpRd'] ")).click();
		
		WebElement contactCreatedLabel=driver.findElement(By.xpath("//i18n-string[@data-key='profileContentTimeline.timelineTitle.eventCreateSource.CONTACT']"));
		String s=contactCreatedLabel.getText();
		System.out.println();
		return s;
		
	}

}
