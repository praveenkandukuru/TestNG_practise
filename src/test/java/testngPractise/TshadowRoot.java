package testngPractise;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.*;




public class TshadowRoot {
	
	public static void main(String [] args)
	{
		System.setProperty("webdriver.chrome.driver",".//Browser_exefiles//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(10));
		wait.pollingEvery(Duration.ofSeconds(10));
		wait.ignoring(NoSuchElementException.class);
		
		
		driver.get("chrome://downloads/");
		
		JavascriptExecutor jsExecutor=((JavascriptExecutor)driver);
		WebElement root=(WebElement) jsExecutor.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('downloads-toolbar').shadowRoot.querySelector('cr-toolbar').shadowRoot.querySelector('cr-toolbar-search-field').shadowRoot.querySelector('div>input')");
		String js="arguments[0].setAttribute('value','hai dude how are you')";
		((JavascriptExecutor)driver).executeScript(js, root);
		
	//JavascriptExecutor jse=((JavascriptExecutor)driver);
//		
//		WebElement rootElement=(WebElement)jse.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('downloads-toolbar').shadowRoot.querySelector('cr-toolbar').shadowRoot.querySelector('cr-toolbar-search-field').shadowRoot.querySelector('div>input')");
//	
//		
//		//rootElement.sendKeys("history");
//		((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('value', 'history');",rootElement);
//		
		
//		WebElement root=driver.findElement(By.cssSelector("downloads-manager"));
//	SearchContext shadowroot1=(SearchContext) ((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot",root);
//		
//		WebElement root_2=shadowroot1.findElement(By.cssSelector("downloads-toolbar"));
//		SearchContext shadowroot2=(SearchContext)((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot",root_2);
//		
//		WebElement root_3=shadowroot2.findElement(By.cssSelector("cr-toolbar"));
//		SearchContext shadowroot3=(SearchContext)((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot",root_3);
//		
//		
//		WebElement root_4=shadowroot3.findElement(By.cssSelector("cr-toolbar-search-field"));
//		SearchContext root4=(SearchContext)((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot",root_4);
//		
//		
//		root4.findElement(By.cssSelector("#searchInput")).sendKeys("hello");
//		

		
		
	}

}
