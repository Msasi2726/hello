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

public class Gmail 
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
        driver.findElement(By.xpath("//input[@name='identifier']")).sendKeys("XXXXX");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Next']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("XXXX");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Next']")).click();
        Thread.sleep(4000);
        //Count no.of mails in Social Mail delete
        driver.findElement(By.xpath("(//div[@class='aKz'])[2]")).click();
        Thread.sleep(2000);
        List<WebElement> d=driver.findElements(By.xpath("(//table)[8]/tbody/tr"));
        System.out.println(d.size()); 
        Thread.sleep(1000);
        for(int i=1;i<=d.size();)
        	{
        		driver.findElement(By.xpath("(//table)[8]/tbody/tr["+i+"]/td[2]/div")).click();
        		Thread.sleep(1000);
            	driver.findElement(By.xpath("//div[@gh='mtb']/div/div/child::div[2]/div[3]")).click();
        	}   
        Thread.sleep(8000);
        //Logout
        driver.findElement(By.xpath("(//a[contains(@title,'Google')])[3]/span")).click();
        driver.findElement(By.xpath("//a[text()='Sign out']")).click();              
        //close
        driver.close();
	}
}
