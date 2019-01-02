package project2;

import java.net.URL;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Smasung
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
		dc.setCapability("appPackage", "com.google.android.youtube");
		dc.setCapability("appActivity", "com.google.android.apps.youtube.app.WatchWhileActivity");
		//Start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"npm clear cache --f\"");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
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
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Search");
		String x=sc.nextLine();
		WebDriverWait w=new WebDriverWait(driver,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.google.android.youtube:id/menu_search']")));	
		driver.findElement(By.xpath("//*[@resource-id='com.google.android.youtube:id/menu_search']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.google.android.youtube:id/search_edit_text']")));
		driver.findElement(By.xpath("//*[@resource-id='com.google.android.youtube:id/search_edit_text']")).sendKeys(x);
		Thread.sleep(5000);
		WebElement e=driver.findElement(By.xpath("//*[@bounds='[0,120][540,192]']"));
		TouchAction ta=new TouchAction(driver);
		ta.tap(e).perform();		
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
