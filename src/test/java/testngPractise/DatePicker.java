package testngPractise;

import java.time.Duration;
import java.util.Calendar;

import org.apache.hc.core5.http.message.StatusLine.StatusClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {
	
	static int targetday=0,
			targetMonth=0,
			targetYear=0;
	
	static int currentDay=0,
			currentMonth=0,
			currentYear=0;
	
	
	
	
	static int jumpMonthsBy=0;
	
	static boolean increment=true;
	
	
	
	
	
	

	public static void main(String[] args) throws InterruptedException {
		
		
		String dateToSet="14/7/2022";
		getCurrentDateMonthYear();
		getTargetDate(dateToSet);
		calculateDifferenceMonths();
		System.out.println(jumpMonthsBy);
		System.out.println(increment);
		
		System.setProperty("webdriver.chrome.driver",".//Browser_exefiles//chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://jqueryui.com/datepicker/");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		driver.findElement(By.xpath("//input[starts-with(@id,'datepi')]")).click();
	
		for(int i=1;i<=jumpMonthsBy;i++) {
		if(increment)
		{
		driver.findElement(By.xpath("//a[starts-with(@class,'ui-datepicker-next')]")).click();
		}else {
		driver.findElement(By.xpath("//a[starts-with(@class,'ui-datepicker-prev ui-corner-all')]")).click();
		}
		
		
		
		}
		driver.findElement(By.partialLinkText(Integer.toString(targetday))).click();
		
	}
	
		public static void getCurrentDateMonthYear()
		{
			Calendar cal=Calendar.getInstance();
			currentDay=cal.get(Calendar.DAY_OF_MONTH);
			currentMonth=cal.get(Calendar.MONTH)+1;
			currentYear=cal.get(Calendar.YEAR);
			
		}
		
		public static void getTargetDate(String dateString)
		{
			int firstIndex=dateString.indexOf("/");
			int lastIndex=dateString.lastIndexOf("/");
			
			String dayString=dateString.substring(0,firstIndex);
			targetday=Integer.parseInt(dayString);
			
			String month=dateString.substring(firstIndex+1,lastIndex);
			targetMonth=Integer.parseInt(month);
			
			String year=dateString.substring(lastIndex+1,dateString.length());
			targetYear=Integer.parseInt(year);
			
		}
		
		public static void calculateDifferenceMonths()
		{
			if((targetMonth-currentMonth)>0)
			{
				jumpMonthsBy=(targetMonth-currentMonth);
			}else {
				jumpMonthsBy=currentMonth-targetMonth;
				increment=false;
				
			}
		}

	

}
