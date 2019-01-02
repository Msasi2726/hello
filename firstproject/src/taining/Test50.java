package taining;

import java.net.URL;


import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Test50
{
	public static void main(String[] args) throws Exception
	{
		//Take phone number from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Phone number");
		String x=sc.nextLine();
		//Provide details of Avd
		DesiredCapabilities dc=new DesiredCapabilities();		
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName", "emulator-5554");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion","4.2.2");
		dc.setCapability("appPackage", "com.android.contacts");
		dc.setCapability("appActivity", "com.android.contacts.DialtactsActivity");
		//Start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"npm clear cache --f\"");
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
	    Thread.sleep(3000);
		WebDriverWait w=new WebDriverWait(driver,9);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='dial']")));
		
		//Enter Phone Number
		for(int i=0;i<x.length();i++)
		{
			char d=x.charAt(i);
			String y=" ";
			switch(d)
			{
				case'0':
				y="zero";
				break;
				case'1':
					y="one";
					break;
				case'2':
					y="two";
					break;
				case'3':
					y="three";
					break;
				case'4':
					y="four";
					break;
				case'5':
					y="five";
					break;
				case'6':
					y="six";
					break;
				case'7':
					y="seven";
					break;
				case'8':
					y="eight";
					break;
				case'9':
					y="nine";
					break;
			}
			driver.findElement(By.xpath("//*[@content-desc='"+y+"']")).click();
			}
		//click dial
		driver.findElement(By.xpath("//*[@content-desc='dial']")).click();
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@content-desc='Audio']")));
		driver.findElement(By.xpath("//*[@content-desc='Audio']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='0:42']")));
		driver.findElement(By.xpath("//*[@contentdesc='End']")).click();
		//close App
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
