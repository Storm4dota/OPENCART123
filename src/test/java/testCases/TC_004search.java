package testCases;



import pageObjects.SearchPage;
import testBases.BaseClass;

public class TC_004search extends BaseClass {
	
	public void  verifysearch()
	{
		SearchPage sp=new SearchPage(driver);
		
		sp.searchtxt("iphone");
		sp.searchclick();
	}

}
