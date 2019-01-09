package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test51 
{
	public static void main(String[] args) 
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
			       "E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx"); 
		//Wait for page ready
		WebDriverWait w=new WebDriverWait(driver,10); //seconds
		w.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@class='rcMainTable']/tbody")));
		//Maximize browser and click on date
		driver.manage().window().maximize();
		driver.findElement(By.linkText("6")).click();
		//Wait for load completion
		w.until(ExpectedConditions.invisibilityOfElementLocated(
				                        By.className("raDiv")));
		//Close site
		driver.close();
	}
}


