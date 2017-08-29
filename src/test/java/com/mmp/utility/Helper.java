package com.mmp.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	public static String captureScreenshot(WebDriver driver, String ssName){
		TakesScreenshot tsh = (TakesScreenshot)driver;
		
		File src = tsh.getScreenshotAs(OutputType.FILE);
		//String destination = "./Screenshots/"+ssName+System.currentTimeMillis()+".png";
		String destination = "C:\\Minu\\Training\\H2k\\Sudheer\\Assignments\\Java\\MMP_Hybrid\\Screenshots\\"+
																		ssName+System.currentTimeMillis()+".png";
		try {
			FileUtils.copyFile(src, new File(destination));
		} catch (IOException e) {
			
			System.out.println("Failed to capture screenshot" + e.getMessage());
		}
		return destination;	
	}

}
