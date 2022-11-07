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
import com.utillities.ExcelData;

public class TestEmployeePage {
	
	WebDriver driver;
	EmployeePageObjects obj;
	
	@Parameters("browser")
	@BeforeTest
	public void browserInit(String browser) throws IOException
	{
		
		 if(browser.equalsIgnoreCase("firefox")) {
				
			  WebDriverManager.firefoxdriver().setup();
			  driver = new FirefoxDriver();	
			  

		  }else if (browser.equalsIgnoreCase("chrome")) { 

			  //Initialize the chrome driver
			//driver = new ChromeDriver();
			  
			 WebDriverManager.chromedriver().setup();
//			 ChromeOptions options = new ChromeOptions();
//			 options.addArguments("--disable-web-security");
//			 options.addArguments("--user-data-dir=/tmp/chrome_dev_test");
//			 driver = new ChromeDriver(options);
			 driver = new ChromeDriver();
			 
		  } else if (browser.equalsIgnoreCase("edge")) { 

			  //Initialize the edge driver
			  WebDriverManager.edgedriver().setup();
			  driver = new EdgeDriver();
			  
			  
		  } 
		  else if (browser.equalsIgnoreCase("ie")) { 

			  //Initialize the InternetExplorer driver
			  WebDriverManager.iedriver().setup();
			  driver = new InternetExplorerDriver();
			  
		  } 
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
		//EmployeePageObjects obj=new EmployeePageObjects(driver);
		obj.addTask(taskName, taskDescription);
		
		//span[text()='Learn .net']
	}
	
	@Test(priority=4)
	public void verifyAddedTaskInPendingSection() throws Exception
	{
		String taskName = ExcelData.getTaskCellData(1, 0);
		//EmployeePageObjects obj=new EmployeePageObjects(driver);
		obj.AddedTaskVerifiCation(taskName);
		
	}
//	@Test(priority=5)
//	public void verifyPendingToCompleted() throws Exception
//	{
//		String taskName = ExcelData.getTaskCellData(1, 0);
//		//EmployeePageObjects obj=new EmployeePageObjects(driver);
//		obj.pendingToCompleted(taskName);
//		
//	}
	
	
//	
//	@Test(priority=7)
//	public void verifyAddTaskWithoutGivingTaskName() throws Exception
//	{
//		String taskDescription = ExcelData.getTaskCellData(1,1);
//		//EmployeePageObjects obj=new EmployeePageObjects(driver);
//		obj.addTaskWithoutGivingTaskName(taskDescription);
//	}
//	@Test(priority=8)
//	public void verifyAddTaskWithoutGivingDescription() throws Exception
//	{
//		String taskName = ExcelData.getTaskCellData(1, 0);
//		//EmployeePageObjects obj=new EmployeePageObjects(driver);
//		obj.addTaskWithoutGivingTaskDescription(taskName);
//		
//	}
//	
//	public void verifyAddTaskWithoutGivingTaskNameAndTaskDescription() throws InterruptedException
//	{
//		obj.addTaskWithoutGivingTaskNameAndTaskDescription();
//	}
//	
//	@Test(priority=10)
//	public void verifyUnaddedTaskInPendingSection() throws Exception
//	{
//		String taskName = ExcelData.getTaskCellData(1, 0);
//		EmployeePageObjects obj=new EmployeePageObjects(driver);
//		//obj.unaddedTaskInPendingSection(taskName);
//	}
//	
//	@Test(priority=11)
//	public void verifyIncompledTaskInCompletedSection() throws Exception
//	{
//		String taskName ="***"; //ExcelUtils.taskData(1, 0);
//		obj.incompledTaskInCompletedSection(taskName);
//	}
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
