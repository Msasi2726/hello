package project2;

import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class LenovoCall
{
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Exception
	{	
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter contact Name");
		String x=sc.nextLine();
		//Provide details of Avd
		DesiredCapabilities dc=new DesiredCapabilities();		
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName", "8bbbc489");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion","5.1.1");
		dc.setCapability("appPackage", "com.lenovo.ideafriend");
		dc.setCapability("appActivity", "com.lenovo.ideafriend.alias.PeopleActivity");
		//Start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723\"");
		URL u=new URL("http://127.0.0.1:4723/wd/hub");
		//Create object to AndroidDriver to Launch
		AndroidDriver driver;
		while(1<2)
		{
			try
			{
			driver=new AndroidDriver(u,dc);
			break;
		    }		
		catch(Exception e)
		{			
		}
		}
		//Automation
		try
		{
			WebDriverWait w=new WebDriverWait(driver,20);
			w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@text='Contacts']")));
			int w1=driver.manage().window().getSize().getWidth();
			int h=driver.manage().window().getSize().getHeight();
			int x1=(int)(w1/2);
			int y1=(int)(h*0.4);
			int x2=x1;
			int y2=(int)(h*0.39);
			while(2>1)
			{
				try
				{
					driver.findElement(By.xpath("//*[@text='"+x+"'][@index='1']")).click();
					break;
				}
				catch(Exception exe)
				{
					TouchAction ta1=new TouchAction(driver);
					Duration d=Duration.of(2,ChronoUnit.SECONDS);
					ta1.press(x1,y1).moveTo(x2,y2).waitAction(d).release().perform();
				}
			}
			w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='android.widget.LinearLayout'][@index='1']")));
			driver.findElement(By.xpath("//*[@class='android.widget.LinearLayout'][@index='1']")).click();
			w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Jio 4G']")));
			driver.findElement(By.xpath("//*[@text='Jio 4G']")).click();			
			//close app
			//driver.closeApp();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		//stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}
}
