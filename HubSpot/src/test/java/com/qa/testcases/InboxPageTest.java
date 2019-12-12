package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BasePage;
import com.qa.pages.HomePage;
import com.qa.pages.InboxPage;
import com.qa.pages.LoginPage;
import com.qa.util.Constants;

public class InboxPageTest extends BasePage{
	
	public LoginPage loginPage;
	public HomePage homePage;
	public InboxPage inboxPage;
	
	public InboxPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
	initialization();
	homePage=new HomePage();
	loginPage=new LoginPage();
	inboxPage=new InboxPage();
	loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	homePage.validatClickOnConversationsLink();
	
	}
	@Test
	public void getTitleOfInboxPage() {
		System.out.println(inboxPage.getInboxPageTitle());
		Assert.assertEquals(inboxPage.getInboxPageTitle(), Constants.INBOX_PAGE_TITLE);
	}
	
	@Test
	public void validateHelloLabelTest() {
		inboxPage.validateHelloLabel();
	}
	
	@Test
	public void validateComposeButtonTest() {
		inboxPage.validateComposeButton();
	}

}
