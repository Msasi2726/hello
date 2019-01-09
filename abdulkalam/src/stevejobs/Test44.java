package stevejobs;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test44
{
	public static void main(String[] args) throws Exception
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver", 
				"E:\\batch237\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.google.co.in");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Fill textbox via javascript
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementById('lst-ib').value='kalam';");
		

	}
}





