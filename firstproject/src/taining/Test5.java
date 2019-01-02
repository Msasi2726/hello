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
import org.openqa.selenium.support.ui.Select;

public class Test5 
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
	   driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
	   //launch site
	   driver.get("http://www.newtours.demoaut.com/");	   
	   //Maximize window
	   driver.manage().window().maximize();
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
	}
}
