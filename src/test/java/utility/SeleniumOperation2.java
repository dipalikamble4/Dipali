//Program using cucumber
package utility;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import cucumbermap.ConfigReader;

public class SeleniumOperation2
{
	public static ConfigReader config;
	public static WebDriver driver=null;
	public static Hashtable<String,Object> outputParameters=new Hashtable<String,Object>();
	public static Hashtable<String,Object> browserLaunch(Object[]inputParameters)  //Launch Browser
	{
		try
		{
		String bname=(String) inputParameters[0];

		if(bname.equalsIgnoreCase("chrome"))
		{	
			config=new ConfigReader();
			System.setProperty("webdriver.chrome.driver",config.getDriverPathChrome());
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait(),TimeUnit.SECONDS);
		}
		else if(bname.equalsIgnoreCase("ff"))
		{
			System.setProperty("webdriver.geckodriver.driver",config.getDriverPathFF());
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait(),TimeUnit.SECONDS);
		}
			outputParameters.put("STATUS","PASS");
			outputParameters.put("MESSAGE","Action:Browser Launch, Input Given:"+inputParameters[0].toString());
		}	
		catch(Exception e)
		{
			outputParameters.put("STATUS","FAIL");
			outputParameters.put("MESSAGE","Action:Browser Launch, Input Given:"+inputParameters[0].toString());
		}	
		return outputParameters;
	}
	public static Hashtable<String,Object> openApplication()  //Open Application
	{
		try
		{
			driver.get(config.getApplicationUrl());	
			driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait(),TimeUnit.SECONDS);
		outputParameters.put("STATUS","PASS");
		outputParameters.put("MESSAGE","Action:Open Application, Input Given:"+config.getApplicationUrl().toString());
		}
		catch(Exception e)
		{
			outputParameters.put("STATUS","FAIL");
			outputParameters.put("MESSAGE","Action:Open Application, Input Given:"+config.getApplicationUrl().toString());	
		}
       return outputParameters;
	}
	public static Hashtable<String,Object> clickOnElement(Object[]inputParameters) //Click on 1)Cancel Login, 2)My Profile, 3)Login Button
	{
		try
		{
		String XPath=(String) inputParameters[0];
		driver.findElement(By.xpath(XPath)).click();
		driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait(),TimeUnit.SECONDS);
		outputParameters.put("STATUS","PASS");
		outputParameters.put("MESSAGE","Action: Click On Element, Input Given:"+inputParameters[0].toString());
		}
	catch(Exception e)
	{
		outputParameters.put("STATUS","FAIL");
		outputParameters.put("MESSAGE","Action:Click On Element, Input Given:"+inputParameters[0].toString());
		
	}
	return outputParameters;
	}
	public static Hashtable<String,Object> mouseOver(Object[]inputParameters)  //mouse action>>will automate element based on mouse interaction

	{   
		try
		{
		String XPath=(String) inputParameters[0];
		Actions act=new Actions(driver);
		WebElement web=driver.findElement(By.xpath(XPath));
	    act.moveToElement(web).build().perform();		
		driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait(),TimeUnit.SECONDS);
		outputParameters.put("STATUS","PASS");
		outputParameters.put("MESSAGE","Action:Mouse Over, Input Given:"+inputParameters[0].toString());
		}
		catch(Exception e)
		{
			outputParameters.put("STATUS","FAIL");
			outputParameters.put("MESSAGE","Action:Mouse Over, Input Given:"+inputParameters[0].toString());
		}
		return outputParameters;
	}
	public static Hashtable<String,Object> sendKey(Object[]inputParameters) //1) Enter User-name, 2)Enter Password
	{
		try
		{
		String XPath=(String) inputParameters[0];
		String val=(String) inputParameters[1];
		driver.findElement(By.xpath(XPath)).sendKeys(val);
		driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait(),TimeUnit.SECONDS);
		outputParameters.put("STATUS","PASS");
		outputParameters.put("MESSAGE","Action:Send Key, Input Given:"+inputParameters[1].toString());
		}
		catch(Exception e)
		{
			outputParameters.put("STATUS","FAIL");
			outputParameters.put("MESSAGE","Action:Send Key, Input Given:"+inputParameters[1].toString());
		}
		return outputParameters;
	}
	public static Hashtable<String,Object> validation(Object[]inputParameters) 
	{
		try
		{
		String XPATH= (String) inputParameters[0];                     //name-xpath
		String text=(String) inputParameters[1];                      //name
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		 String actualText=driver.findElement(By.xpath(XPATH)).getText();    //name
		 
		 if(actualText.equalsIgnoreCase(text))
		 {
			System.out.println("Test Case Pass"); 
		 }
		 else
		 {
			 System.out.println("Test Case Fail"); 
		 }	
		 outputParameters.put("STATUS","PASS");
		 outputParameters.put("MESSAGE","Action:Validation, Input Given:"+inputParameters[1].toString());
		}
		catch(Exception e)
		{
			outputParameters.put("STATUS","FAIL");
			outputParameters.put("MESSAGE","Action:Mouse Over, Input Given:"+inputParameters[1].toString());
			
		}	
		return outputParameters;
		}
	
	public static Hashtable<String,Object> validationForInvalid(Object[]InputParameters) 
	{
		try
		{
		String XPATH= (String) InputParameters[0];                     //namexpath
		String text=(String) InputParameters[1];                      //name
		driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait(),TimeUnit.SECONDS);
		 String actualText=driver.findElement(By.xpath(XPATH)).getText();    //name
		 
		 if(actualText.equalsIgnoreCase(text))
		 {
			System.out.println("Test Case Pass"); 
		 }
		 else
		 {
			 System.out.println("Test Case Fail"); 
		 }	
		 outputParameters.put("STATUS","PASS");
		 outputParameters.put("MESSAGE","Action:Validation For Invalid, Input Given:"+InputParameters[1].toString());
		}
		catch(Exception e)
		{
			outputParameters.put("STATUS","FAIL");
			outputParameters.put("MESSAGE","Action:Validation For Invalid, Input Given:"+InputParameters[1].toString());
		}
		return outputParameters;
	}
	

	public static void browserClose()
	{
		driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait(),TimeUnit.SECONDS);
		driver.close();
	}
	
}
	


