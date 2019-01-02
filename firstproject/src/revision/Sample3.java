package revision;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sample3 
{
	//Data Member
	ChromeDriver driver;
	//Consturactor method
    Sample3()
	{
	System.setProperty("webdriver.chrome.driver","H:\\Selenium\\chromedriver.exe");
	driver=new ChromeDriver();
	}
	public void lunch(String url)
	{
		driver.get(url);
	}
	public void close()
	{
		driver.close();
	}
	public void max()
	{
		driver.manage().window().maximize();
	}
	public void waiting(String temp)
	{
		WebDriverWait wait=new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(temp)));
	}
	public void find(String temp1, String temp2)
	{
		driver.findElement(By.xpath(temp1)).sendKeys(temp2);
	}
	public void click(String temp1)
	{
		driver.findElement(By.xpath(temp1)).click();
	}		
}
