package testngPractise;

import java.time.Duration;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationPractise {
	
	
	public static void main(String[] args)
	{
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\prave\\TestNg_practise\\Browser_exefiles\\chromedriver.exe");

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		((HasAuthentication)driver).register(UsernameAndPassword.of("admin","admin"));
		driver.get("https://the-internet.herokuapp.com/digest_auth");
	}

}
