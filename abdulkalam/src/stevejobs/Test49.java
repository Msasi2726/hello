package stevejobs;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Test49
{
	public static void main(String[] args) throws Exception
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
		          "E:\\batch240\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get(
			   "https://semantic-ui.com/modules/dropdown.html"); 
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Get items(invisible) of a drop-down without open
		List<WebElement> il=driver.findElements(By.xpath(
				"(//*[@class='ui dropdown'])[1]/div[2]/div"));
		System.out.println(il.size());
		for(int i=0;i<il.size();i++)
		{
			driver.executeScript(
			"var x=arguments[0].textContent; window.alert(x);",
			                                         il.get(i));
			String y=driver.switchTo().alert().getText();
			System.out.println(y);
			Thread.sleep(5000);
			driver.switchTo().alert().dismiss();
		}
		//close site
		driver.close();
	}
}
