package taining;

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
import org.openqa.selenium.remote.RemoteWebDriver;

public class Test30 
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
		 //Scroll to bottom	 
			((RemoteWebDriver) driver).executeScript("window.scrollTo(0,document.body.scrollHeight);");
			Thread.sleep(5000);
			//Scroll to Tops	 
			((RemoteWebDriver) driver).executeScript("window.scrollTo(document.body.scrollHeight,0);");
			Thread.sleep(5000);
			//Scroll to Specific Element
			WebElement e=driver.findElement(By.xpath("(//*[text()='Multiple Selection'])[2]"));
			((RemoteWebDriver) driver).executeScript("arguments[0].scrollIntoView();",e);
		 //Close
		 driver.close();
	}
}
