package TestNG;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.IB.genericUtils.ExeclUtility_Test;
import com.IB.genericUtils.IPathConstants;

public class DataProviderTest {

@DataProvider
	
		public Object[][] mobiles()
		{
			Object[][] obj = new Object[2][2];
			
			obj[0][0] = "Samsung";
			obj[0][1] = 10000;
			
			obj[1][0] = "Realme";
			obj[1][1] = 15000;
			
			return obj;
			
		}
	
	@DataProvider
	
	public Object[][] tv()
	{
		Object[][] obj = new Object[3][3];
		
		obj[0][0] = "Sony";
		obj[0][1] = 20000;
		obj[0][2] = "32 inch";
		
		obj[1][0] = "Redmi";
		obj[1][1] = 35000;
		obj[1][2] = "44 inch";
		
		obj[2][0] = "Oneplus";
		obj[2][1] = 40000;
		obj[2][2] = "50 inch";
		
		return obj;
		
	}
	
	@DataProvider
	public Object[][] dataFromExcel() throws Throwable
	{
		ExeclUtility_Test eLib = new ExeclUtility_Test();
		Object[][] value = eLib.getMultipleSetOfDataFromExcel("DataProvider");
		return value;
	}
}
















