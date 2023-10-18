package testngPractise;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Datepicker1 {
	static int togoday = 0, togomonth = 0, togoyear = 0;

	static int currentday = 0, currentmonth = 0, currentyear = 0;
	static String monyear = null;

	static String datetogo = "24/8/2022";
	static boolean match = true;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", ".//Browser_exefiles//chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://jqueryui.com/datepicker/");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		driver.findElement(By.xpath("//input[starts-with(@id,'datepi')]")).click();
		Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));

		getTodayDate();
		gotoDate();

		String tomonth = swtichToMonth(togomonth);
		monyear = tomonth + " " + Integer.toString(togoyear);
		System.out.println(monyear);
		System.out.println(togoyear+tomonth);
		
		System.out.println((currentyear<togoyear));
		System.out.println(togoyear);
		System.out.println(currentyear);

		while (match) {
			if (currentyear < togoyear) 
			{
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
				String comb1 = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
				Thread.sleep(2000);
				if (comb1.equals(monyear))
				{
					driver.findElement(By.partialLinkText(Integer.toString(togoday))).click();
					match = false;
				}
			} 
			
				

			else {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='ui-datepicker-prev ui-corner-all']")));
				
				driver.findElement(By.xpath("//a[@class='ui-datepicker-prev ui-corner-all']")).click();
				String comb1 = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
//				Thread.sleep(2000);
				if (comb1.equals(monyear)) {
					driver.findElement(By.partialLinkText(Integer.toString(togoday))).click();
					match = false;

				}

			}
		}

	}

	public static void gotoDate() {

		String[] arry = datetogo.split("/");
		togoday = Integer.parseInt(arry[0]);
		togomonth = Integer.parseInt(arry[1]);
		togoyear = Integer.parseInt(arry[2]);

	}
	
	public static void getTodayDate()
	{
		Calendar cal=Calendar.getInstance();
		currentday=cal.get(Calendar.DAY_OF_MONTH);
		 currentmonth=cal.get(cal.MONTH)+1;
		 currentyear=cal.get(Calendar.YEAR);
		 
		 System.out.println(currentday+" "+currentmonth+" "+currentyear);
		
		
		
		
	}

	public static String swtichToMonth(int month) {
		String mon = null;
		switch (month) {
		case 1:
			mon = "January";

			break;
		case 2:
			mon = "Febuary";

			break;
		case 3:
			mon = "March";

			break;
		case 4:
			mon = "April";

			break;
		case 5:
			mon = "May";

			break;
		case 6:
			mon = "June";

			break;
		case 7:
			mon = "July";

			break;
		case 8:
			mon = "August";

			break;
		case 9:
			mon = "September";

			break;
		case 10:
			mon = "October";

			break;
		case 11:
			mon = "November";

			break;
		case 12:
			mon = "December";

			break;

		}
		return mon;

	}

}
