package com.admin_module.test;

import static org.testng.Assert.fail;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.IB.ObjectRepository.AddMenuPage;
import com.IB.ObjectRepository.DashboardPage;
import com.IB.genericUtils.BaseClass;

@Listeners(com.IB.genericUtils.ListenersImpleClass.class)

public class AddMenu_POMTest extends BaseClass{
	
	@Test(groups = {"smoke","regression"})
	public void AddMenu() throws Throwable {
		//String url = fLib.getPropertyKeyValue("url");
		//String username=fLib.getPropertyKeyValue("username");
		//String password=fLib.getPropertyKeyValue("password");
		//driver.get(url);
		//AdminLoginPage alp = new AdminLoginPage(driver);
		//alp.loginpage(username, password);
		
	    DashboardPage app = new DashboardPage(driver);
		int intialCount = app.getDashboardCount(driver, "Dishes");
		app.clickAddMenu();
		
		// read data from excel file
				HashMap<String, String> data = eLib.getMultipleDataFromExcel("Menu", 0, 1, driver, jLib);
				String restName = eLib.readDataFromExcelSheet("Menu", 4, 1);
				
				Assert.fail();

		AddMenuPage amp = new AddMenuPage(driver);
		String actualMenuName = amp.addMenu(data, driver, jLib, restName);
		
		int afterCount = app.getDashboardCount(driver, "Dishes");

		if (intialCount < afterCount) {
			System.out.println("New Menu is added");
		} else {
			System.out.println("New Menu is not added");
		}
	}

}
