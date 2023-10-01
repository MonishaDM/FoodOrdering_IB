package ranjitha;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KayakDateTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.kayak.co.in/stays?lang=en&skipapp=true&gclid=EAIaIQobChMIuKPDrtnFgQMVS6pmAh3D-wy8EAAYASAAEgJIlvD_BwE");
driver.findElement(By.xpath("//div[@class='sR_k-input sR_k-mod-responsive']/span[@aria-label='Start date calendar input' and @role='button']")).click();
		//driver.findElement(By.xpath("//div[@aria-label='Start date']]")).click();
Thread.sleep(1000);
  WebElement actual = driver.findElement(By.xpath("//div[.='November 2023']/../following-sibling::div[@class='onx_-days']/div[5]"));
  WebElement nextbutton = driver.findElement(By.xpath("//button[@aria-label='Next month']"));
for(; ;)
{
	try {
		actual.click();	
	}
	catch(Exception e) {
		nextbutton.click();
	}
}
	//driver.findElement(By.xpath("//div[@aria-label='End date']")).click();
	//WebElement enddate = driver.findElement(By.xpath("//div[text()='April 2024']/../following-sibling::div[@class='onx_-days']//div[4]"));
	
	/*for(; ;)
	{
		try {
			//enddate.click();
		}
		catch(Exception e)
		{
			nextbutton.click();
		}*/
	}}
