package com.qa.testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BasePage;
import com.qa.pages.LoginPage;
import com.qa.pages.PrivacyPolicyPage;
import com.qa.util.Constants;

public class PrivacyPolicyPageTest extends BasePage{
	
	public LoginPage loginPage;
	public PrivacyPolicyPage privacyPolicyPage;
	
	public PrivacyPolicyPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initialization();
		loginPage=new LoginPage();
		privacyPolicyPage=new PrivacyPolicyPage();
		
		loginPage.clickOnPrivacyPolicyLink();
	}
	
	@Test(enabled=false)
	public void validateHubSpotPrivacyPolicyLabelTest() {
		privacyPolicyPage.validateHubSpotPrivacyPolicyLabel();
	}
	
	@Test
	public void validateHubSpotPrivacyPolicyTitleTest() {
		//WebDriverWait wait=new WebDriverWait(driver,10);
		//wait.until(ExpectedConditions.titleIs(Constants.PRIVACY_POLICY_PAGE_TITLE));
		System.out.println(privacyPolicyPage.getHubSpotPrivacyPolicyPageTitle());
		//Assert.assertEquals(privacyPolicyPage.getHubSpotPrivacyPolicyPageTitle(), Constants.PRIVACY_POLICY_PAGE_TITLE);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	

}
