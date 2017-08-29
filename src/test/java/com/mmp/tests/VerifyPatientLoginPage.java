package com.mmp.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mmp.factory.BrowserFactory;
import com.mmp.factory.DataProviderFactory;
import com.mmp.pages.MMPHomePage;
import com.mmp.pages.PatientLoginPage;

public class VerifyPatientLoginPage {
	
WebDriver driver;
MMPHomePage mmpHome;

	@BeforeMethod
	public void setUp() {
	
	driver = BrowserFactory.getBrowser("Firefox");
	driver.get(DataProviderFactory.getConfig().getApplicationUrl());
	}
	
	@Test(priority=0)
	public void verifyTitle() throws InterruptedException{
	
		mmpHome = PageFactory.initElements(driver, MMPHomePage.class);
		
		String mmpTitle = mmpHome.verifyTitle();
		Assert.assertEquals(mmpTitle, "NAMTG");
		//System.out.println("MMP Title is: "+ mmpTitle);
	}	
	
	@Test(priority=1)
	public void appLogin() throws InterruptedException{
		
		mmpHome = PageFactory.initElements(driver, MMPHomePage.class);
		mmpHome.navigateToPatientLoginPage();
		
		PatientLoginPage pLogin = PageFactory.initElements(driver, PatientLoginPage.class);
		//pLogin.loginToAppln("TomBrady_123", "TomBrady@123");//passing parametre values manually
		
		/*loginToApp method in PatientLoginPage is returning the username. Assigning that value to string user.
		Reading login credentials from Excel sheet*/
		pLogin.loginToAppln(DataProviderFactory.getExcel().getCellData(0, 0, 0), DataProviderFactory.getExcel().getCellData(0, 0, 1));
		 
	}	
		
	@AfterMethod
		public void tearDown(){
		BrowserFactory.closeBrowser();
	}

}
