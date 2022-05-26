//Program for cucumber by creating test case manually
package cucumbermap;
import java.util.Hashtable;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.HTMLReportGenerator;
import utility.SeleniumOperation2;
public class Login
{
	
		@When("^user open \"(.*)\" browser with exe$")
		public void user_open_browser_with_exe(String bname) throws Throwable 
		{
			Object[] input=new Object[1];
			input[0]=bname;
			SeleniumOperation2.browserLaunch(input);	
		}

		@When("^user open url as$")
		public void user_open_url_as() throws Throwable 
		{
			SeleniumOperation2.openApplication();
		}

	/*@When ("^user open \"(.*)\" browser with exe \"(.*)\"$")
	   public void bLaunch(String bname)
	   {
		Object[] input=new Object[2];
		input[0]=bname;
	    SeleniumOperation2.browserLaunch(input);	
	   }
	@When ("^user open url as \"(.*)\"$")
	public void openApp()
	{
	SeleniumOperation2.openApplication();	
	}*/
	@When ("^user cancle initial Login window$")
	  public void cancleLoginW()
	  {
		Object[] input2=new Object[1];
		input2[0]="//*[@class='_2KpZ6l _2doB4z']";
		Hashtable<String,Object> output3=SeleniumOperation2.clickOnElement(input2);	
		HTMLReportGenerator.StepDetails(output3.get("STATUS").toString(),"^user cancle initial Login window$",output3.get("MESSAGE").toString());
	  }
	@When ("^user navigate on Login button$")
	public void navigateLogin()
	{
		 Object[] input3=new Object[1];
		 input3[0]="//*[text()='Login']";
	     Hashtable<String,Object> output4=SeleniumOperation2.mouseOver(input3);	
		 HTMLReportGenerator.StepDetails(output4.get("STATUS").toString(),"^user navigate on Login button$",output4.get("MESSAGE").toString());
	}
	
	@When ("^user click on MyProfile$")
	public void ClickMyProfile()
	{
		 Object[] input4=new Object[1];
		 input4[0]="//*[text()='My Profile']";
		 Hashtable<String,Object> output5= SeleniumOperation2.clickOnElement(input4);
		 HTMLReportGenerator.StepDetails(output5.get("STATUS").toString(),"^user click on MyProfile$",output5.get("MESSAGE").toString());

	}
	@When ("^user enter \"(.*)\" as username$")
	public void uname(String uName) throws InterruptedException
	{
		Thread.sleep(5000);
		Object[] input5=new Object[2];
		 input5[0]="(//*[@type='text'])[2]";
		 input5[1]=uName;
		 Hashtable<String,Object> output6= SeleniumOperation2.sendKey(input5);
		 HTMLReportGenerator.StepDetails(output6.get("STATUS").toString(),"^user enter \"(.*)\" as username$",output6.get("MESSAGE").toString());

	}
	@When ("^user enter \"(.*)\" as password$")
	public void pass(String passwd)
	{
		Object[] input6=new Object[2];
		 input6[0]="//*[@type='password']";
		 input6[1]=passwd;
		 Hashtable<String,Object> output7=SeleniumOperation2.sendKey(input6);
		 HTMLReportGenerator.StepDetails(output7.get("STATUS").toString(),"^user enter \"(.*)\" as password$",output7.get("MESSAGE").toString());

	}
	@When ("^user click on Login button$")
	public void loginB()
	{
		 Object[] input7=new Object[1];
		 input7[0]="(//*[@type='submit'])[2]";
		 Hashtable<String,Object> output8=SeleniumOperation2.clickOnElement(input7);
		 HTMLReportGenerator.StepDetails(output8.get("STATUS").toString(),"^user click on Login button$",output8.get("MESSAGE").toString());

	}
	
	@Then ("^Application shows user profile to user$")
	 public void valid() throws InterruptedException
	 {
		 Thread.sleep(5000);
		 Object[] input8=new Object[2];
		 input8[0]="//*[@class='_1ruvv2']";
		 input8[1]="Dipali Kamble";
		 Hashtable<String,Object> output9= SeleniumOperation2.validation(input8);
		 HTMLReportGenerator.StepDetails(output9.get("STATUS").toString(),"^Application shows user profile to user$",output9.get("MESSAGE").toString());

	 }
	
}

