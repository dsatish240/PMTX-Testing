package com.testScenarios;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.pageFactory.LoginPageObjects;
import com.utillities.ExcelData;
import com.utillities.ScreenShots;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import java.io.IOException;
import org.testng.Assert;

public class TestManagerPage {

	WebDriver driver;
	LoginPageObjects obj;
	
	
	@BeforeTest
	@Parameters("browser")
	public void browserInit(String browser)
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
		  
		 driver.manage().window().maximize();
		 driver.get("https://pmt-x.vercel.app/login");
		 obj = new LoginPageObjects(driver);
		
		  
}

	@Test(priority = 1)
	public void verifyLoginPageTitle() {
		
		String expectedTitle = "PMT-X";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle,expectedTitle,"Page title doesnt match");
		System.out.println("The page title has been successfully verified");

	}
	

	@Test(priority = 2)
	public void loginasManager() throws IOException, InterruptedException{

		String username = ExcelData.getManagerCellData(1,0);
		String password = ExcelData.getManagerCellData(1,1);
      
		obj.login(username, password);


	}
	
//	@Test(priority = 3)
//	public void hover() {
//		
//		
//		sc.takeScreenShotforManager();
//		driver.findElement(By.className("card-img-0-2-26")).click();
//		sc.takeScreenShotforManager();
//		
//		
//	}
	
	
	@AfterTest
	public void tearDown() throws IOException{     
		driver.close();	

	}


}
