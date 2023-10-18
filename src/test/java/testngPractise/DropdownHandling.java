package testngPractise;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownHandling {

	
	public static void main(String [] args)
	{
		//System.setProperty("webdriver.chrome.driver",".//Browser_exefiles//chromedriver.exe");

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.wikipedia.org/");
		List<WebElement> linksElements=driver.findElements(By.tagName("a"));
		
		System.out.println(linksElements.size());
//		for(WebElement linkElement: linksElements)
//		{
//			String link=linkElement.getAttribute("href");
//			System.out.println(linkElement.getText()+"    "+"the url is =="+link);
//		}
//		Iterator it=linksElements.iterator();
//		while(it.hasNext())
//		{
//			WebElement linkElement=(WebElement) it.next();
//			System.out.println(linkElement.getText()+"---------"+"the url is----> "+linkElement.getAttribute("href"));
//			
//		}
//		
		WebElement block=driver.findElement(By.cssSelector("[data-el-section='primary links']"));
		List<WebElement> links=	block.findElements(By.tagName("a"));
		for(WebElement link:links)
		{
			String url=link.getAttribute("href");
			System.out.println("the url is--->"+url);
		}
		
		
	}
	
	
}
