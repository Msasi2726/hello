package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test34
{
	public static void main(String[] args) throws Exception
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
		                   "E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//close login banner
		driver.findElement(By.xpath(
				"//*[@id='container']/following::button[1]"))
		                                            .click();
		Thread.sleep(5000);
		//Move mouse pointer to element
		WebElement e=driver.findElement(By.xpath(
				                     "//*[text()='Women']"));
		Actions a=new Actions(driver);
		a.moveToElement(e).build().perform();
		Thread.sleep(5000);
		//Close site
		driver.close();
	}
}






