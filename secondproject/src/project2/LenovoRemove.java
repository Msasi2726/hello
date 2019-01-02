package project2;

import java.net.URL;
import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class LenovoRemove
{
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Exception
	{		
		//Provide details of Avd
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName", "8bbbc489");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion","5.1.1");
		dc.setCapability("appPackage", "com.lenovo.ideafriend");
		dc.setCapability("appActivity", "com.lenovo.ideafriend.alias.DialtactsActivity");
		//Start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"npm clear cache --f\"");
		Thread.sleep(4000);
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
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
			driver.pressKeyCode(AndroidKeyCode.HOME);
			WebDriverWait w=new WebDriverWait(driver,10);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='WhatsApp']")));
			WebElement a=driver.findElement(By.xpath("//*[@text='WhatsApp']"));					
			TouchAction ta=new TouchAction(driver);			
			int w1=driver.manage().window().getSize().getWidth();
			int h=driver.manage().window().getSize().getHeight();
			int x= (int)(w1*0.2);
			int y= (int)(h*0.05);
			ta.longPress(a).waitAction(Duration.ofMillis(10000)).moveTo(x,y).release().perform();
			ta.longPress(a).waitAction(Duration.ofMillis(10000)).moveTo(x,y).release().perform();
			driver.launchApp();
			//close App
			driver.closeApp();
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
