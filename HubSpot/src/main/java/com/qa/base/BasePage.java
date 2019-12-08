package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.util.TestUtil;
import com.qa.util.WebEventListener;

public class BasePage {
	
	public static WebDriver driver;
	public static Properties prop;
	static FileInputStream fis;
	public static EventFiringWebDriver edriver;
	public static WebEventListener elistener;
	
	public BasePage() {
		
		prop=new Properties();
		
		try {
			fis=new FileInputStream("C:\\Users\\parmod.kumar\\eclipse-workspace\\HubSpot\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void initialization() {
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\mytools\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			
			}
		else if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\mytools\\geckodriver-v0.25.0-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
			
		}
		
		edriver=new EventFiringWebDriver(driver);
		elistener=new WebEventListener();
		edriver.register(elistener);
		driver=edriver;
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
	

}
