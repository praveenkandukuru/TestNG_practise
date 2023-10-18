package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage extends Baseclass {

	public GooglePage(WebDriver ldriver) {
		driver = ldriver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "APjFqb")
	private WebElement searchBar;
	
	@FindBy(xpath="(//input[@value='Google Search'])[1]")
	private WebElement searchbutton;

	public WebElement getSearchbar() {

		return searchBar;

	}

	public WebElement searchbutton()
	{
		return searchbutton;
	}
	
}
