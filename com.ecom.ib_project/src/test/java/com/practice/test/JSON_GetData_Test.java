package com.practice.test;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSON_GetData_Test {
	public static void main(String[] args) throws Throwable {
		JSONParser p = new JSONParser();
		Object obj = p.parse(new FileReader("src\\test\\resources\\JSONdata.json"));
		
		JSONObject map = (JSONObject) obj;
		String BROWSER = (String)map.get("browser");
		String URL = (String)map.get("url");
		String UN = (String)map.get("username");
		String PWD = (String)map.get("password");
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.findElement(By.name("username")).sendKeys(UN);
		driver.findElement(By.name("password")).sendKeys(PWD);
		driver.findElement(By.name("submit")).click();
		driver.close();
		
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(UN);
		System.out.println(PWD);

	}

}
