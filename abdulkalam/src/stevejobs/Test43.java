package stevejobs;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class Test43
{
	public static void main(String[] args) throws Exception
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver", 
					"E:\\batch237\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get(
			"https://semantic-ui.com/modules/dropdown.html");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		Actions a=new Actions(driver);
		
		
	}

}











