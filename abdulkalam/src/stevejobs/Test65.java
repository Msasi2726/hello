package stevejobs;
import java.awt.Robot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.sun.glass.events.KeyEvent;
public class Test65
{
	public static void main(String[] args) throws Exception
	{
		//Launch site(SWD)
		System.setProperty("webdriver.chrome.driver",
				"E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.seleniumhq.org");
		WebDriverWait w=new WebDriverWait(driver,10);
		w.until(ExpectedConditions.visibilityOfElementLocated(
						              By.linkText("Download")));
		driver.manage().window().maximize();
		//Right click on link(SWD)
		WebElement e=driver.findElement(By.linkText("Download"));
		Actions a=new Actions(driver);
		a.contextClick(e).build().perform();
		Thread.sleep(5000);
		//Automate win-menu(java robot(in JDK))
		Robot r=new Robot();
		for(int i=1;i<=2;i++)
		{
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(5000);
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
}



