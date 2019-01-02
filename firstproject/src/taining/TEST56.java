package taining;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class TEST56 
{
	public static void main(String[] args) throws Exception
	{
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
        	//Send to background
        	Duration d=Duration.of(5, ChronoUnit.SECONDS);
        	driver.runAppInBackground(d);
        	driver.resetApp();
        	//goto Home
        	driver.pressKeyCode(AndroidKeyCode.HOME);
        	//Start Activity
        	//driver.startActivity("com.whatsapp","com.whatsapp.HomeActivity");
        	driver.findElement(By.xpath("//*[@content-desc='Apps']")).click();
        	Thread.sleep(10000);
        	driver.findElement(By.xpath("//*[@content-desc='WhatsApp']")).click();
        	Thread.sleep(10000);
        	String x=driver.getRemoteAddress().getPath();
        	System.out.println(x);
        	String y=driver.getRemoteAddress().getProtocol();
        	System.out.println(y);
        	int z=driver.getRemoteAddress().getPort();
        	System.out.println(z);
        	String h=driver.getRemoteAddress().getHost();
        	System.out.println(h);
        	Date d1=new Date();        	
        	SimpleDateFormat sf=new SimpleDateFormat("dd/MMMM/yy");
        	String b=sf.format(d1);
        	System.out.println(b);
           	System.out.println(d1.toString());
        	String w=driver.getPlatformName();
        	System.out.println(w);
        	String u1=System.getProperty("os.name");
        	System.out.println(u1);
        	double v=driver.getDisplayDensity();
        	System.out.println(v);
        	Long a=driver.getDisplayDensity();
        	System.out.println(a);
        	//Notifications
        	driver.openNotifications();
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
