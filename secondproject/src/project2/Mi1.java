package project2;

import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Connection;

public class Mi1
{
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Exception
	{	
		//Provide details of Avd
		DesiredCapabilities dc=new DesiredCapabilities();		
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName", "192.168.43.86:5555");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion","4.4.2");
		dc.setCapability("appPackage", "com.tinno.led");
		dc.setCapability("appActivity", "com.tinno.led.LEDActivity");
		//Start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"npm clear cache --f\"");
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
			    w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.tinno.led:id/led_button']")));	
				driver.findElement(By.xpath("//*[@resource-id='com.tinno.led:id/led_button']")).click();
				Thread.sleep(20000);
				driver.findElement(By.xpath("//*[@resource-id='com.tinno.led:id/led_button']")).click();
				driver.closeApp();
				//close wifi
				Connection c=driver.getConnection();
				if(c.compareTo(Connection.WIFI)==0)
				{
					System.out.println("wifi is on");
				}
				else
				{
					System.out.println("wifi is off");
				}
				if(c.compareTo(Connection.DATA)==0)
				{
					System.out.println("data is on");
				}
				else
				{
					System.out.println("data is off");
				}
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
