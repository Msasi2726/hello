package taining;

import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.android.AndroidDriver;

public class Test66 
{
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Exception 
	{
		//Get Enviornment
		Scanner sc1=new Scanner(System.in);
		System.out.println("Enter platform as Computer/mobile");
		String p=sc1.nextLine();
		WebDriver driver = null;
		if(p.equalsIgnoreCase("computer"))
		{		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter browser name");
		String b=sc.nextLine();
		if(b.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver","H:\\Selenium\\chromedriver.exe");
        driver=new ChromeDriver();
		}
		else if(b.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","H:\\Selenium\\geckodriver.exe");
	        driver=new FirefoxDriver();	
		}
		else if(b.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver","H:\\Selenium\\IEDriverserver.exe");
	        driver=new InternetExplorerDriver();
		}
		else if(b.equalsIgnoreCase("opera"))
		{
			OperaOptions c=new OperaOptions();
			c.setBinary("C:\\Program Files\\Opera\\54.0.2952.64\\opera.exe");
			System.setProperty("webdriver.opera.driver","H:\\Selenium\\operadriver.exe");
	        driver=new OperaDriver(c);
		}
		else
		{
			System.out.println("invalid browser name");
			System.exit(0);
		}
		}
		else
		{
			//provide details of ARD and APP
			DesiredCapabilities dc=new DesiredCapabilities();
			dc.setCapability(CapabilityType.BROWSER_NAME,"chrome");
			dc.setCapability("deviceName", "8bbbc489");
			dc.setCapability("platformName", "android");
			dc.setCapability("platformVersion","5.1.1");
			//start appium server
			Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"npm clear cache --f\"");
			Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
			URL u=new URL("http://0.0.0.0:4723/wd/hub");
			//create driver object and Launch
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
		}
	   driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	   //launch site
	   driver.get("http://www.newtours.demoaut.com/");	   
	   //Maximize window
	   //driver.manage().window().maximize();
	   //Register
	   driver.findElement(By.linkText("REGISTER")).click();
	   driver.findElement(By.name("firstName")).sendKeys("Sesikiran");
	   driver.findElement(By.name("lastName")).sendKeys("Miriyala");
	   driver.findElement(By.name("phone")).sendKeys("9848022338");
	   driver.findElement(By.id("userName")).sendKeys("msasikiran333@gmail.com");
	   driver.findElement(By.name("address1")).sendKeys("Spadu,GMandal");
	   driver.findElement(By.name("address2")).sendKeys("Krishna Dist");
	   driver.findElement(By.name("city")).sendKeys("Vijayawada");
	   driver.findElement(By.name("state")).sendKeys("Andhrapradesh");
	   driver.findElement(By.name("postalCode")).sendKeys("521405");
	   WebElement a=driver.findElement(By.name("country"));
	   Select d=new Select(a);
	   d.selectByVisibleText("INDIA");
	   driver.findElement(By.name("email")).sendKeys("msasikiran333@gmail.com");
	   driver.findElement(By.name("password")).sendKeys("9494942726");
	   driver.findElement(By.name("confirmPassword")).sendKeys("9595356789");
	   driver.findElement(By.name("register")).click();
	   //Close
	   driver.close();
	   if(!p.equalsIgnoreCase("computer"))
	   {
		//Stop Appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	   }
	}
}
