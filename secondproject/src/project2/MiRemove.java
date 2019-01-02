package project2;

import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class MiRemove 
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
		Thread.sleep(8000);
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
			WebDriverWait w=new WebDriverWait(driver,20);
		//Automation
			try
			{
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='SUN']")));
				driver.pressKeyCode(AndroidKeyCode.HOME);
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='WhatsApp']")));
				MobileElement a=(MobileElement) driver.findElement(By.xpath("//*[@text='WhatsApp']"));				
				Duration d=Duration.of(1, ChronoUnit.SECONDS);
				int w1=driver.manage().window().getSize().getWidth();
				int h=driver.manage().window().getSize().getHeight();
				int x=(int)(w1/2);
				int y=(int)(h*0.1);
				TouchAction ta=new TouchAction(driver);	
				ta.longPress(a).waitAction(d).moveTo(x,y).release().perform();				
				//close app
				driver.launchApp();
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
	
