package project2;

import java.net.URL;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class LenovaContact
{
	public static void main(String[] args) throws Exception
	{
		//Take phone number from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter contact name");
		String x=sc.nextLine();	
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
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@bounds='[180,1596][531,1728]']")));
		//Click contact
		driver.findElement(By.xpath("//*[@bounds='[540,1749][810,1920]']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@bounds='[138,255][972,399]']")));
		driver.findElement(By.xpath("//*[@bounds='[138,255][972,399]']")).sendKeys(x);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@bounds='[0,653][1080,835]']")));
		driver.findElement(By.xpath("//*[@bounds='[0,653][1080,835]']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@bounds='[189,690][828,932]']")));
		driver.findElement(By.xpath("//*[@bounds='[189,690][828,932]']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@bounds='[119,894][961,1074]']")));
		driver.findElement(By.xpath("//*[@bounds='[119,894][961,1074]']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@bounds='[180,1596][531,1728]']")));
		driver.findElement(By.xpath("//*[@bounds='[180,1596][531,1728]']")).click();
		//Click speaker
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@bounds='[678,1361][954,1620]']")));
		driver.findElement(By.xpath("//*[@bounds='[678,1361][954,1620]']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@contentdesc='End']")));
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
