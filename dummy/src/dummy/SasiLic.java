package dummy;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SasiLic
{
	public static void main(String[] args) 
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver","E:\\job\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.licindia.in/Home-(1)/LICOnlineServicePortal");
		WebDriverWait wait=new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Registered User']")));
		//maximize
		driver.manage().window().maximize();
		//Click and Login
		driver.findElement(By.xpath("//input[@value='Registered User']")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[text()='Sign In']")));
		//Fill details
		driver.findElement(By.name("userId")).sendKeys("sasiravimiriyala225@gmail.com");
		driver.findElement(By.name("password")).sendKeys("S@siravi225");
		driver.findElement(By.name("dob")).sendKeys("25/06/1992");
		driver.findElement(By.xpath("//span[text()='Sign In']")).click();

	}
}
