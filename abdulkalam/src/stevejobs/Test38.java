package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test38 
{
	public static void main(String[] args) throws Exception
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
                "E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.google.co.in");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Fill text box with data to get cache/auto-complete
		driver.findElement(By.name("q")).sendKeys("steve jobs");
		Thread.sleep(5000);
		//Select 4th item in cache
		Actions a=new Actions(driver);
		for(int i=1;i<=4;i++)
		{
			a.sendKeys(Keys.DOWN).build().perform();
			Thread.sleep(2000);
		}
		a.sendKeys(Keys.ENTER).build().perform();
		//close site
		driver.close();
		
		
		

	}

}




