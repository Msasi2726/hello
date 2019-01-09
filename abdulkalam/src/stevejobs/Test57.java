package stevejobs;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test57
{
	public static void main(String[] args)
	{
		ChromeOptions o=new ChromeOptions();
		o.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver",
				    "E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver(o);
		driver.get("http://www.bookmyshow.com");

	}

}





