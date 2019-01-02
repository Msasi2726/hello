package project2;
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

public class Way2SMS1
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
        int z=driver.manage().getCookies().size();
        System.out.println(z); 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Launch site
        driver.get("http://www.way2sms.com");
        //Maximize
        driver.manage().window().maximize();
        //Login
        driver.findElement(By.name("mobileNo")).sendKeys("XXXXX");
        driver.findElement(By.name("password")).sendKeys("XXXXX");
        driver.findElement(By.xpath("(//button[text()='Login'])[2]")).click();  
        //Send MSG with Smile
        driver.findElement(By.name("toMobile")).sendKeys("xxxxxx");
        driver.findElement(By.name("message")).click();
        Thread.sleep(3000);
        WebElement a=driver.findElement(By.xpath("(//button[@class='btn btn-secondary'])[4]"));
        WebElement d=driver.findElement(By.xpath("(//div[@class='col-sm-6'])[1]"));
        Actions c=new Actions(driver);
        c.click(a).build().perform();
        c.click(d).build().perform();
        driver.findElement(By.id("sendButton")).click();
        Thread.sleep(4000);
        //close
        driver.close();
	}
}
