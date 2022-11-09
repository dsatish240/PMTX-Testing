package com.testScenarios;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.pageFactory.LoginPageObjects;
import com.utillities.CrossBrowser;
import com.utillities.ExcelData;
import com.utillities.ScreenShots;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

public class TestLoginPage {

	/*
	 * browser Initialization
	 * launch the Brower
	 * Enter the url
	 * Checking the Authorized User 
	 * Taking Screenshot
	 * Logout
	 * close the browser
	 */

	/*
	 * browser Initialization
	 * launch the Brower
	 * Enter the url
	 * Check the UnAuthorized User 
	 * Taking Screenshot
	 * close the browser
	 */

	WebDriver driver = null;
	LoginPageObjects obj=null;
	ScreenShots sc = null;

	@SuppressWarnings("deprecation")
	@BeforeMethod              // PreCondition
	@Parameters("browser")
	public void browserInit(String browser) throws InterruptedException
	{
		
        driver = CrossBrowser.browserInit(browser); 
		driver.manage().window().maximize();
		driver.get("https://pmt-x.vercel.app/login");
		obj = new LoginPageObjects(driver);
		sc = new ScreenShots(driver);	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}

	@Test(priority = 1)
	public void verifyLoginPageTitle() {

		String expectedTitle = "PMT-X";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle,expectedTitle,"Page title doesnt match");
		System.out.println("The page title has been successfully verified");

	} 


	@Test(priority = 2)
	public void loginRegisteredUser() throws IOException, InterruptedException{

		String username = ExcelData.getCellData(1,0);
		String password = ExcelData.getCellData(1,1);
		obj.login(username, password);
		Thread.sleep(5000);
		sc.takeScreenShotforLogin("Screenshot/");
		obj.logout();

	}

	@Test(priority = 3)
	public void loginUnregisteredUser() throws IOException, InterruptedException{

		String username = ExcelData.getCellData(2,0);
		String password = ExcelData.getCellData(2,1);
		obj.login(username, password);
		obj.waitForElement(driver);		
		sc.takeScreenShotforLogin("Screenshot/");

	}

	@Test(priority = 4)
	public void loginWithEmptyEmail() throws IOException, InterruptedException{

		String username = ExcelData.getCellData(3,0);
		String password = ExcelData.getCellData(3,1);
		obj.login(username, password);
		String actualErrorMessage = obj.errorEmail.getText();
		String expectedErrorMessage = "Email is required.";
		Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
		sc.takeScreenShotforLogin("Screenshot/");

	}

	@Test(priority = 5)
	public void loginWithEmptyPassword() throws IOException, InterruptedException{

		String username = ExcelData.getCellData(4,0);
		String password = ExcelData.getCellData(4,1);
		obj.login(username, password);
		String actualErrorMessage = obj.errorPassword.getText();
		System.out.println(actualErrorMessage);
		String expectedErrorMessage = "Password is required.";
		Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
		sc.takeScreenShotforLogin("Screenshot/");
		
	}

	@Test(priority = 6)
	public void loginWithEmptyEmailAndPassword() throws IOException, InterruptedException{

		String username = ExcelData.getCellData(5,0);
		String password = ExcelData.getCellData(5,1);
		obj.login(username, password);
		String actualErrorMessage1 = obj.errorPassword.getText();
		String expectedErrorMessage1 = "Password is required.";
		String actualErrorMessage2 = obj.errorEmail.getText();
		String expectedErrorMessage2 = "Email is required.";
		Assert.assertEquals(actualErrorMessage1,expectedErrorMessage1);
		Assert.assertEquals(actualErrorMessage2,expectedErrorMessage2);
		sc.takeScreenShotforLogin("Screenshot/");

	}

	@Test(priority = 7)
	public void verifyEyeIcon(){

		obj.eyeIcon.click();
		obj.eyeIcon.getText();

	} 


	@AfterMethod    //PostCondition
	public void tearDown() throws IOException{     
		driver.close();	

	}

}
