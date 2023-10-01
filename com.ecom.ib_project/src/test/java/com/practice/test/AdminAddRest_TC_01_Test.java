package com.practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdminAddRest_TC_01_Test {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//admin actions
		driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/admin/");		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("codeastro");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		//click on restaurant
		driver.findElement(By.xpath("//span[.='Restaurant']")).click();
		//click on add restaurant
		driver.findElement(By.linkText("Add Restaurant")).click();
		//entering all details
		driver.findElement(By.xpath("//input[@name='res_name']")).sendKeys("xyz");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("xyz@email.com");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("9875641234");
		driver.findElement(By.xpath("//input[@name='url']")).sendKeys("www.xyz.com");
		driver.findElement(By.xpath("//select[@name='o_hr']//option[@value='7am']")).click();
		driver.findElement(By.xpath("//select[@name='c_hr']//option[@value='7pm']")).click();
		driver.findElement(By.xpath("//select[@name='o_days']//option[@value='Mon-Sat']")).click();
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("C:\\Users\\dmoni\\Pictures\\Core Java.png");
		
		int v = 2;
		driver.findElement(By.xpath("//select[@name='c_name']//option[@value='"+v+"']")).click();
		driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys("2,xyz street,3rd cross,abc,Bangalore,567001");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		driver.findElement(By.linkText("All Restaurants")).click();
		driver.close();

	}

}
