package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test15
{
	public static void main(String[] args) throws Exception
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
				"E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		driver.findElement(By.name("identifier")).sendKeys("batch241sleeping");
		Thread.sleep(5000);
		driver.findElement(By.name("identifier")).clear();

	}

}
