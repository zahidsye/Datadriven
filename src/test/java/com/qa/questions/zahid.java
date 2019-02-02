package com.qa.questions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class zahid {
WebDriver driver;
@BeforeMethod
public void LaunchBrowser() {
	System.setProperty("webdriver.chrome.driver", "/Users/Zahid/Desktop/selenium/BrowserDrivers/chromedriver_win32/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.get("https://freecrm.com");
	}
@AfterMethod
public void tearDown() {
	driver.close();
}

@Test(priority=2)
public void scrolldown() {
	driver.findElement(By.name("username")).sendKeys("zahidsye");
	driver.findElement(By.name("password")).sendKeys("Zamin@123");
	JavascriptExecutor js =((JavascriptExecutor)driver);
	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	String contactno=driver.findElement(By.xpath("//*[text()='1-415-915-8355']")).getText();
	try {
		 	Assert.assertEquals("1-415-915-8355", contactno);
		 	System.out.println("Help Line No is "+contactno);
		} catch (AssertionError e) {
			e.printStackTrace();	
			Assert.fail("You are in catch block");
		}
	}
	
@Test(priority=1)
public  void scrolldowntoelement() {
	WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Forms')]"));
	JavascriptExecutor js = ((JavascriptExecutor)driver);
	js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

@Test(priority=3)
public void scrollup() {
	JavascriptExecutor js =((JavascriptExecutor)driver);
	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
}

}
