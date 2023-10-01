package com.admin_module.test;
	
	import java.util.HashMap;

	import org.testng.annotations.Test;

import com.IB.ObjectRepository.AddMenuPage;
import com.IB.ObjectRepository.AdminLoginPage;
import com.IB.ObjectRepository.DashboardPage;
import com.IB.ObjectRepository.DeleteMenuPage;
import com.IB.genericUtils.BaseClass;

	
	public class DeleteMenuPomTest extends BaseClass {

		@Test
		public void DeleteMenu() throws Throwable {
			//String url=fLib.getPropertyKeyValue("admin_url");
			//String aUname = fLib.getPropertyKeyValue("admin_username");
			//String aPwd = fLib.getPropertyKeyValue("admin_password");
			//driver.get(url);
			//AdminLoginPage alp = new AdminLoginPage(driver);
			//alp.loginpage(aUname, aPwd);

			DashboardPage app = new DashboardPage(driver);
			app.clickAddMenu();
			
			HashMap<String, String> data = eLib.getMultipleDataFromExcel("Menu", 0, 1, driver, jLib);
			String restName = eLib.readDataFromExcelSheet("Menu", 4, 1);

			AddMenuPage amp = new AddMenuPage(driver);
			String actualResName = amp.addMenu(data, driver, jLib, restName);
			
			amp.validateAddedMenu(driver);
			Thread.sleep(5000);
			app.getAllMenubtn().click();
			
			DeleteMenuPage dmp = new DeleteMenuPage();
			dmp.clickOnDeleteMenu(driver, actualResName);
			dmp.validateDeletedMenu(driver, restName);
		}
	}
