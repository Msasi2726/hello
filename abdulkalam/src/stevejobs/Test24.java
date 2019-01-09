package stevejobs;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test24
{
	public static void main(String[] args) throws Exception
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
				"E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		//Get screenshot
		File src=driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("myscreen.png");
		FileUtils.copyFile(src,dest);
		//close site
		driver.close();
		
		
		

	}

}




