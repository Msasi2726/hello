package taining;

import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Test55 
{	
	public static void main(String[] args) throws Exception 
	{				
		//Provide details of Avd
		DesiredCapabilities dc=new DesiredCapabilities();		
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName", "8bbbc489");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion","5.1.1");		
		dc.setCapability("appPackage", "com.whatsapp");
		dc.setCapability("appActivity", "com.whatsapp.HomeActivity");
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
        	Scanner sc=new Scanner(System.in);
        	System.out.println("Enter register number");
        	String x=sc.nextLine();
        	//login
        	WebDriverWait w=new WebDriverWait(driver,140);
        	w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Agree and continue']")));
        	driver.findElement(By.xpath("//*[@text='Agree and continue']")).click();
        	w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='phone number']")));
        	driver.hideKeyboard();
        	driver.findElement(By.xpath("//*[@text='phone number']")).sendKeys(x);
        	w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Next']")));
        	driver.findElement(By.xpath("//*[@text='Next']")).click();
        	w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='OK']")));
        	driver.findElement(By.xpath("//*[@text='OK']")).click();
        	driver.hideKeyboard();
        	w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@resource-id='com.whatsapp:id/verify_sms_code_input']")));
            w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Next']"))).click();    
        	System.out.println("Enter text like restore or skip");
            String y=sc.nextLine();
            if(y.equalsIgnoreCase("Restore"))
            {
            	driver.findElement(By.xpath("//*[@text='Restore']")).click();
            }
            else
            {
            	driver.findElement(By.xpath("Skip")).click();
            }
            driver.findElement(By.xpath("//*[@text='Next']")).click();
        	//close app
        	Thread.sleep(10000);
        	driver.closeApp();      	
        }
        catch (Exception ex)
        {
        	System.out.println(ex.getMessage());
        }
        //Stop appium Server
        Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}
}
