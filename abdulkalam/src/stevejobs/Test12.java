package stevejobs;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test12
{
	public static void main(String[] args) throws InterruptedException
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
				"E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		String x=driver.getCurrentUrl();
		if(x.contains("https"))
		{
			System.out.println("Site is secured");
		}
		else
		{
			System.out.println("Site is not secured");
		}
		driver.close();	
	}
}




