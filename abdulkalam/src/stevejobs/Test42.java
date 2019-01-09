package stevejobs;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class Test42
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
		//Open drop-down(developed using <div> tag)
		WebElement e=driver.findElement(By.xpath(
		 "(//*[contains(@class,'ui selection dropdown')])[1]"));
		Actions a=new Actions(driver);
		a.click(e).build().perform();
		Thread.sleep(5000);
		//Get items and display
		List<WebElement> il=driver.findElements(By.xpath(
		  "(//*[contains(@class,'ui selection dropdown')])[1]/child::*[4]/div"));
		System.out.println("No: of items is "+il.size());
		for(int i=0;i<il.size();i++)
		{
			System.out.println(il.get(i).getText());
		}
		//Select 2nd item
		a.click(il.get(1)).build().perform();
		Thread.sleep(5000);
		//Close site
		driver.close();	
	}
}




