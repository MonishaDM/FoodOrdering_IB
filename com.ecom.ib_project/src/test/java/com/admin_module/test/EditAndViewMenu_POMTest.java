package com.admin_module.test;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.IB.ObjectRepository.AddMenuPage;
import com.IB.ObjectRepository.AdminLoginPage;
import com.IB.ObjectRepository.DashboardPage;
import com.IB.ObjectRepository.EditMenuPage;
import com.IB.ObjectRepository.HomeAfterLoginPage;
import com.IB.ObjectRepository.HomeBeforeLoginPage;
import com.IB.ObjectRepository.RestaurantsPage;
import com.IB.ObjectRepository.UserLoginPage;
import com.IB.genericUtils.BaseClass;

public class EditAndViewMenu_POMTest extends BaseClass {
	
	@Test
	public void EditMenuAndView() throws Throwable {
		//String aurl=fLib.getPropertyKeyValue("admin_url");
		//String aUname = fLib.getPropertyKeyValue("admin_username");
		//String aPwd = fLib.getPropertyKeyValue("admin_password");
		String UURL = fLib.getPropertyKeyValue("uurl");
		String UUN = fLib.getPropertyKeyValue("uusername");
		String UPWD = fLib.getPropertyKeyValue("upassword");
		//driver.get(aurl);
		//AdminLoginPage alp = new AdminLoginPage(driver);
		//alp.loginpage(aUname, aPwd);

		DashboardPage app = new DashboardPage(driver);
		app.clickAddMenu();

		HashMap<String, String> data = eLib.getMultipleDataFromExcel("Menu", 0, 1, driver, jLib);
		String menuName = eLib.readDataFromExcelSheet("Menu", 4, 1);

		AddMenuPage amp = new AddMenuPage(driver);
		String actualMenu = amp.addMenu(data, driver, jLib, menuName);
		
		Thread.sleep(3000);
		app.clickAllMenu();
		amp.validateAddedMenu(driver);
		//app.getAllMenubtn().click();

		HashMap<String, String> editData = eLib.getMultipleDataFromExcel("Edit-Menu", 0, 1, driver, jLib);
		EditMenuPage emp = new EditMenuPage(driver);
		emp.clickOnEditMenu(driver, actualMenu);
		String editedMenu = emp.editMenu(editData, driver, jLib, menuName);
		
		emp.validateEditedMenu(driver, editedMenu);
		Thread.sleep(3000);
		app.getAllMenubtn().click();

		app.logoutAsAdmin();

		driver.get(UURL);

		HomeBeforeLoginPage hblp = new HomeBeforeLoginPage(driver);
		hblp.clickLoginLink();

		UserLoginPage ulp = new UserLoginPage(driver);
		ulp.loginpage(UUN, UPWD);

		String restName = eLib.readDataFromExcelSheet("Edit-Menu", 3, 1);
		HomeAfterLoginPage halp = new HomeAfterLoginPage(driver);
		halp.clickRestaurants();

		RestaurantsPage r = new RestaurantsPage();
		r.validateUpdatedMenu(driver, restName, menuName);

	}

}
