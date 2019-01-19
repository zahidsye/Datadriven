package com.qa.questions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.excel.utility.Xls_Reader;

public class DataDriven {
WebDriver driver;	
String Email_Id;
String Password;
int rowcount;	

@BeforeMethod
public void setup() {
	System.setProperty("webdriver.chrome.driver","/Users/Zahid/Desktop/selenium/BrowserDrivers/chromedriver_win32/chromedriver.exe");
	driver=new ChromeDriver(); 
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.get("http://demo.automationtesting.in/SignIn.html");
	//trying git commit
	//remove commit
}

@DataProvider
public Iterator<Object[]> getTestData() {
	
	ArrayList<Object[]> myData = new ArrayList<Object[]>();
	Xls_Reader reader = new Xls_Reader("/Users/Zahid/Desktop/selenium/LoginData.xlsx");
	int rowCount = reader.getRowCount("sheet1");
	for(int i = 2;i<=rowCount;i++) {
		String Email_Id = reader.getCellData("sheet1", "Email_ID", i);
		String Password = reader.getCellData("sheet1", "Password", i);
		Object ob [] = {Email_Id,Password};
		myData.add(ob);
		
	}
	return myData.iterator();
	
}

@Test(dataProvider="getTestData")
public void mytest(String Email_Id, String Password) {
	driver.findElement(By.xpath("//input[@placeholder=\"E mail\"]")).sendKeys(Email_Id);
	driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys(Password);
	driver.findElement(By.id("enterbtn")).click();
	
}
	
@AfterMethod
public void tearDown() {
	driver.close();
}
}
