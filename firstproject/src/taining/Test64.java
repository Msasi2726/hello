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

public class Test64 
{
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Exception 
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","0123456789ABCDEF");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "4.4.2");
		dc.setCapability("appPackage", "com.vodqareactnative");
		dc.setCapability("appActivity", "com.vodqareactnative.MainActivity");
		//Start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Create driver object and Launch
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
		WebDriverWait w=new WebDriverWait(driver,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='LOG IN']")));
		driver.findElement(By.xpath("//*[@text='LOG IN']")).click();
		int w1=driver.manage().window().getSize().getWidth();
		int h=driver.manage().window().getSize().getHeight();
		int x1=(int)(w1/2);
		int y1=(int)(h*0.7);
		int x2=(int)(x1);
		int y2=(int)(h*0.6);	
		while(2>1)
		{
			try
			{
				driver.findElement(By.xpath("//*[@text='Slider']")).click();
				break;
			}
			catch(Exception exe)
			{				
				TouchAction ta=new TouchAction(driver);
				ta.press(x1, y1).waitAction(Duration.ofMillis(2000)).moveTo(x2,y2).release().perform();
			}
		}
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='0']")));
		WebElement e1=driver.findElement(By.xpath("//*[@content-desc='slider']"));
		WebElement e2=driver.findElement(By.xpath("//*[@content-desc='slider1']"));
		int e1x1=e1.getLocation().getX();
		int e1y1=e1.getLocation().getY();
		int e1x2=e1x1+90;
		int e1y2=e1y1;
		int e2x1=e2.getLocation().getX();
		int e2y1=e2.getLocation().getY();
		int e2x2=e2x1+90;
		int e2y2=e2y1;
		TouchAction ta1=new TouchAction(driver);
		Duration d=Duration.of(5,ChronoUnit.SECONDS);
		ta1.press(e1x1,e1y1).waitAction(d).moveTo(e1x2,e1y2).release();
		TouchAction ta2=new TouchAction(driver);
		ta2.press(e2x1,e2y1).waitAction(d).moveTo(e2x2,e2y2).release();
		MultiTouchAction ma=new MultiTouchAction(driver);
		ma.add(ta1).add(ta2).perform();
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='0']")));
		}
		catch(Exception ex)
		{	
			System.out.println(ex.getMessage());
		}
		//close app
		driver.closeApp();
		//Stop Appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
	    Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}
}

