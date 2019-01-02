package project2;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class Delete 
{
	@SuppressWarnings("null")
	public void clkDelete(String del) throws Exception
	{
		WebDriver driver=null;
		if(del.equals("delete"))
		{			
			driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[7]")).click();
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[37]")).click();
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[11]")).click(); 
     }		
	}	
	@SuppressWarnings("null")
	public void clkDelete1(String del) throws Exception 
	{
		WebDriver driver=null;
		if(del.equals("delete"))
		{		 
		driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[7]")).click();
    	Thread.sleep(4000);            	
    	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[40]")).click();
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//div[@gh='mtb']/div/div/child::div[2]/div[3]")).click();
    	Thread.sleep(4000);
    	driver.findElement(By.xpath("//div[@gh='mtb']/div/div/child::div[4]")).click(); 
		}		
	}	
	@SuppressWarnings("null")
	public void clkDelete2(String del) throws Exception 
	{
		WebDriver driver=null;
		if(del.equals("delete"))
		{	     
		driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[7]")).click();
    	Thread.sleep(4000);            	
    	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[44]")).click();
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//div[@gh='mtb']/div/div/child::div[2]/div[3]")).click();
    	Thread.sleep(4000);
    	driver.findElement(By.xpath("//div[@gh='mtb']/div/div/child::div[4]")).click(); 
		}		
	}
	@SuppressWarnings("null")
	public void clkDelete3(String del) throws Exception 
	{
		WebDriver driver=null;
		if(del.equals("delete"))
		{	     
		driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[7]")).click();
    	Thread.sleep(4000);            	
    	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[46]")).click();
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//div[@gh='mtb']/div/div/child::div[2]/div[3]")).click();
    	Thread.sleep(4000);
    	driver.findElement(By.xpath("//div[@gh='mtb']/div/div/child::div[4]")).click(); 
		}		
	}	
	@SuppressWarnings("null")
	public void clkDelete4(String del) throws Exception 
	{
		WebDriver driver=null;
		if(del.equals("delete"))
		{	     
		driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[7]")).click();
    	Thread.sleep(4000);            	
    	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[48]")).click();
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//div[@gh='mtb']/div/div/child::div[2]/div[3]")).click();
    	Thread.sleep(4000);
    	driver.findElement(By.xpath("//div[@gh='mtb']/div/div/child::div[4]")).click(); 
		}		
	}
	@SuppressWarnings("null")
	public void clkDelete5(String del) throws Exception 
	{
		WebDriver driver=null;
		if(del.equals("delete"))
		{	     
		driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[7]")).click();
    	Thread.sleep(4000);            	
    	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[50]")).click();
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//div[@gh='mtb']/div/div/child::div[2]/div[3]")).click();
    	Thread.sleep(4000);
    	driver.findElement(By.xpath("//div[@gh='mtb']/div/div/child::div[4]")).click(); 
		}		
	}
}
        	