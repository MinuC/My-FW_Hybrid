package com.mmp.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mmp.factory.BrowserFactory;
import com.mmp.factory.DataProviderFactory;
import com.mmp.pages.MMPHomePage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class VerifyMMPHomePage_SuiteLevel {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	MMPHomePage mmpHome;

	@BeforeMethod
	public void setUp(){
		driver = BrowserFactory.getBrowser("Firefox");
		report = new ExtentReports(".\\Reports\\Suite_MMPHomePage.html",true);
		logger = report.startTest("Verify MMPHome Page - Logs and reports added");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());	
		logger.log(LogStatus.INFO, "Application up and running");	
	}
	
	@Test(priority=0)
	public void verifyTitle() throws InterruptedException{
		mmpHome = PageFactory.initElements(driver, MMPHomePage.class);

		String mmpTitle = mmpHome.verifyTitle();
		Assert.assertEquals(mmpTitle, "NAMTG");
		logger.log(LogStatus.PASS, "HomePage titles are matching");
		System.out.println("MMP Title is: "+ mmpTitle);	
	}
	
	@AfterMethod
	public void reportCapture(){
		BrowserFactory.closeBrowser();
		report.endTest(logger);
		report.flush();
	}

}
