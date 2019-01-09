package stevejobs;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test28
{
	public static void main(String[] args) throws Exception
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
	             "E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.mercurytravels.co.in");         
		Thread.sleep(5000);
		driver.navigate().to("http://www.google.co.in");
		Thread.sleep(5000);
		driver.navigate().back(); //mercury travels
		Thread.sleep(5000);
		driver.navigate().forward(); //google
		Thread.sleep(5000);
		driver.navigate().refresh(); //google
		Thread.sleep(5000);
		driver.close();

	}

}



