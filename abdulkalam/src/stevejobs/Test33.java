package stevejobs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class Test33
{
	public static void main(String[] args) throws Exception
	{
		//Launch website
		System.setProperty("webdriver.chrome.driver",
		           "E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.mercurytravels.co.in/");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		WebElement e=driver.findElement(By.name("nights"));
		Select s=new Select(e);
		//s.selectByIndex(5);
		//s.selectByVisibleText("6Nights+7Days");
		s.selectByValue("39Nights / 40Days");
	}
}




