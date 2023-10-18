package testngPractise;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HAndlingSvgTags {
	
	public static void main(String [] args) throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver",".//Browser_exefiles//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	
		
		driver.get("https://www.covid19india.org/");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Andhra Pradesh')]")));
		
		
		driver.findElement(By.xpath("//div[contains(text(),'Andhra Pradesh')]")).click();
		System.out.println("haii hello");
		WebElement svgelement=driver.findElement(By.xpath("(//*[name()='svg' and @preserveAspectRatio='xMidYMid meet'])[6]"));
		
		System.out.println("located the svg element");
		WebElement ele=driver.findElement(By.xpath("(//*[name()='svg' and @preserveAspectRatio='xMidYMid meet'])[6]/*[local-name()='path']"));
		
		int toplefty=(((ele.getSize().getHeight())/2)-(ele.getSize().getHeight()));
		
		int topleftx=(((ele.getSize().getWidth())/2)-(ele.getSize().getWidth()));
		
		System.out.println(toplefty+"    "+topleftx);
		//circle.getSize().getHeight())
		Actions actions=new Actions(driver);
		Thread.sleep(5000);
		for(int i=1;i<=445;i++)
		{
			i=i+4;
			System.out.println(i);
		//	System.out.println("located the svg element");
		
			actions.moveToElement(ele, topleftx+i,toplefty ).perform();
	
		String info=driver.findElement(By.xpath("//div[@class='stats is-confirmed']")).getText();
		System.out.println(info);
		
		
		}
		
		
	}

}
