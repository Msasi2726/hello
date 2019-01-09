package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test6
{
	public static void main(String[] args) throws InterruptedException
	{
		//launch site using chrome browser
		System.setProperty("webdriver.chrome.driver",
				"E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		Thread.sleep(5000);
		driver.get("http://newtours.demoaut.com");
		Thread.sleep(5000);
		//Do login
		driver.findElement(By.name("userName")).sendKeys("admin");
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys("depika padukone");
		Thread.sleep(5000);
		driver.findElement(By.name("login")).click();
		Thread.sleep(5000);
		driver.close();
	}
}
