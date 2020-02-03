package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BasePage;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class HomePageTest extends BasePage{
	
	public HomePage homePage;
	public LoginPage loginPage;
		
	public HomePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage=new HomePage();
		loginPage=new LoginPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=3)
	public void validatClickOnContactsLinkTest() {
		homePage.validatClickOnContactsLink();
		String actual=driver.getTitle();
		System.out.println(actual);
		Assert.assertEquals(actual, "Contacts");
	}
	
	@Test(priority=2)
	public void validateUserLabelPresentOnHomePageTest() {
		Assert.assertTrue(homePage.validateUserLabelPresent(), "User Label is not Present");
		
	}
	
	@Test(priority=2)
	public void validateHomePageTitleTest() {
		String actual=((HomePage) homePage).validateHomePageTitle();
		Assert.assertEquals(actual, "HubSpot Login");
	}
	
	@Test(priority=4)
	public void validateClickOnReportsLinkTest() {
		homePage.validatClickOnReportssLink();
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Reports");
	}
	
	@Test(priority=5)
	public void validateClickOnConversationLinkTest() {
		homePage.validatClickOnConversationsLink();
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Inbox");
	}
	
	@Test(priority=6)
	public void validateclickOnImageIconTest() {
		homePage.validatClickOnImageIcon();
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "HubSpot Login","Sign Up not happened, Try again");
	}
	
	@Test(priority=7)
	public void validateSearchBoxTest() {
		homePage.validatSearchBox();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
