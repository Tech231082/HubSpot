package com.qa.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BasePage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.ReportsPage;

public class ReportsPageTest extends BasePage{
	
	public LoginPage loginPage;
	public ReportsPage reportsPage;
	public HomePage homePage;
	Logger log=Logger.getLogger("");
	
	public ReportsPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
		reportsPage=new ReportsPage();
		homePage=new HomePage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test
	public void validateReportsPageTitleTest() {
		homePage.validatClickOnReportssLink();
		
		
		WebElement element=driver.findElement(By.xpath("//li[@class='expandable currentPage active']//div[@class='secondary-nav"
				+ " expansion']//ul//li//div[contains(text(),'Reports')] "));
		
		element.click();
		log.debug("clicking of element"+element);
		System.out.println(reportsPage.getReportsPageTitle());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
