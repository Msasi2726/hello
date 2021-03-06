package taining;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test34 
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
		Scanner sc1=new Scanner(System.in);
		System.out.println("Enter a word");
		String y=sc1.nextLine();
		//Launch site
		driver.get("https://angularjs.org/");
		//expicit wait
		WebDriverWait w=new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@ng-model='yourName']")));
		driver.manage().window().maximize();
		//implicit Wait for locating elements
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@ng-model='yourName']")).sendKeys("y");
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h1[text()='Hello "+y+"!']")));
		//close
		driver.close();
	}
}
