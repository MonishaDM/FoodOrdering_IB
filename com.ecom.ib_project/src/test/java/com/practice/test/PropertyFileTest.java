package com.practice.test;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		Properties p = new Properties();
		p.load(fis);
		 String BROWSER = p.getProperty("browser");
		 String AURL = p.getProperty("url");
		 String AUSERNAME = p.getProperty("username");
		 String APASSWORD = p.getProperty("password");
		 String UURL = p.getProperty("uurl");
		 String UUSERNAME = p.getProperty("uusername");
		 String UPASSWORD = p.getProperty("upassword");
		 
		 System.out.println(BROWSER);
		 System.out.println(AURL);
		 System.out.println(AUSERNAME);
		 System.out.println(APASSWORD);
		 System.out.println(UURL);
		 System.out.println(UUSERNAME);
		 System.out.println(UPASSWORD);
		
		

	}

}
