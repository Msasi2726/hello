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

public class Samplay
{
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Exception
	{	
		//Provide details of Avd
		DesiredCapabilities dc=new DesiredCapabilities();		
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName", "192.168.43.223:5555");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion","5.1.1");
		dc.setCapability("appPackage", "com.android.vending");
		dc.setCapability("appActivity", "com.android.vending.AssetBrowserActivity");
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
		WebDriverWait w=new WebDriverWait(driver,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='Search']")));
		driver.findElement(By.xpath("//*[@content-desc='Search']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@bounds='[108,50][432,117]']")));
		driver.findElement(By.xpath("//*[@bounds='[108,50][432,117]']")).sendKeys("Music Player");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='music player mp3']")));
		driver.findElement(By.xpath("//*[@text='music player mp3']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@bounds='[18,501][522,621]']")));
		WebElement e=driver.findElement(By.xpath("//*[@bounds='[18,501][522,621]']"));
		TouchAction ta=new TouchAction(driver);
		ta.tap(e).perform();		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='INSTALL']")));
		driver.findElement(By.xpath("//*[@text='INSTALL']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@bounds='[312,740][492,794]']")));
		driver.findElement(By.xpath("//*[@bounds='[312,740][492,794]']")).click();
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='INSTALL']")));
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
