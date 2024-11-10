package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyaccountPage;
import testBases.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	
	
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="Datadriven") //getting data provider from different class

	public void verify_loginDDT(String enteremail,String pwrd, String exp)
	
	{
		try
		{
		logger.info("***** login_DDt has Started *******");
	
	    HomePage hp=new HomePage(driver);
	    hp.clickmyAccount();
	    hp.clicklogin();
	
	    LoginPage lp=new LoginPage(driver);
	    lp.enterEmail(enteremail);
	    lp.enterpassword(pwrd);
	    lp.loginbutton();
	
	    MyaccountPage mcp=new MyaccountPage(driver);
	    boolean targetpage=mcp.MyAccountHeader();
	    
	    /*Data is vald  - login success - test pass - logout
	     Data is valid -- login failed - test fail
	     
	      Data is invalid  - login sucess - test fail  - logout
	      Data is invalid -- login failed  - test pass
	     */
	 
	    if(exp.equalsIgnoreCase("Valid"))
	    {
		if(targetpage==true)
		{
		   mcp.logoutbutton();
		   Assert.assertTrue(true);  //test is passed for valid data
		}
		else
		{
			Assert.assertTrue(false); //test is failed for valid data
		}	
	    }
	   if(exp.equalsIgnoreCase("Invalid")) 
	    {   
		if(targetpage==true)
		{
		   mcp.logoutbutton();
		   Assert.assertTrue(false);  //test is failed for invalid data
		}
		else
		{
			Assert.assertTrue(true);  //test is passed for invalid data
		}
	     }
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	logger.info("****** login_DDT has finished ****** ");
	
	
		
	
	}
	
	
	
	
	

}
