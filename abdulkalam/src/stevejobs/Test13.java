package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test13 
{
	public static void main(String[] args) throws Exception 
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
				"E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		try
		{
			if(driver.findElement(By.xpath(
					"//*[@type='password']")).isDisplayed())
			{
			  System.out.println("Password displayed in page");
			}
			else
			{
		 System.out.println("Password not displayed in page");
			}
		}
		catch(Exception ex)
		{
			System.out.println("Wrong locator");
		}
		
		
		
		//close site
		driver.close();
	}
}






