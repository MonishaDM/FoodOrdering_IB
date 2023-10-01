package com.practice.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JioMartTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jiomart.com/");
		driver.manage().window().maximize();
		String groceryName = "Beverages";
		WebElement grocery = driver.findElement(By.xpath("//a[.='Groceries']"));
		Actions a = new Actions(driver);
		a.moveToElement(grocery).perform();
WebElement glist = driver.findElement(By.xpath("//a[contains(text(),'"+groceryName+"') and contains(@id,'nav_link')]"));
Actions a1 = new Actions(driver);
a1.moveToElement(glist).perform();
List<WebElement> values = driver.findElements(By.xpath(""));
System.out.println(values);
driver.close();
	}

}
