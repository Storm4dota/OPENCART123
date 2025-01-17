package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Practobjectbaseclass {
	
	WebDriver driver;
	
	public Practobjectbaseclass(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	
	
	
	
	

}
