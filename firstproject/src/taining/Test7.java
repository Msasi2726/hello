package taining;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class Test7 
{
	public static void main(String[] args) throws Exception 
	{
		WebDriver driver=null;
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
			c.setBinary("C:\\Program Files\\Opera\\53.0.2907.99\\opera.exe");
			System.setProperty("webdriver.opera.driver","H:\\Selenium\\operadriver.exe");
	        driver=new OperaDriver(c);
		}
		else
		{
			System.out.println("invalid browser name");
			System.exit(0);
		}
		driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
		//Maximize
		driver.manage().window().maximize();
		//delete Cookies
		driver.manage().deleteAllCookies();
		int a=driver.manage().getCookies().size();
		System.out.println(a);
		//Lunch Site
		driver.get("http://www.way2sms.com");
		//delete cookies
		driver.manage().deleteAllCookies();
		int d=driver.manage().getCookies().size();
		System.out.println(d);
		//Login
		driver.findElement(By.name("username")).sendKeys("9494942726");
		driver.findElement(By.id("password")).sendKeys("9676530842");
		driver.findElement(By.id("loginBTN")).click();
		//Click Send SMS
		driver.findElement(By.xpath("//a[text()='Send SMS']")).click();
		//Switch to frame
		WebElement c=driver.findElement(By.xpath("//iframe[contains(@src,'sendSMS?')]"));
		driver.switchTo().frame(c);
		//Send SMS
		driver.findElement(By.id("mobile")).sendKeys("9603978262",Keys.TAB,"Hi dad good night and sweet dreams");
		driver.findElement(By.xpath("//input[@class='button br2up']")).click();
		//Switch to frame
		driver.switchTo().defaultContent();
		//Click Group SMS
		driver.findElement(By.xpath("//a[text()='Send SMS']")).click();
		//Close
		Thread.sleep(20000);
		driver.close();
	}
}
