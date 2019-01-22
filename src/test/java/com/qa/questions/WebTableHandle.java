package com.qa.questions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.excel.utility.Xls_Reader;

public class WebTableHandle {
WebDriver driver;
@BeforeMethod
public void setup() {
	System.setProperty("webdriver.chrome.driver","/Users/Zahid/Desktop/selenium/BrowserDrivers/chromedriver_win32/chromedriver.exe");
	driver=new ChromeDriver(); 
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
@Test
public void webtable() {
	driver.get("https://www.seleniumeasy.com/test/table-pagination-demo.html");
	String beforeXpath_ID = "//*[@id=\"myTable\"]/tr[";
	String afterXpath_ID = "]/td[1]";
	
	String beforeXpath_Hed1 = "//*[@id=\"myTable\"]/tr[";
	String afterXpath_Hed1 = "]/td[2]";

	Xls_Reader reader = new Xls_Reader("C:\\Users\\Zahid\\eclipse-workspace\\InterQuesSel\\src\\test\\java\\com\\test\\LoginData.xlsx");
	if(!reader.isSheetExist("outPut")) {
		reader.addSheet("outPut");
		reader.addColumn("outPut", "#");
		reader.addColumn("outPut", "Heading 1");
	}
	
	for(int i = 1; i<=5;i++) {
		String actualXpath_ID = beforeXpath_ID+i+afterXpath_ID;
		String ID = driver.findElement(By.xpath(actualXpath_ID)).getText();
		System.out.println(ID);
		reader.setCellData("outPut", "#", i+1, ID);
		
		String actualXpath_Hed = beforeXpath_Hed1+i+afterXpath_Hed1;
		String Heading1 = driver.findElement(By.xpath(actualXpath_Hed)).getText();
		System.out.println(Heading1);
		reader.setCellData("outPut", "Heading 1", i+1, Heading1);
		
	}
}
@Test
public void dynamicwebelementMethod2() {
	driver.get("https://www.seleniumeasy.com/test/table-search-filter-demo.html");
	String TableId=driver.findElement(By.xpath("//td[contains(text(),'Bootstrap 3')]//preceding-sibling::td[contains(text(),'4')]")).getText();
	System.out.println(TableId);
}
@AfterMethod
public void tearDown() {
	driver.close();
}

}
