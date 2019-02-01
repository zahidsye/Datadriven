package com.qa.questions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class exceptions {
WebDriver driver;
@BeforeMethod
public void LaunchBrowser() {
	System.setProperty("webdriver.chrome.driver", "/Users/Zahid/Desktop/selenium/BrowserDrivers/chromedriver_win32/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
@AfterMethod
public void CloseBrowser() {
	driver.close();
}

@Test
public void NoSuchElementException() {
	driver.get("http://demo.automationtesting.in/Register.html");
		try {
			driver.findElement(By.xpath("//input[@placeholder=\"First Name123\"]")).sendKeys("Zahid");
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("INVALID XPATH AND BEC OF THAT NO SUCH ELEMENT EXCEPTION");
			//throw(e);
		}
}
@Test
public void ElementNotVisibleException() {
	driver.get("http://www.omayo.blogspot.com");
	try {
		driver.findElement(By.id("hbutton")).click();
	} catch (Exception e) {
		
		e.printStackTrace();
		System.out.println("BUTTON HIDDEN AND BEC OF THAT ELEMENT NOT VISIBLE EXCEPTION");
		//throw(e);
	}
}
@Test
public void NoSuchFrameException() {
	driver.get("http://www.omayo.blogspot.com");
	try {
		driver.switchTo().frame("xyz");
		driver.findElement(By.linkText("Cruises")).click();
	} catch (Exception e) {
		System.out.println("INVALID FRAME ID AND BEC OF THAT No Such Frame Exception ");
		e.printStackTrace();
		//throw(e);
	}
}
@Test
public void StaleElementRefereneException() {
	driver.get("http://www.omayo.blogspot.com");
	WebElement wb = driver.findElement(By.id("link1"));
	wb.click();
	driver.navigate().back();
		
	try {
		wb.click();
	} catch (Exception e) {
		
		e.printStackTrace();
		driver.navigate().refresh();
		wb = driver.findElement(By.id("link1"));
		wb.click();
	}	
}
}
