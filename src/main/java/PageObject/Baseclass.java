package PageObject;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import Utilities.com.DataDriven;
import Utilities.com.SeleniumUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	
	
	public static WebDriver driver;
	public static Actions act;
	public static SeleniumUtility su=new SeleniumUtility();
	public DataDriven dd=new DataDriven();
	public static JavascriptExecutor jsExecutor;
	
	public static GooglePage page;
	
	@BeforeClass
	public void launchTheBrowser() throws IOException 
	
	{
		String brow=dd.getDataFromPropertiesFile("browser");
	System.out.println("iam from baseclass======"+brow);
	
	if(brow.equals("chrome"))
	{
		//WebDriverManager.chromedriver().setup();
		System.setProperty("Webdriver.chrome.driver",dd.getDataFromPropertiesFile("chromepath"));
		System.out.println("about to launch the browser");
		driver=new ChromeDriver();
	}else if(brow.equals("firefox"))
	{
		System.getProperty("webdriver.gecko.driver","C://Users//prave//TestNg_practise//Browser_exefiles//geckodriver.exe");
		driver=new FirefoxDriver();
	}

	}
	@BeforeMethod
	public void getIntoApp()
	{	
		su.maximizieTheWindow(driver);
		driver.get("https://www.google.com");
		
		su.implicitWait(driver);
		System.out.println("before method id exceuted");
	
	}
	@AfterClass
	public void closeTheBrowser()
	{
		driver.quit();
	}
}
