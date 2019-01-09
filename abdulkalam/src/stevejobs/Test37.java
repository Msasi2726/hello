package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test37
{
	public static void main(String[] args) throws Exception
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
                "E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/slider");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Horizontal slider
		driver.switchTo().frame(0);
		WebElement e1=driver.findElement(By.xpath(
				                "//*[@id='slider']/span"));
		Actions a=new Actions(driver);
		a.dragAndDropBy(e1,200,0).build().perform();
		Thread.sleep(5000);
		a.dragAndDropBy(e1,-200,0).build().perform();
		Thread.sleep(5000);
		//Vertical slider
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("Vertical slider"))
		                                             .click();
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		WebElement e2=driver.findElement(
				By.xpath("//*[@id='slider-vertical']/span"));
		a.dragAndDropBy(e2,0,100).build().perform();
		Thread.sleep(5000);
		a.dragAndDropBy(e2,0,-200).build().perform();
		driver.switchTo().defaultContent();
		//Close site
		driver.close();
	}
}





