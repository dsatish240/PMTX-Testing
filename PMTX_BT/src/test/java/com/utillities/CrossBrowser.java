package com.utillities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowser {
	
	
    static WebDriver driver = null;
	
	public static WebDriver browserInit(String browser) throws InterruptedException
	{

		if(browser.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();	
           
		}else if (browser.equalsIgnoreCase("chrome")) { 

			//Initialize the chrome driver
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();  

		} else if (browser.equalsIgnoreCase("edge")) { 

			//Initialize the edge driver
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} 
		return driver;
	}
}
