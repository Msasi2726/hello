package stevejobs;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test53
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a word");
		String x=sc.nextLine();
		//Launch site
		System.setProperty("webdriver.chrome.driver",
					  "E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://angularjs.org"); 
		//Wait for page ready
		WebDriverWait w=new WebDriverWait(driver,10);
		w.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@ng-model='yourName']")));
		//Maximize browser and fill text-box with data
		driver.manage().window().maximize();
		driver.findElement(By.xpath(
				"//*[@ng-model='yourName']")).sendKeys(x);
		w.until(ExpectedConditions.textToBePresentInElement(
				By.xpath("(//*[contains(text(),'Hello')])[2]"),
				"Hello "+x+"!"));
		driver.close();
	}
}




