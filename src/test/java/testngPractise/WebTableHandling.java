package testngPractise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHandling {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",".//Browser_exefiles//chromedriver.exe");

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://money.rediff.com/gainers");
		////table[@class='dataTable']/thead/following-sibling::tbody/tr[1]/td[5]
		
		List<WebElement> rowsElements=driver.findElements(By.xpath("//table[@class='dataTable']/thead/following-sibling::tbody/tr"));
		
		int rowcount=rowsElements.size();
		System.out.println("total_rows_count---->"+rowcount);
		
		List<WebElement> colunmsCount=driver.findElements(By.xpath("//table[@class='dataTable']/thead/following-sibling::tbody/tr[1]/td"));
		int colcount=colunmsCount.size();
		System.out.println("total column count---->"+colcount);
		
		for(int i=1;i<=rowsElements.size();i++)
			
		{
			for(int j=1;j<=colunmsCount.size();j++)
			{
				String contentString=driver.findElement(By.xpath("//table[@class='dataTable']/thead/following-sibling::tbody/tr["+i+"]/td["+j+"]"+       "")).getText();
			
				if(contentString.contains("Shiva Granito Export"))
				{
					for(int j1=1;j1<=colunmsCount.size();j1++)
					{
					System.out.print(driver.findElement(By.xpath("//table[@class='dataTable']/thead/following-sibling::tbody/tr["+i+"]/td["+j1+"]"+       "")).getText()+"		"	);}
				}
			}
			//System.out.println("");
		}
		

	}

}
