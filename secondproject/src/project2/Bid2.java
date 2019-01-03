 package project2;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bid2
{
	public static void main(String[] args) throws Exception 
	{			
		System.setProperty("webdriver.chrome.driver","H:\\Selenium\\chromedriver.exe");
        ChromeDriver driver=new ChromeDriver();		
        driver.manage().deleteAllCookies();       
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Launch site   
        driver.get("https://www.bidwarriors.com/warriors-treat.php?auid=BE1806");
        //Maximize
        driver.manage().window().maximize();
        // click on Login
        driver.findElement(By.xpath("//a[text()='Login'][1]")).click();
        //login
        driver.findElement(By.name("mobileNumber")).sendKeys("8919125458");
        driver.findElement(By.name("password")).sendKeys("Ms@si27265");
        driver.findElement(By.xpath("//button[@id='login-btn']")).click();
        //Select Auctions   
        driver.findElement(By.xpath("//h5[text()='Auction ID - 38053F']")).click(); 
        int i=1;        
        	for(i=1;i<10;i++)
        		{        	      
        	     String x=driver.findElement(By.xpath("//span[@id='new-max-bid-price']")).getText();
        	     System.out.println(x);
        	     driver.findElement(By.xpath("//input[@id='new-bid-amount']")).sendKeys(x); 
        	     Thread.sleep(1000);        	    
        	     WebElement b=driver.findElement(By.xpath("//button[@id='bid']"));  
        	     driver.executeScript("arguments[0].click();",b);
        	     try
        	     {
        	    	 if(driver.findElement(By.xpath("//span[text()='Msasi2726']")).isDisplayed())
        	    	 {
        	    		 
        	    	 }
        	    	 else
        	    	 {
        	    		 String y=driver.findElement(By.xpath("//span[@id='new-max-bid-price']")).getText();
                	     System.out.println(y);
                	     driver.findElement(By.xpath("//input[@id='new-bid-amount']")).sendKeys(x); 
                	     Thread.sleep(1000);        	    
                	     WebElement c=driver.findElement(By.xpath("//button[@id='bid']"));  
                	     driver.executeScript("arguments[0].click();",c);
        	    	 }
        	     }
        	     catch(Exception e)
        	     {
        	    	 if(driver.findElement(By.xpath("//span[text()='Msasi2726']")).isDisplayed())
        	    	 {
        	    		 
        	    	 }
        	    	 else
        	    	 {
        	    		 String z=driver.findElement(By.xpath("//span[@id='new-max-bid-price']")).getText();
                	     System.out.println(z);
                	     driver.findElement(By.xpath("//input[@id='new-bid-amount']")).sendKeys(x); 
                	     Thread.sleep(1000);        	    
                	     WebElement d=driver.findElement(By.xpath("//button[@id='bid']"));  
                	     driver.executeScript("arguments[0].click();",d);
        	    	 }
        	     }
          	     }           
        //Close
        Thread.sleep(5000);
        driver.close();
	}
}
