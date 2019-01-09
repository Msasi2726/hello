package stevejobs;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test48
{
	public static void main(String[] args) throws Exception
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
		          "E:\\batch240\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.google.co.in"); 
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.executeScript("window.alert('hi bros&sis');");

	}

}





