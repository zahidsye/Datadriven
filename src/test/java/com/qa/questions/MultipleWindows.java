package com.qa.questions;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindows {
public static WebDriver driver;

@BeforeMethod
public static void LaunchBrowser() {
	System.setProperty("webdriver.chrome.driver", "/Users/Zahid/Desktop/selenium/BrowserDrivers/chromedriver_win32/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@Test
public static void JavaAlert () throws InterruptedException {
	driver.get("https://www.toolsqa.com/automation-practice-switch-windows/");
	driver.findElement(By.cssSelector("#alert")).click(); 
	Thread.sleep(2000);
	Alert alert = driver.switchTo().alert(); 
	System.out.println(alert.getText()); 
	String alertText = alert.getText();
	if(alertText.equals("Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.")) 
	{
	  System.out.println("Test Passed");
	  alert.accept(); 
	  } 
	else {
	  System.out.println("Test Failed"); 
	  }
	driver.close();
	}

@Test
public static void FileUploadWindow() {
	driver.get("https://www.toolsqa.com/automation-practice-form/");
	driver.findElement(By.xpath("//input[@id=\"photo\"]")).sendKeys("C:/Users/Zahid/Desktop/rent receipt/Apr.jpg");
	driver.close();
	}

@Test
public static void BrowserPopUp() {
	driver.get("https://www.toolsqa.com/automation-practice-switch-windows/");
	driver.findElement(By.xpath("//button[@id=\"button1\"]")).click();
	Set <String> handler= driver.getWindowHandles();
	Iterator <String> it = handler.iterator();
	String ParentWindowId = it.next();
	String ChildWindowId = it.next();
	driver.switchTo().window(ChildWindowId);
	System.out.println("Child Window Title "+ driver.getTitle());
	driver.close();
	driver.switchTo().window(ParentWindowId);
	System.out.println("Parent Window Title "+ driver.getTitle());
	driver.close();
}

@Test
public static void BrowserTab() {
	driver.get("https://www.toolsqa.com/automation-practice-switch-windows/");
	driver.findElement(By.cssSelector("#content > p:nth-child(6) > button")).click();
	Set <String> handler = driver.getWindowHandles();
	Iterator <String> it = handler.iterator();
	String ParentWindowId = it.next();
	String ChildWindowId = it.next();
	driver.switchTo().window(ChildWindowId);
	System.out.println("Child Window Title "+ driver.getTitle());
	driver.close();
	driver.switchTo().window(ParentWindowId);
	System.out.println("Parent Window Title "+ driver.getTitle());
	driver.close();
}

@Test
public static void frames() {
	driver.get("https://www.toolsqa.com/iframe-practice-page/");
	driver.switchTo().frame("iframe1");
	driver.findElement(By.name("firstname")).sendKeys("Hello");
	driver.close();
	
}

}
