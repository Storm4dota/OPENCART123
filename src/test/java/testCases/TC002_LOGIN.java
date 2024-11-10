package testCases;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyaccountPage;
import testBases.BaseClass;

public class TC002_LOGIN extends BaseClass{
	
	@Test(groups={"Sanity","Master"})
	
	public void verify_login()
	{
		logger.info("********* TC002_login Started*******");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickmyAccount();
		hp.clicklogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.enterEmail(p.getProperty("email"));
		lp.enterpassword(p.getProperty("password"));
		lp.loginbutton();
		
	    MyaccountPage mcp=new MyaccountPage(driver);
	    boolean targetpage= mcp.MyAccountHeader();
	    
	   // Assert.assertEquals(targetpage, true,"login Failed");
	    Assert.assertTrue(targetpage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***** TC002_login Finished *****");
	}
	

}
