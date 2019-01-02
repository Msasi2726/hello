package taining;

import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Test65
{
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Exception
	{
		//details of ARD and App
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName", "8bbbc489");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion","5.1.1");
		dc.setCapability("appPackage", "com.vodqareactnative");
		dc.setCapability("appActivity", "com.vodqareactnative.MainActivity");
		//start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"npm clear cache --f\"");
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
		while(2>1)
		{
			try
			{
				driver.findElement(By.xpath("//*[@text='Double Tap']")).click();
				break;
			}
			catch(Exception ex)
			{
			TouchAction ta=new TouchAction(driver);
			ta.press(x1, y1).waitAction(Duration.ofMillis(2000)).moveTo(x2,y2).release().perform();
			}
		}
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@text='Double Tap Me']")));		
		WebElement a=driver.findElement(By.xpath("//*[@text='Double Tap Me']"));
		TouchAction ta1=new TouchAction(driver);
		ta1.tap(a);
		TouchAction ta2=new TouchAction(driver);
		ta2.waitAction(Duration.ofMillis(100)).tap(a);
		MultiTouchAction ma=new MultiTouchAction(driver);
		ma.add(ta1).add(ta2).perform();
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@text='OK']")));
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
