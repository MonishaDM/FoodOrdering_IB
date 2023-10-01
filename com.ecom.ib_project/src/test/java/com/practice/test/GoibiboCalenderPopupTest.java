package com.practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoibiboCalenderPopupTest {
	public static void main(String[] args) throws InterruptedException {
		int date1 = 19 ;
		int date2 = 20 ;
		String MD1 = "September 2023";
		String MD2 = "December 2023";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		driver.findElement(By.xpath("//span[.='Departure']")).click();
		String actual = "//div[.='"+MD1+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+date1+"']";
		String nextArrow = "//span[@aria-label=\"Next Month\"]";
		for(;;)
		{
			try {
				driver.findElement(By.xpath(actual)).click();
				break;
			}
			catch(Exception e) {
				driver.findElement(By.xpath(nextArrow)).click();
			}
		}
		
		driver.findElement(By.xpath("//span[.='Done']")).click();
		driver.findElement(By.xpath("//a[.='Cancel']")).click();
		driver.findElement(By.xpath("//span[.='Return']")).click();
		String Act = "//div[.='"+MD2+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+date2+"']";
		String nextArrow1 = "//span[@class='DayPicker-NavButton DayPicker-NavButton--next']";
		for(;;)
		{
			try {
				driver.findElement(By.xpath(Act)).click();
				break;
			}
			catch(Exception e) {
				driver.findElement(By.xpath(nextArrow1)).click();
			}
			
		} 
		
		driver.findElement(By.xpath("//span[.='Done']")).click();
		driver.findElement(By.xpath("//a[.='Cancel']")).click();
		Thread.sleep(3000);
		driver.quit();
	}

}
