package stevejobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Test32
{
	public static void main(String[] args) throws Exception
	{
		//Launch website
		System.setProperty("webdriver.chrome.driver",
		           "E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		WebElement e=driver.findElement(By.name("cars"));
		Select s=new Select(e);
		//Select more than one item
		Actions a=new Actions(driver);
		a.keyDown(Keys.CONTROL)
		 .click(s.getOptions().get(3))
		 .click(s.getOptions().get(0))
		 .keyUp(Keys.CONTROL).build().perform();
		Thread.sleep(5000);
		//Get selected items
		List<WebElement> l=s.getAllSelectedOptions();
		for(int i=0;i<l.size();i++)
		{
			System.out.println(l.get(i).getText());
		}
		String x=s.getFirstSelectedOption().getText();
		Thread.sleep(5000);
		s.deselectByIndex(0);
		Thread.sleep(5000);
		//s.deselectByVisibleText("Audi");
		s.deselectByValue("audi");
		//close site
		driver.switchTo().defaultContent();
		//driver.close();
	}
}




