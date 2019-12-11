package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.base.BasePage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
@Listeners(com.qa.util.TestListenerClass.class)
public class LoginPageTest extends BasePage{
	
	public LoginPage loginPage;
	public HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
	}
	
	@Test(priority=1)
	public void LoginPageTitleTest() {
		String title=loginPage.validateLoginPageTitle();
		System.out.println(title);
		
		Assert.assertEquals(title, "HubSpot Login");
	}
	
	
	
	@Test(priority=2)
	public void loginTest() {
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String actual=driver.getTitle();
		System.out.println(actual);
		//Assert.assertEquals(actual, expected);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
