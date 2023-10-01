package com.practice.test;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.IB.ObjectRepository.AddRestaurantPage;
import com.IB.ObjectRepository.AdminLoginPage;
import com.IB.ObjectRepository.DashboardPage;
import com.IB.genericUtils.DatabaseUtility_Test;
import com.IB.genericUtils.ExeclUtility_Test;
import com.IB.genericUtils.FileUtility_Test;
import com.IB.genericUtils.JavaUtility_Test;
import com.IB.genericUtils.WebDriverUtility_Test;

public class AddRestaurant_POMTest {
	
	static WebDriver driver;
	public static void main(String[] args) throws Throwable {
		//creating object for all utility files
		DatabaseUtility_Test dLib = new DatabaseUtility_Test();
		ExeclUtility_Test eLib = new ExeclUtility_Test();
		FileUtility_Test fLib = new FileUtility_Test();
		JavaUtility_Test jLib = new JavaUtility_Test();
		WebDriverUtility_Test wLib = new WebDriverUtility_Test();
		
		//read data from excel file
		String BROWSER = fLib.getPropertyKeyValue("browser");
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		
		//open browser
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver =  new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		//maximize and login
		wLib.maximizeTheBrowser(driver);
		wLib.implicitWait(driver, 10);
		driver.get(URL);
		AdminLoginPage lp = new AdminLoginPage(driver);
		lp.loginpage(USERNAME, PASSWORD);
		
		DashboardPage db = new DashboardPage(driver);
		int beforeCount = db.getDashboardCount(driver, "Restaurants");
		db.clickAddRestaurant();
		
		HashMap<String, String> data = eLib.getMultipleDataFromExcel("Restaurant", 0, 1, driver, jLib);
		String openHrs = eLib.readDataFromExcelSheet("Restaurant", 1, 3);
		String closeHrs = eLib.readDataFromExcelSheet("Restaurant", 2, 3);
		String openDays = eLib.readDataFromExcelSheet("Restaurant", 3, 3);
		 
		
		
		 AddRestaurantPage arp = new AddRestaurantPage(driver);
		 arp.addRestaurant(data, driver, wLib, jLib, closeHrs, openHrs, openDays, openDays);
		 
		 int afterCount = db.getDashboardCount(driver, "Restaurants");
		 if(beforeCount<afterCount)
		 {
			 System.out.println("Restaurant is added");
		 }
		 else
		 {
			 System.out.println("Restaurant is not added");
		 }
		 driver.close();

	}

}
