package taining;

import java.net.URL;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class Test54 
{	
	public static void main(String[] args) throws Exception 
	{				
		//Provide details of Avd
		DesiredCapabilities dc=new DesiredCapabilities();		
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName", "8bbbc489");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion","5.1.1");		
		dc.setCapability("locationServiceEnabled", true);
		dc.setCapability("locationServiceAuthorized", true);
		dc.setCapability("appPackage", "com.google.android.apps.maps");
		dc.setCapability("appActivity", "com.google.android.maps.MapsActivity");
		//Start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"npm clear cache --f\"");
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
        	//wait for app launching completely        	
        	Thread.sleep(50000);
        	Location l=new Location(27.175015,78.042155,500);
        	driver.setLocation(l); //move to tajmahal
        	//Rotate
        	String x=driver.getOrientation().name();
        	if(x.equalsIgnoreCase("portrait"))
        	{
        		driver.rotate(ScreenOrientation.LANDSCAPE);
        		Thread.sleep(10000);
        		driver.rotate(ScreenOrientation.PORTRAIT);
        	}
        	Thread.sleep(10000);
        	driver.lockDevice();
        	Thread.sleep(10000);
        	if(driver.isLocked())
        	{
        		System.out.println("Locked");
        		driver.unlockDevice();
        	}
        	Thread.sleep(10000);
        	//close app
           	driver.closeApp();
        }
        catch (Exception ex)
        {
        	System.out.println(ex.getMessage());
        }
        //Stop appium Server
        Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}
}
