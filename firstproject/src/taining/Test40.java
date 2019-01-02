package taining;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test40 
{
	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "H:\\Selenium\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
        //Launch site
		driver.get("http://www.gmail.com");
		WebDriverWait w=new WebDriverWait(driver, 40);
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("identifier")));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Do login
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter mail id");
		String x=sc.nextLine();
		driver.findElement(By.name("identifier")).sendKeys(x);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		Scanner sc1=new Scanner(System.in);
		System.out.println("Enter Password");
		String x1=sc.nextLine();
		driver.findElement(By.name("password")).sendKeys(x1);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		//Click on Compose mail
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='COMPOSE']")));
		driver.findElement(By.xpath("//div[text()='COMPOSE']")).click();
		//Compose mail
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("to")));
		//fill fields
		driver.findElement(By.name("to")).sendKeys("kiranmiriyala244@gmail.com");
		driver.findElement(By.name("subjectbox")).sendKeys("Hi its my mail in automation");
		driver.findElement(By.xpath("//div[@aria-label='Message Body']")).clear();
		driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys("Hi ra \nPlease find attachment for this mail \nBye ");
		//Click on attachment
		driver.findElement(By.xpath("(//div[@aria-label='Attach files']/descendant::div)[3]")).click();
		//Browse file path to Upload
		Thread.sleep(3000);  //for pop-up window
		StringSelection s=new StringSelection("C:\\Users\\Public\\Pictures\\Sample Pictures\\Tulips.jpg");		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		//Use javarobot
		Robot r=new Robot();
		if(System.getProperty("os.name").contains("Windows"))
        {
	     r.keyPress(KeyEvent.VK_CONTROL);
	     r.keyPress(KeyEvent.VK_V);
	     r.keyRelease(KeyEvent.VK_V);	     
	     r.keyRelease(KeyEvent.VK_CONTROL);
        }
        else if(System.getProperty("os.name").contains("Mac"))
        {
         r.keyPress(KeyEvent.VK_META);
   	     r.keyPress(KeyEvent.VK_V);
   	     r.keyRelease(KeyEvent.VK_V);	     
   	     r.keyRelease(KeyEvent.VK_META);
        }
        else if(System.getProperty("os.name").contains("Linux"))
        {
         r.keyPress(KeyEvent.VK_CONTROL);
   	     r.keyPress(KeyEvent.VK_V);
   	     r.keyRelease(KeyEvent.VK_V);	     
   	     r.keyRelease(KeyEvent.VK_CONTROL);	
        }
        else
        {
        	System.out.println("Wrong platform");
        	driver.close();
        	System.exit(0);
        }
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		//Send mail (swd)
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@aria-label,'Press enter to view the attachment and delete')]")));
		driver.findElement(By.xpath("//div[text()='Send']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Your message has been sent')]")));
		//Do logout
		driver.findElement(By.xpath("//a[contains(@title,'Google Account')]/span")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign out")));
		driver.findElement(By.linkText("Sign out")).click();
		//Close site
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		driver.close();
	}
}
