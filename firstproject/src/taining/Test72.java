package taining;

import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;

public class Test72 
{
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Exception 
	{
		//details of ARD and App
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName", "8bbbc489");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion","5.1.1");
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
		try
		{
		WebDriverWait w=new WebDriverWait(driver,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='LOG IN']")));
		//back to Home
		driver.pressKeyCode(AndroidKeyCode.HOME);
		//Take phone number from keyboard for calling 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter contact name");
		String x=sc.nextLine();
		//Go to Phone app
		Activity a=new Activity("com.lenovo.ideafriend","com.lenovo.ideafriend.alias.DialtactsActivity");
		driver.startActivity(a);		
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
		File src=driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("call.png");
		FileUtils.copyFile(src, dest);
		driver.launchApp();
		driver.closeApp();
		//Load inbuilt "tessdata" folder,which have characters
		File fo=LoadLibs.extractTessResources("tessdata");
		//create object to apply OCR on Image
        Tesseract obj= new Tesseract(); 
        obj.setDatapath(fo.getAbsolutePath());
        //take Screenshot file,which have text in content
        File f= new File("call.PNG");
        String r= obj.doOCR(f);
        Thread.sleep(20000);
        System.out.println(r);
        //Results
        if(r.contains("conditional"))
        {
        	System.out.println("Test Passed");
        }
        else
        {
        	System.out.println("Test Failed");
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
