package com.practice.test;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.epfindia.gov.in/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		 List<WebElement> alllinks = driver.findElements(By.xpath("//a"));
		 System.out.println(alllinks.size());
		  ArrayList<String> links = new ArrayList<String>();
		  for(int i=0;i<alllinks.size();i++)
		  {
			URL url = null;
			int statuscode = 0;
			String eachlink = alllinks.get(i).getAttribute("href");
			try {
				URL u = new URL(eachlink);
				
				HttpsURLConnection https = (HttpsURLConnection)u.openConnection();
					
				statuscode = https.getResponseCode();
				//System.out.println(statuscode);
				if(statuscode>=400)
				{
					links.add(eachlink);
				}
			}
			catch(Exception e) {
				links.add(eachlink);
			}
			System.out.println(eachlink+ "------>" + statuscode);
			
			
		  }

	}

}
