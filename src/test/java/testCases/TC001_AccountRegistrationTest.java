package testCases;












import org.testng.Assert;



import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBases.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	
	
	
    
    @Test//(groups={"Regression","Master"})
    public void verify_account_Registration() throws InterruptedException
    {
    	//Thread.sleep(2000);
    	logger.info("**** Starting TC001_AccountRegistrationTest ***");
    	HomePage hp=new HomePage(driver);
    	hp.clickmyAccount();
    	hp.clickRegister();
    	
    	
    	try
    	{
    	AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
    	logger.info("Clicked on My Account");
    	regpage.firstname(randomString().toUpperCase());
    	
    	logger.info("Entering random last name, email");
    	regpage.lastname(randomString().toUpperCase());
    	regpage.email(randomString()+"@gmail.com");
    	regpage.phonenumber(randomnumber());
    	
    	String password=alphanumeric();
    	logger.info("Entering Random password");
    	regpage.newpassword(password);
    	regpage.confirmpassword(password);
    	
    	regpage.privacypolicy();
    	regpage.createAccountContinue();
    	
    	String confmssg=regpage.getConfirmationMsg();
    	if(confmssg.equals("Your Account Has Been Created!"))
    	{
    		Assert.assertTrue(true);
    	}
    	else
    	{
    		logger.error("Test failed..");
    		logger.debug( "debig logs..");
    		Assert.assertTrue(false);
    	}
    	
    	//Assert.assertEquals(confmssg, "Your Account Has Been Created!!!");
    	
    	}
    	catch(Exception e)
    	{
    		Assert.fail();
    	}
    	logger.info("Test case finished");
    }
    
    
	
	
}
