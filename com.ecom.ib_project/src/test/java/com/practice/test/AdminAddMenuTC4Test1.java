package com.practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdminAddMenuTC4Test1 {

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
		driver.findElement(By.linkText("Add Menu")).click();
		driver.findElement(By.xpath("//input[@name='d_name']")).sendKeys("JAMMUN");
		driver.findElement(By.xpath("//input[@name='about']")).sendKeys("Softy Sweet");
		driver.findElement(By.xpath("//input[@name='price']")).sendKeys("5");
		driver.findElement(By.xpath("//input[@name='file']")).sendKeys("C:\\Users\\dmoni\\Desktop\\jammun1.jpg");
		driver.findElement(By.xpath("//select[@name='res_name']/option[contains(text(),'Eataly')]")).click();
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		driver.findElement(By.linkText("Cancel")).click();
		//clicking on menu 
				//driver.findElement(By.xpath("//span[text()='Menu']")).click();
				driver.findElement(By.linkText("All Menues")).click();
				driver.findElement(By.xpath("//table/tbody//tr[1]//td[*]//a[@class='btn btn-danger btn-flat btn-addon btn-xs m-b-10']")).click();
				driver.close();
		

	}

}
