/*package com.mmp.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mmp.pages.MMPHomePage;
import com.mmp.pages.PatientHomePage;
import com.mmp.pages.PatientLoginPage;
import com.mmp.utility.Navigator;

// Integrated code

public class MMPTest {
	WebDriver driver;
	PatientHomePage pHome = new PatientHomePage(driver);
	SoftAssert sa = new SoftAssert();
	
	@Parameters({"url"})
	@BeforeClass(description="Launching MMP Application",alwaysRun = true)
	public void LaunchApplication(String url) 
	{
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
	//	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	//	driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url); 
		pHomePage = new PatientHomePage(driver);
	}

	@Parameters({"username","password"})
	@Test(priority=1)
	public void verifyLogin(String uname,String pword) throws InterruptedException
	{
		MMPHomePage mmpHomePage = new MMPHomePage(driver);
		mmpHomePage.navigateToPatientLoginPage();
		PatientLoginPage pLoginPage = new PatientLoginPage(driver);
		//pLoginPage.login(uname,pword);

	}
	@Parameters({"expFName", "expLName","expLicense", "expSSN", "expZipCode"})
	@Test(description="TC003: Verify Profile tab Data",priority=2)
	public void verifyDataInProfileTab(String expFName, String expLName, String expLicense, String expSSN, String expZipCode )throws InterruptedException{

		Navigator.navigateToTab("Profile", driver);
		
		sa.assertEquals(pHomePage.getFirstName(),expFName);
		sa.assertEquals(pHomePage.getLastName(),expLName);
		sa.assertEquals(pHomePage.getLicense(),expLicense);
		sa.assertEquals(pHomePage.getSSN(),expSSN);
		sa.assertEquals(pHomePage.getZipCode(),expZipCode);
		sa.assertAll();
	}

	@Test(description="TC004: Verify the Navigation History->Past Transactions->Profile",priority=4)
	public void verifyPastTransactions() throws InterruptedException
	{
		Navigator.navigateToTab("Profile", driver);
		boolean result = pHomePage.clickViewHistoryButton();
		Assert.assertTrue(result);
	}
	
	@Parameters({"doctor","date","time","symptom"})
	@Test(description="TC005: Verify the ScheduleAppointment",priority=5)
	public void verifyScheduleAppointment(String doctor, String date, String time, String symptom) throws InterruptedException
	{
		Navigator.navigateToTab("Schedule Appointment", driver);

		pHomePage.clickCreateNewAppointmentButton(); 	
		pHomePage.selectDoctor(doctor);
		pHomePage.enterAppointmentDate(date);
		pHomePage.selectAppointmentTime(time);
		pHomePage.clickContinueButton();
		pHomePage.enterSymptom(symptom);
		pHomePage.clickSubmitButton();
		
		sa.assertTrue(pHomePage.verifySelectedTime(time));
		sa.assertTrue(pHomePage.verifyEnteredSymptom(symptom));
		sa.assertTrue(pHomePage.verifySelectedDoctor(doctor));
		sa.assertAll();
	}
	
	@AfterClass
	public void exitApplication() throws InterruptedException{
		Navigator.navigateToTab("Logout", driver);
		driver.quit();
	}


}















*/