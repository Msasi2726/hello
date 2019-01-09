package stevejobs;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test29
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		System.setProperty("webdriver.chrome.driver",
	             "E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Delete all existing cookies
		driver.manage().deleteAllCookies();
		//Launch site
		driver.get("http://www.way2sms.com");         
		Thread.sleep(5000);
		//Cookies testing
		if(driver.manage().getCookies().size()!=0)
		{
			System.out.println("Cookies Test passed");
		}
		else
		{
			System.out.println("Cookies Test failed");
		}
		//Close site
		driver.close();
		
		
		
		
	}
}




