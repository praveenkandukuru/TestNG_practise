package testngPractise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class MyListener implements WebDriverListener{

	public void afterGet(WebDriver driver, String url) {
		
		System.out.println("after entering the url --->:"+url);}
		


	public void afterFindElement(WebDriver driver, By locator, WebElement result) {
		
		System.out.println("after finding the element-->:"+result);
		
	}

	public void afterClick(WebElement element) {
		
		System.out.println("after clicking the element the element-->:"+element);
	}

	public void afterSendKeys(WebElement element, CharSequence... keysToSend) {

		System.out.println("Typing in an Element : "+element +" entered the value as : ");
		
		for(int i=0; i<keysToSend.length; i++) {
			
			System.out.println(keysToSend[i]+" ");
		
			}
	}

	public void afterImplicitlyWait(Timeouts timeouts, Duration duration) {
		
		System.out.println("after implicitly wait --->:"+duration);
		
	}
	
	
	
	
	   
	

}
