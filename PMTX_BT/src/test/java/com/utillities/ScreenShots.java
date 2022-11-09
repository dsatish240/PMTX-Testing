package com.utillities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShots {

	WebDriver driver;
	String filename;
	File SrcFile;

	public ScreenShots(WebDriver driver) {
		this.driver = driver;	
	}
	
	public void takeScreenShotforLogin(String folderName) {
		
		TakesScreenshot scrShot =((TakesScreenshot)driver);
        SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        filename =  new SimpleDateFormat("yyyyMMddhhmmss'.png'").format(new Date());
	
		File dest = new File(folderName + filename);
		
		try {
			FileUtils.copyFile(SrcFile, dest);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}   

}
