package stevejobs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class Test30
{
	public static void main(String[] args) throws Exception
	{
		//Launch website
		System.setProperty("webdriver.chrome.driver",
		           "E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		Thread.sleep(5000);
		driver.switchTo().frame("iframeResult");
		WebElement e=driver.findElement(By.name("cars"));
		Select s=new Select(e);
		if(s.isMultiple())
		{
			System.out.println("Multiselect");
		}
		else
		{
			System.out.println("Single select");
		}
		//Close site
		driver.switchTo().defaultContent();
		driver.close();
	}
}




