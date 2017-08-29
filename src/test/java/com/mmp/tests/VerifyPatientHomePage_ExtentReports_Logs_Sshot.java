package com.mmp.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
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
import com.mmp.pages.PatientHomePage;
import com.mmp.pages.PatientLoginPage;
import com.mmp.utility.Helper;
import com.mmp.utility.Navigator;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class VerifyPatientHomePage_ExtentReports_Logs_Sshot {
	
WebDriver driver;

MMPHomePage mmpHome;
PatientLoginPage pLogin;
PatientHomePage pHome;

ExtentReports report;
ExtentTest logger;


	@BeforeMethod
	public void setUp(){
		driver = BrowserFactory.getBrowser("Firefox");
		
		report = new ExtentReports(".\\Reports\\Suite_PatientHomePage.html", true);
		logger = report.startTest("Verifying PatientHomePage - Logs and reports added");
		
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());	
		logger.log(LogStatus.INFO, "Application up and running");	
	}
	
	@Test(priority=0)
	public void verifyTitle() throws InterruptedException{
	
		mmpHome = PageFactory.initElements(driver, MMPHomePage.class);
		
		String mmpTitle = mmpHome.verifyTitle();
		Assert.assertEquals(mmpTitle, "NAMTG");	
		//System.out.println("MMP Title is: "+ mmpTitle);
		//logger.log(LogStatus.PASS, "MMPHomePage - Titles are matching");
		logger.log(LogStatus.PASS, logger.addScreenCapture(Helper.captureScreenshot(driver, "mmpHome")));
	}	
	
	@Test(priority=1)
	public void appLogin() throws InterruptedException{
		
		mmpHome = PageFactory.initElements(driver, MMPHomePage.class);
		
//		WebDriverWait wait = new WebDriverWait(driver,30);
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Patient Login']")));
		mmpHome.navigateToPatientLoginPage();
		
		logger.log(LogStatus.INFO, "Navigated to PatientLoginPage");
		
		pLogin = PageFactory.initElements(driver, PatientLoginPage.class);
		//pLogin.loginToAppln("TomBrady_123", "TomBrady@123");//passing parametre values manually
		
		/*loginToApp method in PatientLoginPage is returning the username. Assigning that value to string user.
		Reading login credentials from Excel sheet*/
		pLogin.loginToAppln(DataProviderFactory.getExcel().getCellData(0, 0, 0), DataProviderFactory.getExcel().getCellData(0, 0, 1));
		
		logger.log(LogStatus.PASS, "Logged in to PatientHomePage");
		logger.log(LogStatus.PASS, logger.addScreenCapture(Helper.captureScreenshot(driver, "PatientHome")));// ADDING A SCREENSHOT
	/*}	
		
	@Test(description="Verify Title & Username - PatientHomePage", dependsOnMethods = {"appLogin"})
	public void validateTitleAndUsername(){*/
		
		pHome = PageFactory.initElements(driver, PatientHomePage.class);
		
		String pTitle = pHome.getPortalTitle();
		Assert.assertEquals(pTitle, "Patient Portal");
		logger.log(LogStatus.PASS, "PHP - Portal titles are matching");
		
		String user = pHome.verifyUser();
		//System.out.println("Valid user: "+ user);
		//Assert.assertTrue(user.contains("TomBrady"));
		Assert.assertEquals(user, "TomBrady_123");
		//Assert.assertEquals(user, "Brian","User names not matching");
		
		logger.log(LogStatus.PASS, "In PatientHomePage - Validated user");
	}	
	
	@AfterMethod
	public void tearDown(ITestResult result){ // result variable will store the complete execution result
		if (result.getStatus()== ITestResult.FAILURE)
		{
			String path = Helper.captureScreenshot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));// This is in case if there is a failure
		}
		
		BrowserFactory.closeBrowser();
		report.endTest(logger);
		report.flush();
	}	
}
