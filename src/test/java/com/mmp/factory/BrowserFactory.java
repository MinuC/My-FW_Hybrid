package com.mmp.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	static WebDriver driver;
	
	public static WebDriver getBrowser(String browserName){
		
		//ConfigDataReader config = new ConfigDataReader();// initializing above so that all 4 places can use it
		
		// Since we have created an object in DataProviderFactory, we do not need the above line. 
		// please refer line#23 to see how we are calling that property
		
		if (browserName.equalsIgnoreCase("Firefox"))
		{
			//System.setProperty("webdriver.gecko.driver", config.getGeckoPath());
			System.setProperty("webdriver.gecko.driver", DataProviderFactory.getConfig().getGeckoPath());
			driver = new FirefoxDriver();
		}
		
		else if (browserName.equalsIgnoreCase("Chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", config.getChromePath());
			System.setProperty("webdriver.chrome.driver", DataProviderFactory.getConfig().getChromePath());
			driver = new ChromeDriver();
		}
		
		else if (browserName.equalsIgnoreCase("IE"))
		{
			//System.setProperty("webdriver.ie.driver", config.getIEPath());
			System.setProperty("webdriver.ie.driver", DataProviderFactory.getConfig().getIEPath());
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	
	public void openUrl(){
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
	}
	
	public static void closeBrowser( ){
		driver.quit();
	}

}
