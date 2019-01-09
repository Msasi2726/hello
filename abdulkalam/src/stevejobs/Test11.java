package stevejobs;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test11
{
	public static void main(String[] args) throws InterruptedException
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
				"E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.way2sms.com/");
		Thread.sleep(5000);
		String x=driver.getPageSource();
		System.out.println(x);
		driver.close();	
	}
}
