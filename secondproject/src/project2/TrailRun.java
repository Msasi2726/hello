package project2;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;

public class TrailRun
{
	public static void main(String[] args) throws Exception 
	{
		WebDriver driver=null;		
		System.setProperty("webdriver.chrome.driver", "H:\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
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
		System.out.println("Enter Password");
		String x1=sc.nextLine();
		System.out.println("like All");
		String x2=sc.nextLine();
		System.out.println("like:-Yes or No");
		String x3=sc.nextLine();
		driver.findElement(By.name("identifier")).sendKeys(x);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));			
		driver.findElement(By.name("password")).sendKeys(x1);
		driver.findElement(By.xpath("//span[text()='Next']")).click();	
		TrailRun obj = new TrailRun();        
		//Delete mails			
		if(x2.equalsIgnoreCase("All"))
        {   
    		if(x3.equalsIgnoreCase("Yes"))
    		{
    			//primary
    			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='aKz'])[1]")));
    			driver.findElement(By.xpath("(//div[@class='aKz'])[1]")).click();  
    			obj.clkDelete("delete");
    			//social
    			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='aKz'])[2]")));
    			driver.findElement(By.xpath("(//div[@class='aKz'])[2]")).click();  
    			obj.clkDelete("delete");
    			//Promotions
    			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='aKz'])[2]")));
    			driver.findElement(By.xpath("(//div[@class='aKz'])[3]")).click();  
    			obj.clkDelete("delete");
    			//Updates
    			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='aKz'])[2]")));
    			driver.findElement(By.xpath("(//div[@class='aKz'])[4]")).click();  
    			obj.clkDelete("delete");
    			//Forums
    			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='aKz'])[2]")));
    			driver.findElement(By.xpath("(//div[@class='aKz'])[5]")).click();  
    			obj.clkDelete("delete");
    		}
    		//close site
    		driver.close();
        }
	}	
	@SuppressWarnings("null")
	private void clkDelete(String del) throws Exception 
	{
		WebDriver driver=null;	
		if(del.equals("delete"))
		{
		while(2>1)
		{
		driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[7]")).click();		
		driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[40]")).click();
		driver.findElement(By.xpath("//div[@gh='mtb']/div/div/child::div[2]/div[3]")).click();
		Thread.sleep(2000);
		Screen s=new Screen();
		if(s.exists("zero.png") != null)
		{
			break;
		}
		
	}
	
}
	}
}
