package project2;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;

public class GmailALLInbox 
{	
	public static void main(String[] args) throws Exception
	{		
		System.setProperty("webdriver.chrome.driver","H:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();		  
        //Launch site
        driver.get("http://www.gmail.com");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebDriverWait w=new WebDriverWait(driver,40);
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='identifier']")));
        //Maximize
        driver.manage().window().maximize();
        //Login
        driver.findElement(By.xpath("//input[@name='identifier']")).sendKeys("kiranmiriyala244");
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Next']")));
        driver.findElement(By.xpath("//span[text()='Next']")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));       
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("mydrlngnag");
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Next']")));       
        driver.findElement(By.xpath("//span[text()='Next']")).click();        
        //Select Creteria
        @SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
        System.out.println("Enter like All");
        @SuppressWarnings("unused")
		String a=sc.nextLine();
        System.out.println("Are you sure like Yes or No");
        String b=sc.nextLine();
        String c="yes";
        if(b.equalsIgnoreCase(c))
        {
        	driver.findElement(By.xpath("(//div[@class='aKz'])[1]")).click();  
        	Screen s=new Screen();
    		if(s.exists("count")!= null)
        	{		
    		WebElement d=driver.findElement(By.xpath("(//span[@class='Dj']/span)[2]"));    
    		JavascriptExecutor js=(JavascriptExecutor)driver;
        	js.executeScript("var e=arguments[0].textContent;window.alert(e);",d);
        	String e=driver.switchTo().alert().getText();        	
        	driver.switchTo().alert().accept();
        	int f=Integer.parseInt(e);
        	if(f!=0)
        	{
        		for(int i=1;i<=f;)
            	{
        			driver.findElement(By.xpath("(//table)[6]/tbody/tr["+i+"]/td[2]")).click();	
        			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='Dj']/span)[2]")));
        			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()='Loading...']")));
            		driver.findElement(By.xpath("//div[@gh='mtb']/div/div/child::div[2]/div[3]")).click();
        	    }
        	}
    	}         	
            driver.findElement(By.xpath("(//div[@class='aKz'])[2]")).click(); 
            if(s.exists("count")!= null)
        	{		
    		WebElement d=driver.findElement(By.xpath("(//span[@class='Dj']/span)[2]"));    
    		JavascriptExecutor js=(JavascriptExecutor)driver;
        	js.executeScript("var e=arguments[0].textContent;window.alert(e);",d);
        	String e=driver.switchTo().alert().getText();        	
        	driver.switchTo().alert().accept();
        	int f=Integer.parseInt(e);
        	if(f!=0)
        	{
        		for(int i=1;i<=f;)
            	{
        			driver.findElement(By.xpath("(//table)[7]/tbody/tr["+i+"]/td[2]")).click();	
        			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='Dj']/span)[2]")));
        			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()='Loading...']")));
            		driver.findElement(By.xpath("//div[@gh='mtb']/div/div/child::div[2]/div[3]")).click();
        	    }
        	}
    	} 
        	driver.findElement(By.xpath("(//div[@class='aKz'])[3]")).click(); 
        	if(s.exists("count")!= null)
        	{		
    		WebElement d=driver.findElement(By.xpath("(//span[@class='Dj']/span)[2]"));    
    		JavascriptExecutor js=(JavascriptExecutor)driver;
        	js.executeScript("var e=arguments[0].textContent;window.alert(e);",d);
        	String e=driver.switchTo().alert().getText();        	
        	driver.switchTo().alert().accept();
        	int f=Integer.parseInt(e);
        	if(f!=0)
        	{
        		for(int i=1;i<=f;)
            	{
        			driver.findElement(By.xpath("(//table)[7]/tbody/tr["+i+"]/td[2]")).click();	
        			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='Dj']/span)[2]")));
        			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()='Loading...']")));
            		driver.findElement(By.xpath("//div[@gh='mtb']/div/div/child::div[2]/div[3]")).click();
        	    }
        	}
    	} 
        	driver.findElement(By.xpath("(//div[@class='aKz'])[4]")).click(); 
        	if(s.exists("count")!= null)
        	{		
    		WebElement d=driver.findElement(By.xpath("(//span[@class='Dj']/span)[2]"));    
    		JavascriptExecutor js=(JavascriptExecutor)driver;
        	js.executeScript("var e=arguments[0].textContent;window.alert(e);",d);
        	String e=driver.switchTo().alert().getText();        	
        	driver.switchTo().alert().accept();
        	int f=Integer.parseInt(e);
        	if(f!=0)
        	{
        		for(int i=1;i<=f;)
            	{
        			driver.findElement(By.xpath("(//table)[7]/tbody/tr["+i+"]/td[2]")).click();	
        			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='Dj']/span)[2]")));
        			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()='Loading...']")));
            		driver.findElement(By.xpath("//div[@gh='mtb']/div/div/child::div[2]/div[3]")).click();
        	    }
        	}
    	} 
        	driver.findElement(By.xpath("(//div[@class='aKz'])[5]")).click(); 
        	if(s.exists("count")!= null)
        	{		
    		WebElement d=driver.findElement(By.xpath("(//span[@class='Dj']/span)[2]"));    
    		JavascriptExecutor js=(JavascriptExecutor)driver;
        	js.executeScript("var e=arguments[0].textContent;window.alert(e);",d);
        	String e=driver.switchTo().alert().getText();        	
        	driver.switchTo().alert().accept();
        	int f=Integer.parseInt(e);
        	if(f!=0)
        	{
        		for(int i=1;i<=f;)
            	{
        			driver.findElement(By.xpath("(//table)[7]/tbody/tr["+i+"]/td[2]")).click();	
        			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='Dj']/span)[2]")));
        			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()='Loading...']")));
            		driver.findElement(By.xpath("//div[@gh='mtb']/div/div/child::div[2]/div[3]")).click();
        	    }
        	}
    	} 
        }        
        //close
        //driver.close();
	}
	}
    
