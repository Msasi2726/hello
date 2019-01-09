package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test17 
{
	public static void main(String[] args) throws Exception
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
				"E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/checkboxradio");
		Thread.sleep(5000);
		//Switch to frame
		driver.switchTo().frame(0); 
		//Operate elements
		driver.findElement(By.xpath(
		   "(//*[@class='ui-checkboxradio-icon-space'])[2]/preceding-sibling::*")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(
			"(//*[@class='ui-checkboxradio-icon-space'])[7]/preceding-sibling::*")).click();
		//Back to page
		driver.switchTo().defaultContent();
		//close site
		driver.close();
	}

}
