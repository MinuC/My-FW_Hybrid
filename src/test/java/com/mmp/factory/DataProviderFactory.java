package com.mmp.factory;

import com.mmp.dataReader.ConfigDataReader;
import com.mmp.dataReader.ExcelDataReader;
import com.mmp.dataReader.ORDataReader;


public class DataProviderFactory {
	
	public static ConfigDataReader getConfig(){ // static so that I can directly call
		
		ConfigDataReader config = new ConfigDataReader();// creating and returning the object
		return config;
	}
	
	public static ExcelDataReader getExcel(){ // static so that I can directly call
		
		ExcelDataReader excel = new ExcelDataReader();// creating and returning the object
		return excel;
	}
	
	public static ORDataReader getObject(){ // static so that I can directly call
		
		ORDataReader or = new ORDataReader();// creating and returning the object
		return or;
	}

}
