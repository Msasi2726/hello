package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test62
{
	public static void main(String[] args)
	{
		//Launch website
		System.setProperty("webdriver.chrome.driver",
						     "E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.facebook.com");
		WebDriverWait w=new WebDriverWait(driver,10);
		w.until(temp->driver.executeScript("return document.readyState;").equals("complete"));
		driver.manage().window().maximize();
		//Do login
		driver.findElement(By.cssSelector("input#email")).sendKeys("mindq");

	}

}


