package TestNG;

import org.testng.annotations.Test;

public class DpExcnTest {

		@Test(dataProviderClass =DataProviderTest.class ,dataProvider ="dataFromExcel")
			public void getData(String product, String price, String size)
			{
			System.out.println(product+"----------->"+price+"----------->"+size);
			}
}
