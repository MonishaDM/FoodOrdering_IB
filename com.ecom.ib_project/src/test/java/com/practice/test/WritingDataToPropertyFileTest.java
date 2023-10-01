package com.practice.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WritingDataToPropertyFileTest {

	public static void main(String[] args) throws Throwable {
		Properties p = new Properties();
		p.setProperty("browser", "chrome");
		//ADMIN LOGIN
		/*  p.setProperty("url", "http://rmgtestingserver/domain/Online_Food_Ordering_System/admin/");
		p.setProperty("username", "admin");
		p.setProperty("password", "codeastro");   */
		
		//USER LOGIN
		p.setProperty("uurl", "http://rmgtestingserver/domain/Online_Food_Ordering_System/login.php");
		p.setProperty("uusername", "ABCD");
		p.setProperty("upassword", "1234567");
		
		//WRITING DATA
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\Commondata.properties");
		p.store(fos, "Write data");
		fos.close();
		//READING DATA
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		p.load(fis);
		
		String BROWSER = p.getProperty("browser");
		String UURL = p.getProperty("uurl");
		String UUN = p.getProperty("uusername");
		String UPWD = p.getProperty("upassword");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(UURL);
		driver.findElement(By.name("username")).sendKeys(UUN);
		driver.findElement(By.name("password")).sendKeys(UPWD);
		driver.findElement(By.name("submit")).click();
		driver.close();
		
	}

}
