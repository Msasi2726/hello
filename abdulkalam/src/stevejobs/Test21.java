package stevejobs;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Test21
{
	public static void main(String[] args) throws Exception
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
				"E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		//Collect all links in page
		List<WebElement> l=driver.findElements(By.tagName("a"));
		System.out.println(l.size());
		l.get(51).click();
		//close site
		driver.close();
	}
}





