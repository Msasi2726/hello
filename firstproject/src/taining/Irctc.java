package taining;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Irctc
{
	public static void main(String[] args) throws Exception
	{
		//start
		System.setProperty("webdriver.chrome.driver","H:\\Selenium\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		Scanner s=new Scanner(System.in);
		System.out.println("From where");
		String x=s.nextLine();
		System.out.println("to");
		String y=s.nextLine();
		//launch site
	    driver.get("https://www.irctc.co.in/nget/train-search");
	    WebDriverWait w=new WebDriverWait(driver, 40);
	    w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='From*']")));
	    driver.manage().window().maximize();
	    driver.findElement(By.xpath("//a[@id='loginText']")).click();
	    driver.findElement(By.xpath("//input[@name='userId']")).sendKeys("Msasi225");
	    driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("Ms@si1244");	    
	    Thread.sleep(15000);
	    driver.findElement(By.xpath("//button[text()='SIGN IN']")).click();
	    driver.findElement(By.xpath("//input[@placeholder='From*']")).sendKeys(x);
	    driver.findElement(By.xpath("//input[@placeholder='To*']")).sendKeys(y);
	    driver.findElement(By.xpath("(//span[text()='+y+'])[1]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//input[@placeholder='Journey Date(dd-mm-yyyy)*']")).click();
	    WebElement a=driver.findElement(By.xpath("(//a[contains(@class,'ui-state-default')])[26]"));
	    a.click();
	    WebElement b=driver.findElement(By.xpath("//button[text()='Find trains']"));
	    //driver.executeScript("arguments[0].click();", a);
	    b.click();
	    //close
	    driver.close();
	}
}
