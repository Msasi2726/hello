package taining;

import java.net.URL;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Test57
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
		dc.setCapability("appPackage", "com.lenovo.anyshare.gps");
		dc.setCapability("appActivity", "com.lenovo.anyshare.main.MainActivity");
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
			WebDriverWait w=new WebDriverWait(driver,20);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Enter SHAREit']")));
			driver.findElement(By.xpath("//*[@text='Enter SHAREit']")).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Local']")));
			driver.findElement(By.xpath("//*[@text='Local']")).click();
			Set cs=driver.getContextHandles();
			System.out.println("No.of Contexts are   " +cs.size());
			System.out.println("contexts are");
			System.out.println(cs);
			List<String> pl=driver.getSupportedPerformanceDataTypes();
			for(int i=0;i<pl.size();i++)
			{
				System.out.print(pl.get(i)+"\t");
			}
			System.out.println();
			List<List<Object>> ci=driver.getPerformanceData("com.lenovo.anyshare.gps", "cpuinfo", 20000);
			{
				for(int i=0;i<ci.size();i++)
				{
					for(int j=0;j<ci.get(i).size();j++)
					{
						try
						{
						System.out.print(ci.get(i).get(j).toString() + "\t");	
						}
						catch(Exception exe)
						{
							System.out.print(0);
						}
					}
				}
				System.out.println();
			}
			List<List<Object>> ci1=driver.getPerformanceData("com.lenovo.anyshare.gps", "memoryinfo", 20000);
			{
				for(int i=0;i<ci1.size();i++)
				{
					for(int j=0;j<ci1.get(i).size();j++)
					{
						try
						{
						System.out.print(ci1.get(i).get(j).toString() + "\t");	
						}
						catch(Exception exe)
						{
							System.out.print(0);
						}
					}
				}
				System.out.println();
			}
			List<List<Object>> ci2=driver.getPerformanceData("com.lenovo.anyshare.gps", "batteryinfo", 20000);
			{
				for(int i=0;i<ci2.size();i++)
				{
					for(int j=0;j<ci2.get(i).size();j++)
					{
						try
						{
						System.out.print(ci1.get(i).get(j).toString() + "\t");	
						}
						catch(Exception exe)
						{
							System.out.print(0);
						}
					}
				}
				System.out.println();
			}
			List<List<Object>> ci3=driver.getPerformanceData("com.lenovo.anyshare.gps", "networkinfo", 20000);
			{
				for(int i=0;i<ci3.size();i++)
				{
					for(int j=0;j<ci3.get(i).size();j++)
					{
						try
						{
						System.out.print(ci1.get(i).get(j).toString() + "\t");	
						}
						catch(Exception exe)
						{
							System.out.print(0);
						}
					}
				}
				System.out.println();
			}
			//close app
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
