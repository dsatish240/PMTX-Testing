package com.testScenarios;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import com.pageFactory.EmployeePageObjects;
import com.pageFactory.LoginPageObjects;
import com.utillities.CrossBrowser;
import com.utillities.ExcelData;

public class TestEmployeePage {
	
	WebDriver driver;
	EmployeePageObjects obj;
	
	@Parameters("browser")
	@BeforeTest
	public void browserInit(String browser) throws IOException, InterruptedException
	{
		
		 driver = CrossBrowser.browserInit(browser);
		 driver.manage().window().maximize();
		 driver.get("https://pmt-x.vercel.app/login");
		 obj=new EmployeePageObjects(driver);
		
	}
	

	@Test(priority=1)
	public void signinVerification() throws Exception
	{
		String email = ExcelData.getCellData(1, 0);
		String password = ExcelData.getCellData(1, 1);
		LoginPageObjects obj=new LoginPageObjects(driver);
		obj.login(email, password);
		
	}
	
	
	@Test(priority=3)
	public  void addTask() throws Exception 
	{
		
		String taskName = ExcelData.getTaskCellData(1, 0);
		String taskDescription = ExcelData.getTaskCellData(1, 1);
		obj.addTask(taskName, taskDescription);

	}
	
	@Test(priority=4)
	public void verifyAddedTaskInPendingSection() throws Exception
	{
		String taskName = ExcelData.getTaskCellData(1, 0);
		obj.AddedTaskVerifiCation(taskName);
	}

	@Test(priority=6)
	public  void logoutVerification() throws InterruptedException
	{
		obj.logout();	
	}
	
	@AfterTest
	public void afterTest()
	{
		driver.close();
		
	}

}
