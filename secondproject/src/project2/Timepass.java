package project2;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Timepass
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
		//Delete mails			
		if(x2.equalsIgnoreCase("All"))
        {   
    		if(x3.equalsIgnoreCase("Yes"))
    		{
    			//primary
    			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Primary']")));
    			driver.findElement(By.xpath("//div[text()='Primary']")).click();   
    			WebElement a=driver.findElement(By.xpath("(//span[@class='Dj'])[1]/child::span[2]"));
    			driver.executeScript("var x=arguments[0].textContent;window.alert(x);",a);
    			Thread.sleep(2000);
    			String b=driver.switchTo().alert().getText();
    			System.out.println(b);
    			driver.switchTo().alert().accept();
    			int z=Integer.parseInt(b);
    			if(z!=0)
    			{
                for(int i=1;i<=z;i++)
                {			
                	for(int j=6;j<=11;j++)
                	{
				driver.findElement(By.xpath("(//table)["+j+"]/tbody/tr["+i+"]/td[2]")).click();
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@gh='mtb']/div/div/child::div[2]/div[3]")));
				driver.findElement(By.xpath("//div[@gh='mtb']/div/div/child::div[2]/div[3]")).click();
				Thread.sleep(1000);
                }
                }
                }
    			//social
    			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Social']")));
    			driver.findElement(By.xpath("//div[text()='Social']")).click();  
    			WebElement c=driver.findElement(By.xpath("(//span[@class='Dj'])[1]/child::span[2]"));
    			driver.executeScript("var x=arguments[0].textContent;window.alert(x);",c);
    			Thread.sleep(2000);
    			String d=driver.switchTo().alert().getText();
    			System.out.println(d);
    			driver.switchTo().alert().accept();
    			int y=Integer.parseInt(d);
    			if(y!=0)
    			{
                for(int i=1;i<=y;i++)
                {				
                	for(int j=6;j<=11;j++)
                	{
				driver.findElement(By.xpath("(//table)["+j+"]/tbody/tr["+i+"]/td[2]")).click();
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@gh='mtb']/div/div/child::div[2]/div[3]")));
				driver.findElement(By.xpath("//div[@gh='mtb']/div/div/child::div[2]/div[3]")).click();
				Thread.sleep(1000);
                }
                }
                }
    			//Promotions
    			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Promotions']")));
    			driver.findElement(By.xpath("//div[text()='Promotions']")).click();  
    			WebElement e=driver.findElement(By.xpath("(//span[@class='Dj'])[1]/child::span[2]"));
    			driver.executeScript("var x=arguments[0].textContent;window.alert(x);",e);
    			Thread.sleep(2000);
    			String f=driver.switchTo().alert().getText();
    			System.out.println(f);
    			driver.switchTo().alert().accept();
    			int u=Integer.parseInt(f);
    			if(u!=0)
    			{
                for(int i=1;i<=u;i++)
                {				
                	for(int j=6;j<=11;j++)
                	{
				driver.findElement(By.xpath("(//table)["+j+"]/tbody/tr["+i+"]/td[2]")).click();
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@gh='mtb']/div/div/child::div[2]/div[3]")));
				driver.findElement(By.xpath("//div[@gh='mtb']/div/div/child::div[2]/div[3]")).click();
				Thread.sleep(1000);
                }
                }
                }
    			//Updates
    			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='Updates'])[2]")));
    			driver.findElement(By.xpath("(//div[text()='Updates'])[2]")).click();  
    			WebElement g=driver.findElement(By.xpath("(//span[@class='Dj'])[1]/child::span[2]"));
    			driver.executeScript("var x=arguments[0].textContent;window.alert(x);",g);
    			Thread.sleep(2000);
    			String h=driver.switchTo().alert().getText();
    			System.out.println(h);
    			driver.switchTo().alert().accept();
    			int t=Integer.parseInt(h);
    			if(t!=0)
    			{
                for(int i=1;i<=t;i++)
                {		
                	for(int j=6;j<=11;j++)
                	{
				driver.findElement(By.xpath("(//table)["+j+"]/tbody/tr[\"+i+\"]/td[2]")).click();
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@gh='mtb']/div/div/child::div[2]/div[3]")));
				driver.findElement(By.xpath("//div[@gh='mtb']/div/div/child::div[2]/div[3]")).click();
				Thread.sleep(1000);
                }
                }
                }
    			//Forums
    			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Forums']")));
    			driver.findElement(By.xpath("//div[text()='Forums']")).click();  
    			WebElement l=driver.findElement(By.xpath("(//span[@class='Dj'])[1]/child::span[2]"));
    			driver.executeScript("var x=arguments[0].textContent;window.alert(x);",l);
    			Thread.sleep(2000);
    			String k=driver.switchTo().alert().getText();
    			System.out.println(k);
    			driver.switchTo().alert().accept();
    			int s=Integer.parseInt(k);
    			if(s!=0)
    			{
                for(int i=1;i<=s;i++)
                {		
                	for(int j=6;j<=11;j++)
                	{
				driver.findElement(By.xpath("(//table)["+j+"]/tbody/tr[\"+i+\"]/td[2]")).click();
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@gh='mtb']/div/div/child::div[2]/div[3]")));
				driver.findElement(By.xpath("//div[@gh='mtb']/div/div/child::div[2]/div[3]")).click();
				Thread.sleep(1000);
                }
                }
                }
    		}
        }
    		//close site
    		driver.close();
   
	}
	}	
	
