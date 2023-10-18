package testngPractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import PageObject.Baseclass;
import PageObject.GooglePage;

@Test
public class GoogleTest extends Baseclass {

	
	
	@Test(priority = 1)
	public void getGoogle() {

		
		

		
		System.out.println("in google page");
		String titleS = driver.getTitle();
		
		page = new GooglePage(driver);
		WebElement ele = page.getSearchbar();
		System.out.println("search bar located======test1");
		su.moveToELement(driver, ele);
		System.out.println("move to the element search bar");
		ele.sendKeys("Sachin Tendulkar");
		System.out.println("message entered in the search bar");
		

	}
	
	
		@Test(priority = 2)
		public void clickOnTheSearchButton() throws InterruptedException
		{
			
			
			String titl = driver.getTitle();
			
			page = new GooglePage(driver);
			WebElement ele = page.getSearchbar();
			ele.sendKeys("Sachin Tendulkar");
			WebElement element=page.searchbutton();
			System.out.println(element.isDisplayed());
			su.elementToBeVisible(driver, By.xpath("(//input[@value='Google Search'])[1]"));
			System.out.println("element to be visible is executed");
			//Thread.sleep(5000);
			element.click();
			
			
			
			
		}

	}

	
	


