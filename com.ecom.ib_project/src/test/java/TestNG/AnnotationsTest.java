package TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnnotationsTest {

	@Test
	public void sample()
	{
		System.out.println("---Testscript - 1----");
	}
	@BeforeSuite
	public void configBS()
	{
		System.out.println("----connect to database----");
	}
	@BeforeClass
	public void configBC()
	{
		System.out.println("-----launch the browser");
	}
	@BeforeMethod
	public void configBM()
	{
		System.out.println("--login to the application-----");
	}
	@AfterMethod
	public void configAM()
	{
		System.out.println("---logout from the browser---");
	}
	@AfterClass
	public void configAC()
	{
		System.out.println("---close the browser-----");
	}
	@AfterSuite
	public void configAS()
	{
		System.out.println("-----Disconnect the database----");
	}
	
	@Test
	public void demo()
	{
		System.out.println("----Testscript-2------");
	}
	
}



















