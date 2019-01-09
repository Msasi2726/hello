package stevejobs;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test45
{
	public static void main(String[] args) throws Exception
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver", 
				"E:\\batch237\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.google.co.in");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Highlight an element
		WebElement e=driver.findElement(By.name("q"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='5px blue solid';",e);
		//Get screen shot
		File src=driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("ss.png");
		FileUtils.copyFile(src,dest);
		//Close site
		driver.close();
	}
}



