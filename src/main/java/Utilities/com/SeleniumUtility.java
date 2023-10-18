package Utilities.com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.Baseclass;

/**
 * This class the method which are commonly used while developing test script
 * @author prave
 *
 */

public class SeleniumUtility extends Baseclass


{
	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
	public void maximizieTheWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * 
	 * This method is used to move the cursor to an particular element
	 * @param driver
	 * @param ele
	 */
	
	public void moveToELement(WebDriver driver,WebElement ele)
	{
		act=new Actions(driver);
		act.moveToElement(ele).perform();	
	}
	public void toFlashAnElement(String color,WebElement ele)
	{
		Baseclass.jsExecutor.executeScript("arguments[0].style.background='"+color+"'",ele);
	}

	
	public void clickOnTheElement(WebDriver driver,WebElement ele)
	{
		act=new Actions(driver);
		act.click(ele);
	}
	
	public void implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void elementToBeVisible(WebDriver driver,By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public void elementToBeClickable(WebDriver driver,By path)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(path));
		
	}
	public void selectdropDown(WebElement ele,int index)
	{
		Select sel=new Select(ele);
		sel.selectByIndex(index);
	}
	public void selectdropDown(WebElement ele,String value)
	{
		Select sel=new Select(ele);
		sel.selectByValue(value);
		
	}
	
	public void selectDropDown(WebElement ele,String text)
	{
		Select sel=new Select(ele);
		sel.selectByVisibleText(text);
	}
	

}
