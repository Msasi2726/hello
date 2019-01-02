package taining;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.util.Scanner;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;


public class Test70 
{
	@SuppressWarnings({ "rawtypes", "resource" })
	public static void main(String[] args) throws Exception 
	{
		//Given color Name
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter red/green/blue/black");
		String cname=sc.nextLine();
		int count=0;
		int percentage;
		Color ec=null;
		switch(cname)
		{
		case "black":
			ec=Color.BLACK;
			break;
		case "red":
			ec=Color.RED;
			break;
		case "blue":
			ec=Color.BLUE;
			break;
		case "green":
			ec=new Color(0,128,0);
			break;
			default:
				System.out.println("Wrong color");
				System.exit(0);//Stop execution forcibly
		}
		//Provide details of ARD and App
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
		driver.findElement(By.xpath("//*[@text='LOG IN']")).click();
		int w1=driver.manage().window().getSize().getWidth();
		int h=driver.manage().window().getSize().getHeight();
		int x1=(int)(w1/2);
		int y1=(int)(h*0.9);
		int x2=(int)(x1);
		int y2=(int)(h*0.7);
		System.out.println(w1+"  "+h);		
		while(2>1)
		{
			try
			{
				driver.findElement(By.xpath("//*[@text='Wheel Picker']")).click();
				break;
			}
			catch(Exception ex)
			{
			TouchAction ta=new TouchAction(driver);
			ta.press(x1, y1).waitAction(Duration.ofMillis(2000)).moveTo(x2,y2).release().perform();
			}
		}
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@bounds='[60,720][1020,870]'][@index='1']")));
		WebElement a=driver.findElement(By.xpath("//*[@bounds='[60,720][1020,870]'][@index='1']"));
		TouchAction ta=new TouchAction(driver);
		ta.tap(a).perform();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.widget.ListView']")));
		driver.findElement(By.xpath("//*[@text='"+cname+"']")).click();
		WebElement e=driver.findElement(By.xpath("//*[@bounds='[0,243][1080,393]']"));
		//Get the location of Element on the app screen
		int x=e.getLocation().getX();
		int y=e.getLocation().getY();
		//get width and height of the Element
		int elewidth=e.getSize().getWidth();
		int eleheight=e.getSize().getHeight();
		File screenshot=driver.getScreenshotAs(OutputType.FILE);
		BufferedImage fullimg=ImageIO.read(screenshot);
		BufferedImage elescreenshot=fullimg.getSubimage(x, y, elewidth, eleheight);
		//check image color to validate
		for(int i=0;i<elewidth;i++)
		{
			for(int j=0;j<eleheight;j++)
			{
				Color ac=new Color(elescreenshot.getRGB(i,j));
				if(ac.getRed()==ec.getRed()&&ac.getBlue()==ec.getBlue()&&ac.getGreen()==ec.getBlue())
				{
					count=count+1;
				}
			}
		}
		System.out.println(count);
		percentage=(count*100)/(elewidth*eleheight);
		if(percentage>=85)
		{
			System.out.println("color test was passed");
		}
		else
		{
			System.out.println("color test failed");
		}
		//close app
		driver.closeApp();
		}
		catch(Exception exe)
		{
			System.out.println(exe.getMessage());
		}
		Thread.sleep(5000);
		//close app
		driver.closeApp();
		//Stop Appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
}
}