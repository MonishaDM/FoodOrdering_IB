package com.practice.test;

import org.testng.annotations.Test;

import com.IB.ObjectRepository.AdminLoginPage;
import com.IB.ObjectRepository.DashboardPage;
import com.IB.genericUtils.BaseClass;

public class AdminLogin_POMTest extends BaseClass {
	
	@Test
	public void adminPage() throws Throwable
	{
		String BROWSER = fLib.getPropertyKeyValue("browser");
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		
		AdminLoginPage lp = new AdminLoginPage(driver);
		lp.loginpage(USERNAME, PASSWORD);
		
		DashboardPage db = new DashboardPage(driver);
		int beforeCount = db.getDashboardCount(driver, "Restaurants");
		
	}
	

}
