package taining;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Test58
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
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='LOG IN']")));
		driver.findElement(By.xpath("//*[@text='LOG IN']")).click();
		int w1=driver.manage().window().getSize().getWidth();
		int h=driver.manage().window().getSize().getHeight();
		int x1=(int)(w1/2);
		int y1=(int)(h*0.6);
		int x2=(int)(x1);
		int y2=(int)(h*0.4);
		while(2>1)
		{
			try
			{
				driver.findElement(By.xpath("//*[@text='Long Press']")).click();
				break;
			}
			catch(Exception e)
			{
			TouchAction ta=new TouchAction(driver);
			ta.press(x1, y1).waitAction(Duration.ofMillis(5000)).moveTo(x2,y2).release().perform();
			}
		}
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='longpress']")));
		WebElement a=driver.findElement(By.xpath("//*[@content-desc='longpress']"));
		TouchAction ta=new TouchAction(driver);
		Duration d=Duration.ofMillis(5000);
		ta.longPress(a).waitAction(d).release().perform();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='OK']")));
		driver.findElement(By.xpath("//*[@text='OK']")).click();
		//close app
		driver.closeApp();
		//Stop Appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	} 
}
