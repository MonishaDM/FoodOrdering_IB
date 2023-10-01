package TestNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;

public class HardAssertTest {
	
	@Test
	public void hardAssertTest1()
	{
		System.out.println("---------Executing step 1-------");
		System.out.println("---------Executing step 2-------");
		assertEquals("A","B");
		System.out.println("---------Executing step 3-------");
		System.out.println("---------Executing step 4-------");
	}
	
	@Test
	public void hardAssertTest2()
	{
		System.out.println("---------Executing step 5-------");
		System.out.println("---------Executing step 6-------");
		assertNotEquals("x","x");
		System.out.println("---------Executing step 7-------");
		System.out.println("---------Executing step 8-------");
	}
	
	@Test
	public void hardAssertTest3()
	{
		int m = 5;
		assertNotNull(m);
		System.out.println("---------Executing step 9-------");
	}

}
