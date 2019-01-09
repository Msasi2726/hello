package stevejobs;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test19
{
	public static void main(String[] args) throws InterruptedException 
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
				"E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.way2sms.com");
		Thread.sleep(5000);
		//Fill Mobile number
		driver.switchTo().activeElement().sendKeys("9700712100");
		

	}

}



