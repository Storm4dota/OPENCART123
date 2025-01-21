package testBases;

import java.io.File;


import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager; //Log4j
import org.apache.logging.log4j.Logger;  //Log4j

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;  //Log4j
	public Properties p;
	
	@SuppressWarnings("deprecation")
	@BeforeClass//(groups= {"Sanity","Master","Regression"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException 
	{
		
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		logger =LogManager.getLogger(this.getClass());
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			//capabilities.setPlatform(Platform.WIN10);
			//capabilities.setBrowserName("chrome");
			
			//OS
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN10);
			}
			else if (os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else if(os.equalsIgnoreCase("linux"))
			{
				capabilities.setPlatform(Platform.LINUX);
			}
			else
			{
				System.out.println("No matching os");
				return;
			
			}
			
			//browser
			switch(br.toLowerCase())
			{
			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
			case "firefox" :capabilities.setBrowserName("firefox"); break;
			default: System.out.println("No matching browser"); return;
			}
			
			 driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		 }
		
				
	
	  if(p.getProperty("execution_env").equalsIgnoreCase("local"))
			{   
		  
		  
		  
				switch(br.toLowerCase())
				{
				case "chrome" : driver=new ChromeDriver(); break;
				case "edge" : driver=new EdgeDriver(); break;
				case "firefox" : driver=new FirefoxDriver(); break;
				default : System.out.println("invalid browser name.."); return;
				}
		
		
		      
			 }
		
		
		//driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
		driver.get(p.getProperty("appURL"));  //reading URL from properties file.
		
	}
	
	
    @AfterClass//(groups={"Master","Sanity","Regression"})
	public void teardown()
	{
		driver.close();
	}
    
    
    
    public String randomString()
    {
    	String generatedname=RandomStringUtils.randomAlphabetic(5);
    	return generatedname;
    	
    	
    }
	
	public String randomnumber()
	{
		String generatednum=RandomStringUtils.randomAlphanumeric(10);
		return generatednum;
	}
	
	public String alphanumeric()
	{
		String randomname=RandomStringUtils.randomAlphabetic(3);
		String randomnum=RandomStringUtils.randomAlphanumeric(4);
		return(randomname+"!@"+randomnum);
	}
	
	   public String captureScreen(String tname) throws IOException 
	   {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenShot = (TakesScreenshot) driver;
		File sourceFile = takesScreenShot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
	
	    }

}
