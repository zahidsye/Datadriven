package com.qa.questions;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Log4jAPI {
WebDriver driver = null;
Logger log = Logger.getLogger(Log4jAPI.class);	
@Test
public void LaunchBrowser() {
	System.setProperty("webdriver.chrome.driver", "/Users/Zahid/Desktop/selenium/BrowserDrivers/chromedriver_win32/chromedriver.exe");
	driver =new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	log.info("Zahid Browser is Launched");
}

@Test
public void TearDown() {
	driver.close();
	log.info("Zahid Browser is Closed");
}
}
