package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {
	
	public SearchPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@placeholder='Search']") WebElement search_inputtxt;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']") WebElement search_btn;
	
	public void searchtxt(String txt)
	{
		search_inputtxt.sendKeys(txt);
	}
	
	public void searchclick()
	{
		search_btn.click();
	}

}
