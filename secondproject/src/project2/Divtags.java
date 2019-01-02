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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class Divtags
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
		 //launch site		 		
		 driver.get("https://semantic-ui.com/modules/dropdown.html");
		 //maximize window
		 driver.manage().window().maximize();		
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 //open drop down (Mandatory)
		 Actions a=new Actions(driver);
		 WebElement d=driver.findElement(By.xpath("(//div[contains(@class,'selection multiple')])[1]"));
		 a.click(d).build().perform();
		 Thread.sleep(1000);
		 List<WebElement> l=driver.findElements(By.xpath("//div[@class='menu transition visible']/div"));
		 System.out.println(l.size());
		 for(int i=0;i<l.size();i++)
		 {
		 System.out.println(l.get(i).getText());		 
		 }
		 Thread.sleep(1000);
		 //select all 	
		 for(int i=1;i<=l.size();i++)
		 {
			 driver.findElement(By.xpath("//div[@class='menu transition visible']/div["+i+"]")).click();		 
		 }	
		 Thread.sleep(1000);		 
		 //Deselect 	
		 List<WebElement> li=driver.findElements(By.xpath("(//div[@class='ui fluid dropdown selection multiple']/select/option)"));
		 System.out.println(li.size());
		 for(int i=1;i<=1;)
		 {			
			 driver.findElement(By.xpath("(//i[@class='delete icon'])["+i+"]")).click();			 			 
		 }			
		 Thread.sleep(1000);
		 //close
		 driver.close(); 
	}
}
