package project2;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Mic3swipe
{
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Exception 
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName", "192.168.43.151:5555");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "4.4.2");
		dc.setCapability("appPackage", "com.android.calendar");
		dc.setCapability("appActivity", "com.android.calendar.AllInOneActivity");
		//start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"npm clear cache --f\"");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Create object to AndroidDriver to Launch
		AndroidDriver driver;
		while(2>1) 
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
			//swipe on app screen
			int w=driver.manage().window().getSize().getWidth();
			int h=driver.manage().window().getSize().getHeight();
			TouchAction ta=new TouchAction(driver);
			//swipe from bottom to top
			int x1=(int)h/2;
			int y1=(int)(w*0.9);
			int x2=(int)h/2;
			int y2=(int)(w*0.7);
			for(int i=0;i<=5;i++)
			{
				ta.press(x1,y1).moveTo(x2,y2).waitAction(Duration.ofMillis(1000)).release().perform();
			}
			//swipe from top to bottom
			y1=(int)(w*0.7);
			y2=(int)(w*0.9);
			for(int i=0;i<=5;i++)
			{
				ta.press(x1,y1).moveTo(x2,y2).waitAction(Duration.ofMillis(1000)).release().perform();
			}
			//close app
			driver.closeApp();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		//Stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");

	}
}
