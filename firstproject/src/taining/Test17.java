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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.ui.Select;
public class Test17 
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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Launch site
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(24, TimeUnit.SECONDS);
		//Switch to frame
		driver.switchTo().frame("iframeResult");
		WebElement a=driver.findElement(By.name("cars"));
		Select s=new Select(a);
		// if conditon
		if(s.isMultiple())
		{
	      Actions d=new Actions(driver);
	      if(System.getProperty("os.name").contains("META"))
	      {
	    	  d.keyDown(Keys.META).build().perform();
	    	  Thread.sleep(3000);
	    	  d.click(s.getOptions().get(2)).build().perform();
	    	  Thread.sleep(3000);
	    	  d.click(s.getOptions().get(0)).build().perform();
	    	  Thread.sleep(3000);
	    	  d.keyUp(Keys.META).build().perform();
	      }
	      else
	      {
	    	  d.keyDown(Keys.CONTROL).build().perform();
	    	  Thread.sleep(3000);
	    	  d.click(s.getOptions().get(2)).build().perform();
	    	  Thread.sleep(3000);
	    	  d.click(s.getOptions().get(0)).build().perform();
	    	  Thread.sleep(3000);
	    	  d.keyUp(Keys.CONTROL).build().perform();
	      }
		}
		else
		{
			System.out.println("select Multiple");
		}
		//back to page
		driver.switchTo().defaultContent();
		//close
		Thread.sleep(3000);
		driver.close();
	}
}
		

