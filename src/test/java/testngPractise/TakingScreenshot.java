package testngPractise;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
//import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TakingScreenshot {

	public static WebDriver driver;

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver", ".//Browser_exefiles//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.selenium.dev/");

		TakesScreenshot tScreenshot = (TakesScreenshot) driver;
		File srcFile = tScreenshot.getScreenshotAs(OutputType.FILE);
		File trgFile = new File(".//Screenshot//error.png");

		WebElement element = driver.findElement(By.xpath("//div[@class='mx-auto text-center p-4']"));
		FileUtils.copyFile(srcFile, trgFile);
		elementScreenshot(element);
		takingScreenshot(element);

		screenshotofPage();
		
	}

	public static void elementScreenshot(WebElement element) throws IOException {

		File src = element.getScreenshotAs(OutputType.FILE);
		File trgFile = new File(".//Screenshot//screenshotelement.jpg");
		FileUtils.copyFile(src, trgFile);

	}

	public static void takingScreenshot(WebElement ele) throws IOException {

		Actions actions = new Actions(driver);
		actions.moveToElement(ele);
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		BufferedImage screenshot = ImageIO.read(srcFile);
		Point p = ele.getLocation();

		System.out.println(p.getX());
		System.out.println(p.getY());
		int height = ele.getSize().getHeight();
		int width = ele.getSize().getWidth();
		System.out.println("height :" + height + "   " + "width   :" + width);
		BufferedImage eleScreenshot = screenshot.getSubimage(p.getX(), p.getY() - 70, height - 50, width + 10);
		ImageIO.write(eleScreenshot, "jpg", srcFile);
		File trgFile = new File(".//Screenshot//elscreenshotbyTAkescreenshot.jpg");
		FileUtils.copyFile(srcFile, trgFile);

	}

	public static void screenshotofPage() throws IOException {

		Screenshot sScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(3000))
				.takeScreenshot(driver);
		ImageIO.write(sScreenshot.getImage(), "jpg", new File(".//Screenshot//fullpageScreenshot.jpg"));

	}

	

}
