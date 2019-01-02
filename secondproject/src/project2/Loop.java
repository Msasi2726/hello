package project2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;

public class Loop
{
	WebDriver driver = null;
	WebDriverWait w=null;
	public void click()
	{
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
        		driver.findElement(By.xpath("//div[@gh='mtb']/div/div/child::div[2]/div[3]")).click();
    	    }
    	}
	}
}
}
