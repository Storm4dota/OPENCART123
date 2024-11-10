package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyaccountPage extends BasePage {
	
	 public MyaccountPage(WebDriver driver)
	 {
		 super(driver);
	 }
	 
	 @FindBy(xpath="//h2[text()='My Account']") WebElement msgHeading; //MyAccount page Heading
	 
	 @FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement butn_logout; //added in step 6
	 
	 public boolean MyAccountHeader()
	 {
		 try
		 {
		 return (msgHeading.isDisplayed());
		 }
		 catch(Exception e)
		 {
			 return false;
		 }
	 }
	 
	 public void logoutbutton()
	 {
		 butn_logout.click();
	 }

}
