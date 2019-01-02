package project2;

import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Micro
{
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Exception
	{	
		//Provide details of Avd
		DesiredCapabilities dc=new DesiredCapabilities();		
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName", "192.168.43.151:5555");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "4.4.2");
		dc.setCapability("appPackage", "com.tinno.led");
		dc.setCapability("appActivity", "com.tinno.led.LEDActivity");
		//Start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"npm clear cache --f\"");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
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
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter app name");
		String m=sc.nextLine();
		Thread.sleep(5000);
		if(m.equalsIgnoreCase("music"))
		{
			driver.pressKeyCode(AndroidKeyCode.HOME);
			Thread.sleep(2000);
			driver.pressKeyCode(AndroidKeyCode.HOME);
			//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='Apps']")));
			//driver.findElement(By.xpath("//*[@text='Apps']")).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Music']")));	
	        driver.findElement(By.xpath("//*[@text='Music']")).click();
	        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Songs']")));
	        driver.findElement(By.xpath("//*[@text='Songs']")).click();
	        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@bounds='[0,134][480,230]']")));
	        driver.findElement(By.xpath("//*[@bounds='[0,134][480,230]']")).click();	        
		}
		if(m.equalsIgnoreCase("torch"))
        {
		System.out.println("Enter like sos or normal");
		String x=sc.nextLine();		
		try
		{
			if(x.equalsIgnoreCase("sos"))
			{
		           w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.tinno.led:id/sos_button']")));	
		           driver.findElement(By.xpath("//*[@resource-id='com.tinno.led:id/sos_button']")).click();
		           Thread.sleep(20000);
		           driver.findElement(By.xpath("//*[@resource-id='com.tinno.led:id/sos_button']")).click();
		    }
			else
			{
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.tinno.led:id/led_button']")));	
				driver.findElement(By.xpath("//*[@resource-id='com.tinno.led:id/led_button']")).click();
				Thread.sleep(20000);
				driver.findElement(By.xpath("//*[@resource-id='com.tinno.led:id/led_button']")).click();
			}
			driver.closeApp();
		}        
		catch(Exception exe)
		{
			System.out.println(exe.getMessage());
		}
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
