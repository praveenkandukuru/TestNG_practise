package testngPractise;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestngPractise {

	@Test(priority = 1,dependsOnMethods = "test2",alwaysRun = true,groups = {"regression","smoke","functional"})
	public void test1() {
		
		System.out.println("test1 is executed--testngpractise");
		

	}

	@Test(priority = 2,groups = {"smoke","functional"})
	public void test2() {
		Assert.fail("unable to execute the test");
		System.out.println("test2 is executed testngpractise");
	}

	@Test(priority = 3,groups = {"sanity","functional"})
	public void test3() {
		System.out.println("test3 is executed testngpratise");
	}

	@Test(priority = 4,groups = {"smoke","leo"})
	public void test4() {
		System.out.println("test4 is excuted testng parctise");
	}
	@Test(priority = 5,groups = {"unit regression","functional"})
	
	public void test5()
	{
		System.out.println("test5 is executed");
	}
	@Test(priority = 6,groups = {"smoke","functional"})
	public void test6()
	{
		System.out.println("test6 is executed testngparctise");
	}
	@Test(priority = 7,groups = {"smoke","functional"})
	public void test7()
	{
		System.out.println("test 7 is executed testng practise");
	}

}
