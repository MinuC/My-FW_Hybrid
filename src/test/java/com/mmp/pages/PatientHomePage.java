
package com.mmp.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PatientHomePage {
	WebDriver driver;
	
	/*public PatientHomePage(WebDriver driver) {
		this.driver = driver;
	}*/
	
	//@FindBy(xpath="html/body/div[1]/nav/div[2]/ul/li/a/span") WebElement validUser;
		@FindBy(how=How.XPATH, using="html/body/div[1]/nav/div[2]/ul/li/a/span")
		@CacheLookup
		WebElement validUser;
	
		@FindBy(css=".panel-title") 
		@CacheLookup WebElement portalTitle;
		
	public String verifyUser(){
		String name = validUser.getText();
		return name;
	}
	
	public String getPortalTitle(){
		String title = portalTitle.getText();
		return title;
	}
	
	
	/*public String getTitle(){
	String title = driver.findElement(By.cssSelector(Utility.prop.getProperty("patienthomepage_Title"))).getText();
	//System.out.println("\nLoginToApp Title: "+ title);
	log.info("Captured HomePage- Title");
	return title;	
}*/
	
	/*public String getUsername(){
		//Thread.sleep(6000);
		//String username = driver.findElement(By.xpath("//h3[contains(text(),'Selenium')]")).getText();// not working
		//String username = driver.findElement(By.cssSelector(".page-header")).getText();
		//String username = driver.findElement(By.cssSelector("div.col-mod-12>h3.page-header")).getText();
		String username = driver.findElement(By.xpath(Utility.prop.getProperty("patienthomepage_Username"))).getText();
		log.info("Captured Username upon Login");
		return username;	
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean clickViewHistoryButton() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver,60);

		//using explicitly wait command for given webElement
		WebElement viewHistoryButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='View History']")));
		//Clicking on viewhiStorybutton
		viewHistoryButtonElement.click();

		System.out.println("GOING INTO SLEEP...");
		Thread.sleep(20000);
		System.out.println("OUT OF SLEEP..");

		//here we are using wait command
		WebElement pastAppointmentButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Past Appointments']")));
		pastAppointmentButton.sendKeys(Keys.ENTER);
		WebElement patientPortal = wait .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".panel-title")));
		return patientPortal.isDisplayed();
	}	
	
	public String getFirstName(){
		String fName = driver.findElement(By.id("fname")).getAttribute("value");
		//System.out.println("\nfName: "+ fName);
		return fName;
	}
	public String getLastName(){
		String lName = driver.findElement(By.id("lname")).getAttribute("value");
		//System.out.println("lName: " + lName);
		return lName;
	}
	public boolean verifyViewHistoryOption(String option){
		  boolean result = driver.findElement(By.cssSelector("input[value='" + option + "']")).isDisplayed();
		  return result;
	}
	public String getLicense(){
		String license = driver.findElement(By.id("licn")).getAttribute("value");
		//System.out.println("license: " +license);
		return license;
	}
	public String getSSN(){
		String SSN = driver.findElement(By.id("ssn")).getAttribute("value");
		//System.out.println("SSN: " + SSN);
		return SSN;
	}
	public String getZipCode(){
		String zipCode = driver.findElement(By.id("zip")).getAttribute("value");
		//System.out.println("zipCode: " + zipCode+ "\n");
		return zipCode;
	}

	public void clickCreateNewAppointmentButton(){
		//driver.findElement(By.xpath("//input[@type='submit']")).sendKeys(Keys.ENTER); // Create New Appointment Button
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	public void selectDoctor(String doctor){
		//driver.findElement(By.cssSelector(".table>tbody>tr>td:nth-of-type(4)>button#opener")).click(); // Selecting 4th dr to book Appointment 
		// Xpath to click on <appointment> button as per the given Dr: "//h4[contains(text(),'Dr.Charlie')]/ancestor::ul/following-sibling::button"
		driver.findElement(By.xpath("//h4[contains(text(),'"+ doctor +"')]/ancestor::ul/following-sibling::button")).click();
	}
	public void enterAppointmentDate(String date){
		driver.switchTo().frame("myframe");
		WebElement appDate = driver.findElement(By.cssSelector("#datepicker"));
		appDate.sendKeys(date);
		appDate.sendKeys(Keys.TAB);
		appDate.sendKeys(Keys.ENTER);
	}
	public void selectAppointmentTime(String time){
		WebElement dropdown = driver.findElement(By.id("time"));
		Select select = new Select(dropdown);
		select.selectByValue(time);
		
		/*String st="11Am";
		List<WebElement> list=select.getAllSelectedOptions();
		for(WebElement li : list)
		{
			if(li.getText().equalsIgnoreCase(st))
				select.selectByValue(time);
			break;
		}*/
	}
	public void clickContinueButton(){
		driver.findElement(By.cssSelector("#ChangeHeatName")).click();//Click on <Continue> button
	}
	public void enterSymptom(String symptom){
		driver.switchTo().defaultContent();
		driver.findElement(By.cssSelector("#sym")).sendKeys(symptom);
	}
	public void clickSubmitButton(){
		driver.findElement(By.cssSelector(".panel.panel-cascade>div>input")).click(); //Submit button
	}
	public boolean verifySelectedTime(String time){
		boolean result = driver.findElement(By.id("time")).isDisplayed();
		//System.out.println(result); 
		return result;
	}
	public boolean verifyEnteredSymptom(String symptom){
		boolean result = driver.findElement(By.xpath("//table/tbody/tr/td[3][contains(text(),'"+ symptom +"')]")).isDisplayed();
		//System.out.println(result); 
		return result; 
	}
	public boolean verifySelectedDoctor(String doctor){
		String dr[] = doctor.split("\\."); // Dr.Richard
		String drName = dr[1];
		boolean result = driver.findElement(By.xpath("//table/tbody/tr/td[4][contains(text(),'"+ drName +"')]")).isDisplayed();
		//System.out.println(result); 
		return result; 
	}
}
