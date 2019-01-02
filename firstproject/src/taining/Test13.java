package taining;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class Test13 
{
	public static void main(String[] args)
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
        driver.manage().deleteAllCookies();
        //Launch site
        driver.get("http://www.way2sms.com");
        driver.manage().window().maximize();
        WebElement a=driver.findElement(By.xpath("//h1[@class='out logoi fl']"));
        try
        {
        	if(a.isDisplayed())
        	{
        		if(a.isEnabled())
        		{
        			if(a.isSelected())
        			{
        				System.out.println("Selected");
        			}
        			else
        			{
        				System.out.println("Not Selected");
        			}
        		}
        		else
        		{
        			System.out.println("Not Enabled");
        		}
        	}
        	else
        	{
        		System.out.println("Not Displayed");
        	}
        }
        catch(Exception f)
        {
        	System.out.println("Wrong Element");
        }
        //close
        driver.close();
	}
}
