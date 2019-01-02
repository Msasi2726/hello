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

public class Smsfuture 
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
        driver.switchTo().activeElement().sendKeys("XXXXX");
        driver.findElement(By.name("password")).sendKeys("");
        driver.findElement(By.id("loginBTN")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        driver.findElement(By.name("password")).sendKeys("XXXX");
        driver.findElement(By.id("loginBTN")).click();        
        //click On Future sms
        driver.findElement(By.xpath("//a[text()='Future SMS']")).click();
        WebElement d=driver.findElement(By.xpath("//iframe[contains(@src,'futureSMS?')]"));
        driver.switchTo().frame(d);
        //Fill Msg
        driver.findElement(By.id("mobile")).sendKeys("XXXX");
        driver.findElement(By.name("sdate")).click();
        WebElement e=driver.findElement(By.xpath("(//a[@class='ui-state-default'])[3]"));
        Actions a=new Actions(driver);
        a.click(e).build().perform();
        driver.findElement(By.name("stime")).click();
        WebElement e1=driver.findElement(By.xpath("(//a[contains(@class,'ui-slider-handle')])[1]"));        
        a.dragAndDropBy(e1, 70, 0).build().perform();
        WebElement e2=driver.findElement(By.xpath("(//a[contains(@class,'ui-slider-handle')])[2]"));
        a.dragAndDropBy(e2, 80, 0).build().perform();
        driver.findElement(By.xpath("//button[text()='Done']")).click();
        driver.findElement(By.name("message")).sendKeys("hello");
        driver.findElement(By.xpath("//input[contains(@class,'button br2up')]")).click();
        //back to MainPage
        driver.switchTo().defaultContent();
        //Logout
        driver.findElement(By.xpath("//i[@class='out louti']")).click();
        //close
        driver.close();
	}
}
