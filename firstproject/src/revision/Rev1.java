package revision;

import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Rev1
{
	public static void main(String[] args) 
	{
		WebDriver driver = null;
		try
		{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Platform Computer/Mobile");
		String a=sc.nextLine();		
		if(a.equalsIgnoreCase("computer"))
		{		
		System.out.println("Enter browser Name");
		String b=sc.nextLine();
		if(b.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "H:\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		}
		else if(b.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "H:\\Selenium\\geckodriver.exe");
			driver=new FirefoxDriver();	
		}
		else if(b.equalsIgnoreCase("Opera"))
		{
			OperaOptions o=new OperaOptions();
			o.setBinary("C:\\Program Files\\Opera\\54.0.2952.64\\opera.exe");
			System.setProperty("webdriver.opera.driver", "H:\\Selenium\\operadriver.exe");
			driver=new OperaDriver(o);		
		}
		else if(b.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "H:\\Selenium\\IEdriverserver.exe");
			driver=new InternetExplorerDriver();		
		}
		else
		{
			System.out.println("Wrong Platform");
		}
		}
		else
		{
			//Detailes of ARD and App
			DesiredCapabilities dc=new DesiredCapabilities();
			dc.setCapability(CapabilityType.BROWSER_NAME,"chrome");
			dc.setCapability("deviceName", "0123456789ABCDEF");
			dc.setCapability("platformName", "android");
			dc.setCapability("platformVersion", "4.4.2");
			//Start appium server
			Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"npm clear cache --f\"");
			Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
			URL u=new URL("http://0.0.0.0:4723/wd/hub");
			//Create driver object and launch app
			while(2>1) 
			{
			try
			{
				driver=new AndroidDriver(u,dc);
				break;
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
		}
		}	
		//Common code
		//Launch site 
		driver.get("http://www.way2sms.com/?");
		//Wait
		WebDriverWait w=new WebDriverWait(driver,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='mobileNo']")));
		//Maximize
		if(a.equalsIgnoreCase("computer"))
		{
			driver.manage().window().maximize();
		}
		//login
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='mobileNo']")));
		driver.findElement(By.xpath("//*[@id='mobileNo']")).sendKeys("9494942726");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("9676530842");
		driver.findElement(By.xpath("(//button[text()='Login'])[2]")).click();
		
		//close
		driver.close();
		if(!a.equalsIgnoreCase("computer"))
		{
			//Stop appium server
			Runtime.getRuntime().exec("taskkill /F /IM node.exe");
			Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
