package stevejobs;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
public class Test5
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver",
				"E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		driver.get("http://www.google.co.in");
		driver.findElement(By.name("q")).sendKeys("abdul kalam");
		driver.close();
		
		

	}

}





