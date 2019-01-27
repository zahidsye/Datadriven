package com.qa.questions;

import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Asserttest {
WebDriver driver;
SoftAssert softAssert = new SoftAssert();
String actualerrormessage;
String expectederrormessage = "1Please enter your first name";
String actualpagetitle;
String expectedpagetitle;
Logger log = Logger.getLogger(Asserttest.class);
@BeforeMethod
public void LaunchBrowser() {
	System.setProperty("webdriver.chrome.driver", "/Users/Zahid/Desktop/selenium/BrowserDrivers/chromedriver_win32/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	log.info("heeeeee");
	}

@AfterMethod
public void closeBrowser() {
	driver.close();
}
@Test
public void assertcheck() {
	driver.get("https://www.linkedin.com/");
	driver.findElement(By.xpath("//input[@id=\"registration-submit\"]")).click();
	actualerrormessage = driver.findElement(By.xpath("//span[@class=\"alert-content\"]")).getText();
	
	try {
		Assert.assertEquals(actualerrormessage, expectederrormessage,"Enter message not Matching with the expected error message");
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}	

@Test
public void softassert() {
	driver.get("http://demoqa.com/");
	actualpagetitle = driver.getTitle();
	expectedpagetitle = "1234Demoqa | Just another WordPress site";
	softAssert.assertEquals(actualpagetitle, expectedpagetitle);


	driver.findElement(By.linkText("Hello world!")).click();
	actualpagetitle = driver.getTitle();
	expectedpagetitle = "1234Hello world! | Demoqa";
	softAssert.assertEquals(actualpagetitle, expectedpagetitle);
	
	Boolean status =driver.findElement(By.id("submit")).isEnabled();
	softAssert.assertEquals(status, false);
	softAssert.assertAll();
}

}

