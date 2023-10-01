package com.practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class KsrtcCalenderPopupTest {

	public static void main(String[] args) {
		int date = 31;
		
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.ksrtc.in/");
	driver.findElement(By.xpath("//input[@id='txtJourneyDate']")).click();
	driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/descendant::a[.='"+date+"']")).click();
	driver.findElement(By.xpath("//input[@id='txtReturnJourneyDate']")).click();
	driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']")).click();
	driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/descendant::a[.='14']")).click();

	}

}
