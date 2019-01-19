package com.qa.questions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsClass {
public static	WebDriver driver;

@BeforeMethod
public static void LaunchBrowser() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Zahid\\Desktop\\selenium\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
}

@AfterMethod
public static void CloseBrowser() {
	driver.close();
}
@Test
public static void MouseHover () {
	  driver.get("https://automationtalks.com/");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  Actions act = new Actions(driver); 
	  act.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Selenium Tutorial')]"))).build().perform();
	  driver.findElement(By.xpath("//a[contains(text(),'Selenium WebDriver')]")).
	  click();
}

@Test
public static void DragAndDrop() {
	driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
	Actions act = new Actions(driver);
	act.dragAndDrop(driver.findElement(By.xpath("//div[@id=\"draggable\"]")), driver.findElement(By.xpath("//div[@id=\"droppable\"]"))).build().perform();

	
}




}

