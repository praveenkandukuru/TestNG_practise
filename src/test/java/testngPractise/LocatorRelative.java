package testngPractise;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;
import org.openqa.selenium.support.ui.FluentWait;

import com.github.dockerjava.api.model.Driver;
import com.google.common.util.concurrent.FluentFuture;

public class LocatorRelative {
	 public static WebDriver driver;
	
	public static boolean isElementPresent(By by)
	{
		try {
			driver.findElement(by);
			return true;
		}
			
		 catch (NoSuchElementException e) 
		{
			return false;
			
		}
		
		
	}
	
	
	public static void main(String [] args)
	{
		
		System.setProperty("webdriver.chrome.driver",".//Browser_exefiles//chromedriver.exe");

		driver=new ChromeDriver();
		driver.manage().window().maximize();
		FluentWait wait=new FluentWait(driver);
		wait.withTimeout(Duration.ofSeconds(10));
		wait.ignoring(NoSuchElementException.class);
		wait.pollingEvery(Duration.ofSeconds(10));
		
		driver.get("https://www.way2automation.com/way2auto_jquery/index.php");
		boolean value=isElementPresent(By.xpath("(//input[@name='password'])[2]"));
		System.out.println(value);
//		WebElement ele=driver.findElement(with(By.cssSelector("[name='email']")).below(By.cssSelector("[name='phone']")));
//		ele.sendKeys("hellobabai");
//		driver.findElement(with(By.cssSelector("[name='name']")).above(By.cssSelector("[name='phone']"))).sendKeys("rahulArora");
//	driver.findElement(with(By.xpath("//a[text()='Signin']")).toLeftOf(By.xpath("(//input[@type='submit'])[2]"))).click();
//	
		WebElement element=driver.findElement(with(By.xpath("(//input[@name='password'])[2]")).below(By.xpath("(//input[@name='username'])[2]")).above(By.xpath("//p[text()='Already Have an Account? | ']")));
		
		element.sendKeys("password0");
		System.out.println(element.getShadowRoot());
		
		
	}

}
