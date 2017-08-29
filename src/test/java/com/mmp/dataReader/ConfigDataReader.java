package com.mmp.dataReader;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

/*


*/
public class ConfigDataReader {
	Properties pro;

	public ConfigDataReader(){

		File src = new File("./ConfigData/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);	
		} 
		catch (Exception e) {
			System.out.println("Exception is: "+e.getMessage());
			//e.printStackTrace();
		}
	}

	public String getIEPath(){

		String path = pro.getProperty("IEPath");
		return path;
	}

	public String getChromePath(){

		String path = pro.getProperty("chromePath");
		return path;
	}

	public String getGeckoPath(){

		String path = pro.getProperty("geckoPath");
		return path;
	}

	public String getApplicationUrl(){

		String url = pro.getProperty("Url");
		return url;
	}


}
