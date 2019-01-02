package taining;

import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Test63
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
		WebDriverWait w=new WebDriverWait(driver,20);
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
				driver.findElement(By.xpath("//*[@text='Photo View']")).click();
				break;
			}
			catch(Exception ex)
			{
			TouchAction ta=new TouchAction(driver);
			ta.press(x1, y1).waitAction(Duration.ofMillis(2000)).moveTo(x2,y2).release().perform();
			}
		}
		/*w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='android.widget.ImageView'][@index='1']")));		
		WebElement a=driver.findElement(By.xpath("//*[@class='android.widget.ImageView'][@index='1']"));
		//int x=a.getLocation().getX();
		//int y=a.getLocation().getY();
		int w2=a.getSize().getWidth();
		int h2=a.getSize().getHeight();
		System.out.println(w2+"  "+h2);
		int x3=(int)(w2/2);
		int y3=(int)(h2/2);
		int x4=(int)(x3-10);
		int y4=(int)(y3);
		int x5=(int)(x3-40);
		int y5=(int)(y3);
		int x6=(int)(x3+10);
		int y6=(int)(y3);
		int x7=(int)(x3+40);
		int y7=(int)(y3);
		TouchAction ta1=new TouchAction(driver);
		Duration d=Duration.of(2, ChronoUnit.SECONDS);
		ta1.press(a,x4,y4).waitAction(d).moveTo(a,x5,y6).release().perform();
		TouchAction ta2=new TouchAction(driver);
		ta2.press(a,x6,y6).waitAction(d).moveTo(a,x7,y7).release().perform();
		MultiTouchAction ma=new MultiTouchAction(driver);
		ma.add(ta1).add(ta2).perform();
		Thread.sleep(20000);*/
		//part2
		driver.pressKeyCode(AndroidKeyCode.HOME);
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@text='Messaging']")));
		driver.findElement(By.xpath("//*[@text='Messaging']")).click();
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@text='VK-SBICRD  (15)']")));
		driver.findElement(By.xpath("//*[@text='VK-SBICRD  (15)']")).click();
		int w4=driver.manage().window().getSize().getWidth();
		int h4=driver.manage().window().getSize().getHeight();
		System.out.println(w4+"  "+h4);
		TouchAction ta3=new TouchAction(driver);
		Duration d1=Duration.of(2, ChronoUnit.SECONDS);
		ta3.press(530,960).waitAction(d1).moveTo(520,960).release();
		TouchAction ta4=new TouchAction(driver);
		ta4.press(550,960).waitAction(d1).moveTo(560,960).release();
		MultiTouchAction ma1=new MultiTouchAction(driver);
		ma1.add(ta3).add(ta4).perform();
		Thread.sleep(20000);
		TouchAction ta5=new TouchAction(driver);
		Duration d2=Duration.of(2, ChronoUnit.SECONDS);
		ta5.press(520,960).waitAction(d1).moveTo(530,960).release();
		TouchAction ta6=new TouchAction(driver);
		ta6.press(560,960).waitAction(d1).moveTo(550,960).release();
		MultiTouchAction ma2=new MultiTouchAction(driver);
		ma2.add(ta5).add(ta6).perform();
		Thread.sleep(20000);
		//back
		driver.launchApp();
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
