package stevejobs;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
public class Test52
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver",
			       "E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx"); 
		FluentWait w=new FluentWait(driver)
				.pollingEvery(2,TimeUnit.SECONDS)
				.withTimeout(10,TimeUnit.SECONDS);
		w.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@class='rcMainTable']/tbody")));
		driver.manage().window().maximize();
		driver.findElement(By.linkText("6")).click();
		w.until(ExpectedConditions.invisibilityOfElementLocated(
										By.className("raDiv")));
		driver.close();
	}
}
