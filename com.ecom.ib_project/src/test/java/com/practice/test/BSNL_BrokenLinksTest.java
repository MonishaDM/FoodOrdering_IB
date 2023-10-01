package com.practice.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BSNL_BrokenLinksTest {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://portal.bsnl.in/myportal/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

}
}
