package dummy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","E:\\job\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		//search
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("watches");
		driver.findElement(By.xpath("//input[@value='Go']")).click();
	}
}
