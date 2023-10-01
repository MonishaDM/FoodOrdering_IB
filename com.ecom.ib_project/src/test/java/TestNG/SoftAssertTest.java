package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {
	
	WebDriver driver = new ChromeDriver();
	SoftAssert sa = new SoftAssert();
	@Test
	public void softAssertTest1()
	{
		String expected = "Admin Login";
		driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/admin/");
		String actual = driver.getTitle();
		System.out.println(actual);
		sa.assertEquals(actual, expected);
		System.out.println("---appln launched");
		System.out.println("---execution ends");
		sa.assertAll();
		
	}
	
	@Test
	public void softAssertTest2()
	{
		String expected = "Login";
		driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/login.php");
		String actual = driver.getTitle();
		System.out.println(actual);
		sa.assertEquals(actual, expected);
		System.out.println("---appln launched");
		System.out.println("---execution ends");
		sa.assertAll();
		
	}
	

}
