package com.pageFactory;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class LoginPageObjects {

	
	
	@FindBy(id = "email")
	public WebElement email;
	
	@FindBy(id ="password")
	public WebElement password;
	
	@FindBy(xpath = "//div/button[text()='Login']")
	public WebElement submit;
	
	@FindBy(className = "logOutBtn-0-2-13")
	public WebElement logout;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div[2]/span[1]")
	public WebElement errorEmail;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div[2]/span[2]")
	public WebElement errorPassword;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div[2]/div[1]/div/i")
	public WebElement eyeIcon;
	
	@FindBy(id = "failure")
	public WebElement element;

	
	public LoginPageObjects(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
		
	public void login(String _email, String _password) {
		
		email.sendKeys(_email);
		password.sendKeys(_password);
		submit.click();
	
	}
	
	public void logout() {
		
		logout.click();
	}
	
	public void waitForElement(WebDriver driver) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.visibilityOf(element));    
	   //String loginStatus = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.id("failure"))).getText();
	    String loginStatus = element.getText();
	    String expectedErr = "Incorrect credentials";
		Assert.assertEquals(loginStatus,expectedErr);

	}
	
	public void waitForLogout(WebDriver driver) {
		  
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.visibilityOf(logout));
	    
        WebElement ele = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/button"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", ele);
	}
	
	
	

}
