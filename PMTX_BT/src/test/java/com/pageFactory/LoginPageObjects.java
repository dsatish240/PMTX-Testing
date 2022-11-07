package com.pageFactory;

import java.time.Duration;

import org.openqa.selenium.By;
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
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/button")
	public WebElement logout;
	
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div[2]/span[1]")
	public WebElement errorEmail;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div[2]/span[2]")
	public WebElement errorPassword;
	
	
	
	
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

}
