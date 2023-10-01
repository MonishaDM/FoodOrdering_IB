package com.practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Admin_UserViewMenuTC_10Test {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/admin/");		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("codeastro");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		//clicking on menu 
		driver.findElement(By.xpath("//span[text()='Menu']")).click();
		driver.findElement(By.linkText("All Menues")).click();
		driver.findElement(By.xpath("//table/tbody//tr[1]//td[*]//a[@class='btn btn-info btn-flat btn-addon btn-sm m-b-10 m-l-5']")).click();
		driver.findElement(By.xpath("//input[@name='d_name']")).sendKeys("GULAB_JAMMUN");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		driver.findElement(By.xpath("//img[@class='profile-pic']")).click();
		driver.findElement(By.xpath("//ul[@class='dropdown-user']")).click();
		driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/login.php");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("ABCD");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("1234567");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Restaurants')]")).click();
		driver.findElement(By.linkText("View Menu")).click();
		driver.findElement(By.xpath("//div[@id='popular2']//div[@class='food-item']//a[text()='JAMMUN']")).click();
		driver.findElement(By.linkText("Logout")).click();
		
		driver.close();
	}

}
