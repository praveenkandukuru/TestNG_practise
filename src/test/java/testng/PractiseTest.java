package testng;

import java.time.Duration;
import java.util.Optional;

import javax.swing.JScrollBar;

import org.bouncycastle.asn1.mozilla.PublicKeyAndChallenge;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v116.v116Network;
import org.openqa.selenium.devtools.v116.network.Network;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.Test;

import PageObject.Baseclass;




@Test
public class PractiseTest {
	//JavascriptExecutor jsExecutor;
	WebDriver driver;;
	
	public void mockLoaction() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\prave\\TestNg_practise\\Browser_exefiles\\chromedriver.exe");
		driver = new ChromeDriver();
		Baseclass.jsExecutor=((JavascriptExecutor)driver);
//		DevTools devTools = ((ChromeDriver) driver).getDevTools();
//		devTools.createSession();
//		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.way2automation.com/angularjs-protractor/banking/#/manager");
		WebElement ele=driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/button[1]"));
		System.out.println(ele.getCssValue("background-color"));
		for(int i=1;i<=10;i++) {
		Baseclass.su.toFlashAnElement("rgb(0,200,0)", ele);
		Thread.sleep(2000);
		System.out.println(ele.getAttribute("style"));
		
		Baseclass.su.toFlashAnElement("rgba(240, 240, 240, 1)", ele);
		System.out.println(ele.getAttribute("style"));
		Thread.sleep(500);
		}
		
		 
		 
		//jsExecutor.executeScript("arguments[0].style.border='3px solid Red'", ele);
		
		//jsExecutor.executeScript("arguments[0].click()", ele);
		
		
	}
	

}
