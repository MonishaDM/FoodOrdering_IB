package com.practice.test;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AdminAddRest_Dashboard_TC_05_Test {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = null;
	Random	ran = new Random();
	int random = ran.nextInt();
		
		//FETCH DATA FROM PROPERTY FILE
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		Properties p = new Properties();
		p.load(fis);
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String UN = p.getProperty("username");
		String PWD = p.getProperty("password");
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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
		Select s1 = new Select(ohr);
		s1.selectByVisibleText("7am");
		
		WebElement chr = driver.findElement(By.name("c_hr"));
		Select s2 = new Select(chr);
		s2.selectByVisibleText("8pm");
		
		WebElement days = driver.findElement(By.name("o_days"));
		Select s3 = new Select(days);
		s3.selectByVisibleText("Mon-Sat");
		
		WebElement cname = driver.findElement(By.name("c_name"));
		Select s4 = new Select(cname);
		s4.selectByVisibleText("Indian");
		
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
