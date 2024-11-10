package pageObjects;

import java.time.Duration;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage  {
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txt_firstname;
	
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txt_lastname;
	
	@FindBy(xpath="//input[@id='input-email']") WebElement txt_email;
	
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txt_telphone;
	
	@FindBy(xpath="//input[@id='input-password']") WebElement txt_psswrd;
	
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txt_conpsswrd;
	
	@FindBy(xpath="//input[@name='agree']") WebElement BTPrivacy;
	
	@FindBy(xpath="//input[@value='Continue']") WebElement btn_cont;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement confirmMsg;
	
	public void firstname(String fname)
	{
		txt_firstname.sendKeys(fname);
	}
	
	public void lastname(String lname)
	{
		txt_lastname.sendKeys(lname);
	}
	
	public void email(String eml)
	{
		txt_email.sendKeys(eml);
	}
	
	public void phonenumber(String ph)
	{
		txt_telphone.sendKeys(ph);
	}
	
	public void newpassword(String npwrd)
	{
		txt_psswrd.sendKeys(npwrd);
	}
	
	public void confirmpassword(String cpwrd)
	{
		txt_conpsswrd.sendKeys(cpwrd);
	}
	
	public void privacypolicy()
	{
		BTPrivacy.click();
	}
	public void createAccountContinue()
	{   //sol1
		btn_cont.click();
		
		//sol2
		//btn_cont.submit();
		
	     //sol3
		//Actions act=new Actions(driver);
		//act.moveToElement(btn_cont).click().perform();
		
		//sol4
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", btn_cont);
		
		//sol5
		//btn_cont.sendKeys(Keys.RETURN);
		
		//sol6
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(btn_cont)).click();
	}
		public String getConfirmationMsg()
		{
			try
			{
				return (confirmMsg.getText());
			} 
			catch (Exception e) 
			{
				return (e.getMessage());
			}
		}
		
	}
	
		
		
	
	


