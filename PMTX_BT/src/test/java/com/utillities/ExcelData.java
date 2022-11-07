package com.utillities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelData {
	
	static XSSFWorkbook wb1;
	static {
		
		File src = new File("./Automation.xlsx");
    	
    	FileInputStream fis;
		try {
			 fis = new FileInputStream(src);
			 wb1 = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
	}

	   
	    public static String getCellData(int Rownum, int Colnum) throws IOException {
	    	

			XSSFSheet sheet1 = wb1.getSheetAt(0);
	    	
	    	String data=sheet1.getRow(Rownum).getCell(Colnum).getStringCellValue();
	    	
	    	return data;
	    		
	    }
	    
            public static String getTaskCellData(int Rownum, int Colnum) throws IOException {
    	    	
    			XSSFSheet sheet1 = wb1.getSheetAt(1);
    	    	
    	    	String data=sheet1.getRow(Rownum).getCell(Colnum).getStringCellValue();
    	    	
    	    	return data;
    	    		
    	    }     
            
            public static String getManagerCellData(int Rownum, int Colnum) throws IOException {
    	    	
    			XSSFSheet sheet1 = wb1.getSheetAt(2);
    	    	
    	    	String data=sheet1.getRow(Rownum).getCell(Colnum).getStringCellValue();
    	    	
    	    	return data;
    	    		
    	    } 
            
            
            
         
	    
	    
}