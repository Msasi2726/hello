package project2;

import java.util.List;
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

public class Trash
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
        driver.manage().deleteAllCookies();
        //Count of  Cookies
        int a=driver.manage().getCookies().size();
        System.out.println(a); 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Launch site
        driver.get("http://www.gmail.com");
        //Maximize
        driver.manage().window().maximize();
        //Login
        driver.findElement(By.xpath("//input[@name='identifier']")).sendKeys("msasikiran225");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Next']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Ms@si2726");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Next']")).click();
        Thread.sleep(10000);
        //Count no.of mails in Trash and Delete 
        int i=1;
        Thread.sleep(10000);
        driver.findElement(By.xpath("(//div[@class='n6'])/child::span/child::span[3]/div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("((//div[@class='aim'])/div/div/div/span/a)[last()]")).click();
        Thread.sleep(3000);  
        for(i=7;i<=20;)
        {
        List<WebElement> t=driver.findElements(By.xpath("(//table)["+i+"]/tbody/tr"));
        Thread.sleep(5000); 
        System.out.println("Count mails in Trash  "+ t.size());    
        Thread.sleep(10000);
        if(t.size()!=0)
        {
        	for(i=1;i<=t.size();) 	
            {        	
    		driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[7]")).click();
        	Thread.sleep(3000);
        	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[37]")).click();
        	Thread.sleep(3000);
        	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[11]")).click();
        	Thread.sleep(4000);
        	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[25]")).click();
        	Thread.sleep(4000);
        	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[7]")).click();
        	Thread.sleep(3000);
        	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[37]")).click();
        	Thread.sleep(3000);
        	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[11]")).click();
        	Thread.sleep(4000);
            }
        }
        	else
        	{
        //Logout
        driver.findElement(By.xpath("(//a[contains(@title,'Google')])[3]/span")).click();
        driver.findElement(By.xpath("//a[text()='Sign out']")).click();  
        	}
        //close
        driver.close();
	}
}
}
