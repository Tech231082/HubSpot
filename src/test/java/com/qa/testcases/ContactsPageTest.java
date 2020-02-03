package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.BasePage;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.testData.TestDataClass;

public class ContactsPageTest extends BasePage{
	
	public LoginPage loginPage;
	public HomePage homePage;
	public ContactsPage contactsPage;
	//public String sheetName="hubspot";
	public String sheetName="hubspot";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
		homePage=new HomePage();
		contactsPage=new ContactsPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.validatClickOnContactsLink();
	}
	
	@Test(priority=1)
	public void validateContactLabelPresentTest() {
		
		Assert.assertTrue(contactsPage.validateContactLabelPresent(),"Contacts Label is not present on Page");
	}
	
	@DataProvider
	public Object[][] getHubSpotTestData() {
		Object[][] data=TestDataClass.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2,dataProvider="getHubSpotTestData")
	public void createContactsTest(String email,String firstname,String lastname,String job) {
		//contactsPage.createContacts("email@hubspot.com","Ricky","Richmond","Teacher");
		contactsPage.createContacts(email, firstname, lastname, job);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
