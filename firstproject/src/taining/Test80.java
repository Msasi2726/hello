package taining;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test80 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","H:\\Selenium\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//launch site
		driver.get("http://jqueryui.com/button/");
		WebDriverWait wait=new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Plugins']")));
		//maximize
		driver.manage().window().maximize();
		//Get count of Text boxes & buttons in page Except Frames
		List<WebElement> tl=driver.findElements(By.xpath("//input[@type='text']"));
		System.out.println("No.of text boxes in page are "+ tl.size());
		List<WebElement> bl=driver.findElements(By.xpath("(//button)|(//input[@type='button' or @type='submit'])|(//a[@role='button'])"));
		System.out.println("No.of buttons in page are "+ bl.size());
		//Get all frames in page
		List<WebElement> fl=driver.findElements(By.tagName("iframe"));
		for(int i=0;i<fl.size();i++)
		{
			//change driver focus from page to frame
			driver.switchTo().frame(fl.get(i));
			List<WebElement> tlf=driver.findElements(By.xpath("//input[@type='text']"));
			System.out.println("No.of text boxes in frame"+(i+1)+" are "+ tlf.size());
			List<WebElement> blf=driver.findElements(By.xpath("(//button)|(//input[@type='button' or @type='submit'])|(//a[@role='button'])"));
			System.out.println("No.of buttons in frame"+(i+1)+" are "+ blf.size());
			//back to page
			driver.switchTo().parentFrame();
		}
		driver.switchTo().defaultContent();
		//close site
		driver.close();
	}
}
