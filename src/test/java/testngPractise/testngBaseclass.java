package testngPractise;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class testngBaseclass {
	
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("execute before the suite");
	}
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("execute before test");
	}
	@BeforeClass
	public void beforeclass()
	{
		System.out.println("execute before class");
	}
	@BeforeMethod
	public void beforeMethod() {
		
		
		System.out.println("execute before method");
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("execute after the method");
	}
	@AfterClass
	public void afterclass()
	{
		System.out.println("execute after the class");
	}
	@AfterTest
	 public void afterTest()
	 {
		 System.out.println("execute after the test");
	 }
	@AfterSuite
	 public void afterSuite()
	 {
		 System.out.println("execute after suite");
	 }

}
