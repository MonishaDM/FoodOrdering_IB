package TestNG;

import org.testng.annotations.Test;

public class PracticeTest {
	
	@Test()
	public void createTest()
	{
		int[]x= {1,2,3};
		System.out.println(x[2]);
		System.out.println("----data created---");
	}
	
	@Test(dependsOnMethods = "deleteTest")
	public void editTest()
	{
		System.out.println("-----data edited successfully-----");
	}
	
	@Test(priority = 2)
	public void deleteTest()
	{
		System.out.println("-----data deleted successfully------");
	}

}
