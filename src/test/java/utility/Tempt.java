package utility;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class Tempt 
{
	public static void main(String[] args) throws InterruptedException
	{
				//Launch Browser
				System.setProperty("webdriver.chrome.driver","D:\\Automation_Support\\chromedriver.exe");
			   ChromeDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				
				//Open application
				driver.get("https://flipkart.com/");
				
				//cancel login page
				driver.findElement(By.xpath("//*[@class='_2KpZ6l _2doB4z']")).click();
				
				//mouse action>>will automate element based on mouse interaction
				Actions act=new Actions(driver);
				WebElement web=driver.findElement(By.xpath("(//*[text()='Login'])"));
			    act.moveToElement(web).build().perform();
								//Click on My Profile
				driver.findElementByXPath("(//*[text()='My Profile'])").click();
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				//Enter mobile no
				driver.findElementByXPath("//input[@class='_2IX_2- VJZDxU']").sendKeys("7447786389");
				//Enter password
				driver.findElementByXPath("//input[@type='password']").sendKeys("Piyush@13");
				//click login button
				driver.findElementByXPath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']").click();
				Thread.sleep(4000);
				driver.findElementByXPath("//*[@class='NS64GK']").click();
				driver.findElementByXPath("//*[@class='_1QhEVk']").click();
				driver.findElementByXPath("//*[@name='name']").sendKeys("Dipali");
				driver.findElementByXPath("//*[@name='phone']").sendKeys("7447786389");
				driver.findElementByXPath("(//*[@type='text'])[4]").sendKeys("414001");
				driver.findElementByXPath("//*[@name='addressLine2']").sendKeys("Ahmednagar");
				driver.findElementByXPath("//*[@name='addressLine1']").sendKeys("Nagar");
				driver.findElementByXPath("(//*[@type='button'])[2]").click();




	}
}