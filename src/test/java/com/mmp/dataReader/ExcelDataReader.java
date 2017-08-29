package com.mmp.dataReader;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReader {
	XSSFWorkbook wb;
	
	public ExcelDataReader(){
		
		File src = new File("./ApplicationTestData/AppData.xlsx");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);} 
		
		catch (Exception e) {	
			System.out.println("Exception is: "+e.getMessage());
			//e.printStackTrace();
		}	
	}
	
	public String getCellData(int sheetIndex, int row, int col){
		String data = wb.getSheetAt(sheetIndex).getRow(row).getCell(col).getStringCellValue();
		return data;
	}
	
	public String getCellData(String sheetName, int row, int col){
		String data = wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
		return data;
	}

}
