package stevejobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test23
{
	public static void main(String[] args) throws Exception
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
				"E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		//Do login
		driver.findElement(By.name("identifier"))
		                     .sendKeys("gopirowthu9");
		driver.findElement(By.xpath("//*[text()='Next']"))
		                                      .click();
		Thread.sleep(5000);
		driver.findElement(By.name("password"))
        						.sendKeys("9908028816");
		driver.findElement(By.xpath("//*[text()='Next']"))
        									.click();
		Thread.sleep(5000);
		//Get count of mails in mail-box table
		List<WebElement> rl=driver.findElements(
				            By.xpath("(//table)[4]/tbody/tr"));
		int x=rl.size();
		System.out.println(x);
		List<WebElement> cl=rl.get(0).findElements(
				                            By.tagName("td"));
		int y=cl.size();
		System.out.println(y);
		//Do logout
		driver.findElement(By.xpath(
		  "//*[contains(@aria-label,'Google Account:')]/span"))
		                                              .click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Sign out")).click();
		//Close site
		driver.close();
	}
}





