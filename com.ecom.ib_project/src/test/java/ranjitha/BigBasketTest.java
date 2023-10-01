package ranjitha;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BigBasketTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.bigbasket.com/pc/foodgrains-oil-masala/dry-fruits/other-dry-fruits/?nc=nb");
		List<WebElement> allelement = driver.findElements(By.xpath("//div[@class='break-words h-10 w-full']/h3"));
	List<WebElement> allprice = driver.findElements(By.xpath("//div[@class='Pricing___StyledDiv-sc-pldi2d-0 bUnUzR']/span[1]"));
	for(int i=0;i<allelement.size();i++)
	{
		System.out.println(allelement.get(i).getText()+"--->  "+allprice.get(i).getText());
	}
	}

}
