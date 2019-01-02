package taining;

import java.net.URL;


import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Test52
{
	public static void main(String[] args) throws Exception 
	{
		//Take phone number from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Contact Name or Number");
		String x=sc.nextLine();
		System.out.println("Enter Contact Position");
		int y=sc.nextInt();
		System.out.println("Select Sim like 1 or 2");
		int z=sc.nextInt();
		//Provide details of Avd
		DesiredCapabilities dc=new DesiredCapabilities();		
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName", "8bbbc489");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion","5.1.1");
		dc.setCapability("appPackage", "com.lenovo.ideafriend");
		dc.setCapability("appActivity", "com.lenovo.ideafriend.alias.DialtactsActivity");
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
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Contacts']")));
		driver.findElement(By.xpath("//*[@text='Contacts']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.lenovo.ideafriend:id/searchedit']")));
		driver.findElement(By.xpath("//*[@resource-id='com.lenovo.ideafriend:id/searchedit']")).sendKeys(x);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='No match found.' or @text='All contacts']")));
		try
		{
			if(driver.findElement(By.xpath("//*[@text='No match found.']")).isDisplayed())
			{
				System.out.println("No Contact Found");
			}
		}
			catch(Exception exe)
			{
				driver.findElement(By.xpath("//*[@class='android.view.View'][@index='"+(y+1)+"']")).click();
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.lenovo.ideafriend:id/actions_view_container']")));
				driver.findElement(By.xpath("//*[@resource-id='com.lenovo.ideafriend:id/actions_view_container']")).click();
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Call via']")));
				if(z==1)
				{
					driver.findElement(By.xpath("//*[@text='Jio 4G']")).click();
				}
				else
				{
					driver.findElement(By.xpath("//*[@text='Vodafone IN']")).click();
				}
				Thread.sleep(10000);
				//Handling dynamic screen elements using Android
				try
				{	
					w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@bounds='[180,1596][531,1728]']")));
					driver.findElementByAndroidUIAutomator("new UiSelector().description(\"Speaker\")").click();
					Thread.sleep(19000);
				if(driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Dialing\")").isDisplayed())
                {
					driver.findElementByAndroidUIAutomator("new UiSelector().description(\"End\")").click();
                }
				}
				catch(Exception exec)
				{						
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='00:40']")));
					driver.findElementByAndroidUIAutomator("new UiSelector().description(\"End\")").click();					
				try
				{
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='OK']")));
					if(driver.findElement(By.xpath("//*[@resource-id='android:id/message']")).isDisplayed())
					{
					String v=driver.findElement(By.xpath("//*[@resource-id='android:id/message']")).getAttribute("text");
					System.out.println(v);
					driver.findElement(By.xpath("//*[@text='OK']")).click();
				    }
			    }		
				catch(Exception execi)
				{					
				}
				}
			}
		//Close app
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
