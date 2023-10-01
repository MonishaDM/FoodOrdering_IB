package com.practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Admin_Edit_Delete_OrderTC_7Test {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//User actions
		driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/login.php");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("ABCD");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("1234567");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Restaurants')]")).click();
		driver.findElement(By.linkText("View Menu")).click();
		driver.findElement(By.xpath("(//div[@id='popular2']//input[@class='btn theme-btn'])[9]")).click();
		driver.findElement(By.xpath("//a[.='Checkout']")).click();
		driver.findElement(By.xpath("//label[@class='custom-control custom-radio  m-b-20']")).click();
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//a[.='Logout']")).click();
		//Admin delete order
		driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/admin/");		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("codeastro");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		driver.findElement(By.xpath("//span[.='Orders']")).click();
		driver.findElement(By.xpath("//table/tbody//tr[1]//td[*]//a[@class='btn btn-danger btn-flat btn-addon btn-xs m-b-10']")).click();
		driver.switchTo().alert().accept();
		/*admin edit order
		driver.findElement(By.xpath("//table/tbody//tr[1]//td[*]//a[@class='btn btn-info btn-flat btn-addon btn-sm m-b-10 m-l-5']")).click();
		driver.findElement(By.xpath("//button[.='Update Order Status']")).click();
		driver.findElement(By.xpath("//select[@name='status']//option[.='Delivered']")).click();
		driver.findElement(By.xpath("//textarea[@name='remark']")).sendKeys("Order Delivered");
		driver.findElement(By.xpath("//input[@name='update']")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//input[@name='Submit2']")).click();
		driver.findElement(By.xpath("//img[@class='profile-pic']")).click();
		driver.findElement(By.xpath("//ul[@class='dropdown-user']")).click();
		
		//user viewing updated order status
		driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/login.php");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("ABCD");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("1234567");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		driver.findElement(By.xpath("//a[.='My Orders']")).click();  */
		driver.close();
		
		

	}

}
