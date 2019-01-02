package taining;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test41 
{
	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.gecko.driver", "H:\\Selenium\\geckodriver.exe");
		FirefoxDriver driver=new FirefoxDriver();
		//Launch site
		driver.get("http://www.seleniumhq.org");
		//Explicity wait
		WebDriverWait w=new WebDriverWait(driver, 40);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Download")));
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Download")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='3.13.0']")));
		driver.findElement(By.xpath("//a[text()='3.13.0']")).click();
		//Automate file download pop-up window (javaRobot)
		Thread.sleep(5000);
		Robot r=new Robot();
		for(int i=1;i<=2;i++)
		{
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(30000); //for complete download
		//close
		driver.close();
	}
}
