package com.practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Make_My_Trip_Test {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com/");
		driver.navigate().refresh();
		Actions a = new Actions(driver);
		/*a.moveByOffset(0, 80).click().perform();
		Thread.sleep(3000); */
		a.moveByOffset(0, 80).click().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[.='Departure']")).click();
		driver.findElement(By.xpath("//div[.='September 2023']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='14']")).click();
		driver.findElement(By.xpath("//span[.='Return']")).click();
		for(;;)
		{
			try {
				driver.findElement(By.xpath("//div[text()='January']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='10']")).click();
				break;
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();

			}
		}
		driver.close();
		
		
	}
}
