package project2;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Photo
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
		dc.setCapability("appPackage", "com.android.camera2");
		dc.setCapability("appActivity", "com.android.camera.CameraLauncher");
		//Start appium server
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
		WebDriverWait w=new WebDriverWait(driver,10);
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='android.widget.ImageView']")));
		driver.findElement(By.xpath("//*[@class='android.widget.ImageView']")).click();
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='No thanks']")));
		driver.findElement(By.xpath("//*[@text='No thanks']")).click();
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@resource-id='com.android.camera2:id/onscreen_capture_mode_picker'][@index='3']")));
		WebElement a=driver.findElement(By.xpath("//*[@resource-id='com.android.camera2:id/onscreen_capture_mode_picker'][@index='3']"));
		TouchAction ta=new TouchAction(driver);
		ta.tap(a).perform();
		//select time
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Timer'][@index='1']")));
		driver.findElement(By.xpath("//*[@text='Timer'][@index='1']")).click();
		Thread.sleep(5000);
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@NAF='true'][@index='1']")));
		WebElement b=driver.findElement(By.xpath("//*[@resource-id='com.android.camera2:id/timer_pickers_5s'][@index='1']"));
		ta.tap(b).perform();
		WebElement c=driver.findElement(By.xpath("//*[@resource-id='com.android.camera2:id/onscreen_flash_picker'][@index='1']"));
		ta.tap(c).perform();
		for(int i=1;i<=10;i++)
		{
		//click
			w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@content-desc='Shutter'][@index='1']")));
			driver.findElement(By.xpath("//*[@content-desc='Shutter'][@index='1']")).click();
		}
		//close App
		Thread.sleep(10000);
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
