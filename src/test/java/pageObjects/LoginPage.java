package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	
	
	public LoginPage(WebDriver driver)
	{
		
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@id='input-email']") WebElement TxtEmail;
	
	@FindBy(xpath="//input[@id='input-password']") WebElement TxtPwrd;
	
	@FindBy(xpath="//input[@value='Login']") WebElement login_butn;
	
	public void enterEmail(String enemail)
	{
		TxtEmail.sendKeys(enemail);
	}
	
	public void enterpassword(String enpassword)
	{
		TxtPwrd.sendKeys(enpassword);
	}
	
	public void loginbutton()
	{
		login_butn.click();
	}

}
