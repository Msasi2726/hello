package stevejobs;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test18
{
	public static void main(String[] args) throws Exception
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
				"E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.sentia.in");
		Thread.sleep(5000);
		driver.findElement(By.xpath(
			"//*[contains(@src,'pay_online.jpg')]")).click();
		Thread.sleep(5000);
		//click on buttons to get new browser window tabs
		driver.findElement(By.xpath(
			"(//*[contains(@href,'transportfeesentia1')])[1]"))
		                                              .click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(
			"(//*[contains(@href,'paymentOptionsGroup')])[3]"))
		                                               .click();
		Thread.sleep(5000);
		//get browser windows/tabs handles
		ArrayList<String> a=new ArrayList<String>(
				                    driver.getWindowHandles());
		for(int i=0;i<a.size();i++)
		{
			System.out.println(a.get(i));
		}
		//Switch to 2nd window/tab and close
		driver.switchTo().window(a.get(1));
		driver.close();
		Thread.sleep(5000);
		//Switch to 1st window/tab and close
		driver.switchTo().window(a.get(0));
		driver.close();
		Thread.sleep(5000);
		//Switch to 3rd window and close
		driver.switchTo().window(a.get(2));
		driver.close();
	}
}






