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

public class Test61
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
		dc.setCapability("appPackage", "com.vodqareactnative");
		dc.setCapability("appActivity", "com.vodqareactnative.MainActivity");
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
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='LOG IN']")));
		driver.findElement(By.xpath("//*[@text='LOG IN']")).click();
		int w1=driver.manage().window().getSize().getWidth();
		int h=driver.manage().window().getSize().getHeight();
		int x1=(int)(w1/2);
		int y1=(int)(h*0.9);
		int x2=(int)(x1);
		int y2=(int)(h*0.7);
		System.out.println(w1+"  "+h);
		//zooming porpous
		int x3=(int)(x1-5);
		int y3=(int)(h/2);
		int x4=(int)(x3-15);
		int y4=y3;
		int x5=(int)(x1+5);
		int y5=y3;
		int x6=(int)(x5+15);
		int y6=y3;
		while(2>1)
		{
			try
			{
				driver.findElement(By.xpath("//*[@text='Photo View']")).click();
				break;
			}
			catch(Exception ex)
			{
			TouchAction ta=new TouchAction(driver);
			ta.press(x1, y1).waitAction(Duration.ofMillis(2000)).moveTo(x2,y2).release().perform();
			}
		}
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@text='Back']")));
		TouchAction ta1=new TouchAction(driver);
		Duration d=Duration.of(5, ChronoUnit.SECONDS);
		ta1.press(x3,y3).waitAction(d).moveTo(x4,y4).release();
		TouchAction ta2=new TouchAction(driver);
		ta1.press(x5, y5).waitAction(d).moveTo(x6,y6).release();
		MultiTouchAction ma=new MultiTouchAction(driver);
		ma.add(ta1).add(ta2).perform();
		}
		catch(Exception exe)
		{
			System.out.println(exe.getMessage());
		}
		Thread.sleep(5000);
		//close app
		driver.closeApp();
		//Stop Appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	} 
}
