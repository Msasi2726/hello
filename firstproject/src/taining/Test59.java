package taining;

import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Test59
{
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Exception
	{
		//details of ARD and App
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","192.168.43.172:1111");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "4.4.2");
		dc.setCapability("locationServicesEnabled", "true");
		dc.setCapability("locationServicesAuthorized", "true");
		dc.setCapability("appPackage", "com.google.android.apps.maps");
		dc.setCapability("appActivity", "com.google.android.maps.MapsActivity");
		//start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//create driver object and Launch
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
		WebDriverWait w=new WebDriverWait(driver,20);		
		int w1=driver.manage().window().getSize().getWidth();
		int h=driver.manage().window().getSize().getHeight();
		int x1=(int)(w1/2);
		int y1=(int)(h/2);
		int x2=(int)(x1-10);
		int y2=(int)(y1);
		int x3=(int)(x2-30);
		int y3=(int)(y1);
		int x4=(int)(x1+10);
		int y4=(int)(y1);
		int x5=(int)(x1+30);
		int y5=(int)(y1);
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Accept & continue']")));
		driver.findElement(By.xpath("//*[@text='Accept & continue']")).click();		
		TouchAction ta1=new TouchAction(driver);
		Duration d=Duration.of(5,ChronoUnit.SECONDS);
		ta1.press(x2,y2).moveTo(x3,y3).waitAction(d).release();
		TouchAction ta2=new TouchAction(driver);
		ta1.press(x4,y4).moveTo(x5,y5).waitAction(d).release();
		MultiTouchAction ma=new MultiTouchAction(driver);
		ma.add(ta1).add(ta2).perform();
		Thread.sleep(1000);
		}
		catch(Exception exe)
		{
			System.out.println(exe.getMessage());
		}
		//close app
		driver.closeApp();
		//Stop Appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	} 
}
