package stevejobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test39
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
		//Get count items in cache
		List<WebElement> l=driver.findElements(By.xpath("//*[@role='listbox']/li"));
		int cs=l.size()-2;
		//Search for required item in cache
		Actions a=new Actions(driver);
		int flag=0;
		for(int i=1;i<=cs;i++)
		{
			a.sendKeys(Keys.DOWN).build().perform();
			Thread.sleep(5000);
			String x=driver.findElement(By.name("q")).getAttribute("value");
			if(x.equalsIgnoreCase("steve jobs cook"))
			{
				a.sendKeys(Keys.ENTER).build().perform();
				flag=1;
				break;
			}
		}
		if(flag==0)
		{
			System.out.println("No item matched");
		}
		else
		{
			System.out.println("Item found and selected");
		}
		//Close site
		driver.close();
	}
}






