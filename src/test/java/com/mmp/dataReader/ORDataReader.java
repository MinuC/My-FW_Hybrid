package com.mmp.dataReader;


	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;

	import org.openqa.selenium.WebDriver;

	public class ORDataReader {
		
			Properties prop;// Here prop should be public and static to access across all pages
			
		public ORDataReader(){
			
			  File src = new File("./ObjRepo/OR.properties");

			  try {
				FileInputStream fis = new FileInputStream(src);
				prop = new Properties();
				prop.load(fis);
				System.out.println("Properties class loaded");
			} 
			  catch (Exception e) {
				  
				  System.out.println("Exception is: "+e.getMessage());
			}

			
		}

	}



