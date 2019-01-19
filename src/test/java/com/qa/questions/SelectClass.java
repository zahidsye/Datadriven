package com.qa.questions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectClass {
WebDriver driver;

@BeforeMethod
public void LaunchBrowser() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Zahid\\Desktop\\selenium\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
}
@AfterMethod 
public void CloseBrowser() { 
	driver.close();
}
	  
@Test
public void DropDown () {
   driver.get("https://www.freecrm.com/register/"); 
   Select set = new Select(driver.findElement(By.xpath("//Select[@id=\"payment_plan_id\"]")));
   //set.selectByIndex(1);
   //set.selectByValue("5");
   set.selectByVisibleText("Free Edition"); }
	 
@Test
public void MultipleDropDown() {
	driver.get("https://www.freecrm.com/register/");
	Select set = new Select(driver.findElement(By.xpath("//Select[@id=\"payment_plan_id\"]")));
	List<WebElement> elementCount = set.getOptions();
	System.out.println(elementCount.size());
	int count = elementCount.size();
	
	for (int i=0; i<count;i++) {
		String sValue = elementCount.get(i).getText();
		System.out.println(sValue);
		set.selectByIndex(i);
	}
	
}

}
