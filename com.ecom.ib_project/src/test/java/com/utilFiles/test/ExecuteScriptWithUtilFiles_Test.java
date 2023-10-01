package com.utilFiles.test;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.IB.genericUtils.DatabaseUtility_Test;
import com.IB.genericUtils.ExeclUtility_Test;
import com.IB.genericUtils.FileUtility_Test;
import com.IB.genericUtils.JavaUtility_Test;
import com.IB.genericUtils.WebDriverUtility_Test;

public class ExecuteScriptWithUtilFiles_Test {
	static WebDriver driver;
	public static void main(String[] args) throws Throwable {
		WebDriverUtility_Test wLib = new WebDriverUtility_Test();
		JavaUtility_Test jLib = new JavaUtility_Test();
		FileUtility_Test fLib = new FileUtility_Test();
		ExeclUtility_Test eLib = new ExeclUtility_Test();
		DatabaseUtility_Test dLib = new DatabaseUtility_Test();
		
		//getting random values
		int random = jLib.getRandomNumber();
		
		//read the data from excel file
		String BROWSER = fLib.getPropertyKeyValue("browser");
		String URL = fLib.getPropertyKeyValue("url");
		String UN = fLib.getPropertyKeyValue("username");
		String PWD = fLib.getPropertyKeyValue("password");
		//String UURL = p.getProperty("uurl");
		//String UUN = p.getProperty("uusername");
		//String UPWD = p.getProperty("upassword");
		
		//FETCH DATA FROM EXCEL FILE
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\Testdata511.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Restaurant");
		int count = sh.getLastRowNum();
		//USING HASHMAP FOR TEXTFILEDS
				HashMap<String, String> map = new HashMap<String, String>(); //EMPTY MAP
				for(int i=1;i<=count;i++) {
					String key = sh.getRow(i).getCell(0).getStringCellValue();
					String value = sh.getRow(i).getCell(1).getStringCellValue();
					map.put(key, value);
				}
				
		
		//LAUNCH THE BROWSER
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")){
			driver = new  FirefoxDriver();
		}
		else{
			System.out.println("Invalid Browser");
		}
		
		//maximize and login
		wLib.maximizeTheBrowser(driver);
		wLib.implicitWait(driver, 10);
		driver.get(URL);
		driver.findElement(By.name("username")).sendKeys(UN);
		driver.findElement(By.name("password")).sendKeys(PWD);
		driver.findElement(By.name("submit")).click();
		
		String Bcount = driver.findElement(By.xpath("//p[.='Restaurants']/../h2")).getText();
		int bvalue = Integer.parseInt(Bcount);
         System.out.println(bvalue);
       //click on restaurant
 		driver.findElement(By.xpath("//span[.='Restaurant']")).click();
 		//click on add restaurant
 		driver.findElement(By.linkText("Add Restaurant")).click();
         
         for (Entry<String, String> s:map.entrySet()) {
				if(s.getKey().contains("MANDYA")) {
					driver.findElement(By.name(s.getKey())).sendKeys(s.getValue()+random);
				}
				else {
					driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
				}
			}
         
		WebElement ohr = driver.findElement(By.name("o_hr"));
		wLib.selectByDropDown("7am", ohr);
		//Select s1 = new Select(ohr);
		//s1.selectByVisibleText("7am");
		
		WebElement chr = driver.findElement(By.name("c_hr"));
		wLib.selectByDropDown("8pm", chr);
		
		WebElement days = driver.findElement(By.name("o_days"));
		wLib.selectByDropDown("Mon-Sat", days);
		
		
		WebElement cname = driver.findElement(By.name("c_name"));
		wLib.selectByDropDown("Indian", cname);
		
		driver.findElement(By.name("submit")).click();
		
		driver.findElement(By.xpath("//span[.='Dashboard']")).click();
		String acount = driver.findElement(By.xpath("//p[.='Restaurants']/../h2")).getText();
		int avalue = Integer.parseInt(acount);
		System.out.println("The no of resturants are " + avalue);
		if(bvalue<avalue) {
			System.out.println("Restaurant added");
		}
		else {
			System.out.println("Restaurant no added");
		}
		
		driver.quit();

	}

}
