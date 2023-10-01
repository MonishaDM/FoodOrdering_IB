package com.practice.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleRetrytest {
	@Test(retryAnalyzer = com.IB.genericUtils.RetryImplClass.class)
	public void retryTest()
	{
		Assert.assertEquals("A", "B");
	}

}
