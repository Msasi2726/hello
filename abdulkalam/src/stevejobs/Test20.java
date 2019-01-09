package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test20
{
	public static void main(String[] args) throws InterruptedException 
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
				           "E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get(
			"https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert3");
		Thread.sleep(5000);
		//Switch to frame
		driver.switchTo().frame("iframeResult");
		//click on tryit
		driver.findElement(By.xpath("//*[text()='Try it']"))
		                                              .click();
		Thread.sleep(5000);
		//close alert
		driver.switchTo().alert().dismiss();
		Thread.sleep(5000);
		//close site
		driver.switchTo().defaultContent();
		driver.close();
		

	}

}
