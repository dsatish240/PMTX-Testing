package com.pageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class EmployeePageObjects {
	
	WebDriver driver;
	
	@FindBy(how = How.XPATH,using ="//*[@id=\"root\"]/main/div/div[1]/div/div/div[3]/button") 
	private  WebElement addTaskButton;
	
	@FindBy(how = How.XPATH,using ="//*[@id=\"taskName\"]") 
	private  WebElement taskName;
	
	@FindBy(how = How.XPATH,using ="//*[@id=\"description\"]") 
	private  WebElement taskDescription;
	
	@FindBy(how = How.XPATH,using ="//*[@id=\"root\"]/main/div/div[2]/form/div[3]/button") 
	private WebElement addButton;
	
	
	@FindBy(how = How.ID,using ="rc-tabs-0-tab-1") 
	private WebElement pending;
	
	@FindBy(how = How.ID,using ="rc-tabs-0-tab-2") 
	private WebElement completed;
	
	
	//WebElement for logOutButton
	@FindBy(how = How.CLASS_NAME,using ="logOutBtn-0-2-4") //*[@id="root"]/div[1]/button   logOutBtn-0-2-4
	private WebElement logoutButton;
	
//	@FindBy(how = How.CLASS_NAME,using ="completedBtn-0-2-22")

	public EmployeePageObjects(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		

	}
	
	public void addTask(String task_name,String task_description) throws InterruptedException
	{
		//WebDriverWait wait=new WebDriverWait(driver, 20);
		
		Thread.sleep(5000);
		addTaskButton.click();
		taskName.sendKeys(task_name);
		Thread.sleep(1000);
		taskDescription.sendKeys(task_description);
		Thread.sleep(1000);
		addButton.click();
		//WebDriverWait wait=new WebDriverWait(driver, 20);
		Thread.sleep(5000);
	}
	
	public void AddedTaskVerifiCation(String taskName)
	{
		
		pending.click();
		
		//driver.findElement (By.xpath("logOutBtn-0-2-11")).click();
		String path="//span[text()='"+taskName+"']";  //span[text()='Learn .net']
		driver.findElement (By.xpath(path));
		
	}
	public void pendingToCompleted(String taskName)
	{
		pending.click();
		//String path="//span[text()='"+taskName+"']";  
		WebElement element=driver.findElement(By.xpath("//*[@id=\"rc-tabs-0-panel-1\"]/div/div/div[1]"));
		element.click();
		String task_name=element.getText();
		driver.findElement(By.cssSelector("#rc-tabs-0-panel-1 > div > div > div.ant-collapse-content.ant-collapse-content-active > div > div > button")).click();
		
		completed.click();
		String path="//span[text()='"+task_name+"']";  //span[text()='Learn .net']
		driver.findElement(By.xpath(path));
		
		
		//completed.click(); //span[text()='kotlin']
		
	}
	
	public void addTaskWithoutGivingTaskName(String  task_description) throws InterruptedException
	{

		Thread.sleep(50000);
		addTaskButton.click();
		Thread.sleep(10000);
		taskDescription.sendKeys(task_description);
		
		addButton.click();
		Thread.sleep(10000);
//		String ExpectedTitle="Task name is required.";
//		String ActualTitle = taskName.getText();
//		System.out.println(ActualTitle);
//		Assert.assertEquals(ExpectedTitle, ActualTitle);
//		Thread.sleep(5000);
//		addTaskButton.click();
//		taskDescription.sendKeys(task_description);
		//driver.findElement(by.id("submit")).click();
//		addButton.click();
//		SoftAssert softAssert = new SoftAssert();
//		softAssert.assertEquals(taskName.getText(), "Task name is required.");
//		//softAssert.assertEquals(taskDescription.getText(), "Last Name is required");
//		softAssert.assertAll();
		
		
		
	}
	
	public void addTaskWithoutGivingTaskDescription(String  task_name) throws InterruptedException
	{
		Thread.sleep(5000);
		addTaskButton.click();
		taskName.sendKeys(task_name);
		Thread.sleep(1000);
		addButton.click();
		Thread.sleep(5000);
	}
	
	public void addTaskWithoutGivingTaskNameAndTaskDescription() throws InterruptedException
	{
		Thread.sleep(5000);
		addTaskButton.click();
		Thread.sleep(1000);
		addButton.click();
		Thread.sleep(5000);
	}
	
	public void unaddedTaskInPendingSection(String  task_name)
	{
		
		
		pending.click();
		String path="//span[text()='"+taskName+"']";
		List<WebElement> m= driver.findElements(By.xpath(path));
	    String actual=Integer.toString(m.size());
	    String expected="0";
	    Assert.assertEquals(actual,expected);
	    
	}
	public void incompledTaskInCompletedSection(String task_name) throws InterruptedException
	{
		completed.click();
        String path="//span[text()='"+task_name+"']";
        List<WebElement> m= driver.findElements(By.xpath(path));
        Thread.sleep(10000);
        
        String actual=Integer.toString(m.size());
        System.out.println(actual);
        String expected="0";
        System.out.println(expected);
        Assert.assertEquals(actual,expected);
		
	}
	
	
	public void logout() throws InterruptedException
	{
		Thread.sleep(1000);
		logoutButton.click();
	}

}

//*[@id="root"]/main/div/div[2]/form/div[3]/button