package taining;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class Test22 
{
	public static void main(String[] args) throws InterruptedException
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
		 //launch site
		 driver.get("http://jqueryui.com/slider/");
		 //maximize window
		 driver.manage().window().maximize();		
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 //Automate Horizontal slider
		 driver.switchTo().frame(0);
		 WebElement e1=driver.findElement(By.xpath("//span[contains(@class,'ui-slider-handle')]"));
		 //slider from left to right	 
		 Actions a=new Actions(driver);
		 a.dragAndDropBy(e1, 150, 0).build().perform();
		 Thread.sleep(5000);
		 a.dragAndDropBy(e1, -50, 0).build().perform();
		 Thread.sleep(5000);
		 //Back to Page
		 driver.switchTo().defaultContent();
		 Thread.sleep(5000);
		 //Click on Vertical Slider
		 driver.findElement(By.linkText("Vertical slider")).click();
		 Thread.sleep(5000);
		 //Automate Vertical slider
		 driver.switchTo().frame(0);
		 WebElement e2=driver.findElement(By.xpath("//span[contains(@class,'ui-slider-handle')]"));
		 a.dragAndDropBy(e2, 0, 150).build().perform();
		 Thread.sleep(5000);
		 a.dragAndDropBy(e2, 0, -80).build().perform();
		 Thread.sleep(5000);
		 //Back to Page
		 driver.switchTo().defaultContent();
		 //Close
		 driver.close();
	}
}
