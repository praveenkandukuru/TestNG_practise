package testngPractise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

public class Driverlisteners {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",".//Browser_exefiles//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		WebDriverListener listener=new MyListener();
		WebDriver wddriver=new EventFiringDecorator<WebDriver>(listener).decorate(driver);
		
		
		wddriver.manage().window().maximize();
		wddriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		 wddriver.get("https://www.google.com/");
		 wddriver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("SachinTendulkar");
		 wddriver.findElement(By.cssSelector("div[class='FPdoLc lJ9FBc'] center")).click();
		
	
	}

}
