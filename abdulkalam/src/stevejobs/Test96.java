package stevejobs;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Test96
{
	public static void main(String[] args) 
			                throws Exception
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
					  "E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.gmail.com");
		driver.manage().window().maximize();
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(
						                By.name("identifier")));
		//Do login with valid data
		driver.findElement(By.name("identifier"))
				                        .sendKeys("gvraman167");
		w.until(ExpectedConditions.visibilityOfElementLocated(
						       By.xpath("//*[text()='Next']")));
		driver.findElement(By.xpath("//*[text()='Next']"))
		                                               .click();
		w.until(ExpectedConditions.visibilityOfElementLocated(
			                              By.name("password")));
		driver.findElement(By.name("password"))
		                               .sendKeys("rams9666");
		w.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(
						      "//*[text()='Next']")));
		driver.findElement(By.xpath(
				       "//*[text()='Next']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(
				                     By.xpath("(//table)[4]")));
		//close notifications dialog
		driver.findElement(By.xpath("//*[@class='bBe']"))
                                                 .click();
		//Get expected count of mails in page
		int enoam=0;
		do
		{
			//Get count of mails in current page
			WebElement mbt=driver.findElement(By.xpath(
					                          "(//table)[4]"));
			List<WebElement> mails=mbt.findElements(
					                         By.tagName("tr"));
			int nomp=mails.size();
			//Add count of mails in current page to total count
			enoam=enoam+nomp;
			//Go to next page
			try
			{
				if(driver.findElement(By.xpath(
					"//*[@data-tooltip='Older']"))
				  .getAttribute("aria-disabled").equals("true"))  
				{
					break; //terminate from loop
				}
			}
			catch(Exception ex)
			{
				driver.findElement(By.xpath(
						"//*[@data-tooltip='Older']")).click();
				Thread.sleep(10000); //to load next mail box
			}
		}while(2>1); //infinite loop
		//Get actual count from page
		String temp=driver.findElement(By.xpath(
			 "//*[@data-tooltip='Newer']/preceding::span[1]"))
				                                   .getText();
		int anoam=Integer.parseInt(temp);
		//Validation
		System.out.println(enoam+" "+anoam);
		if(enoam==anoam)
		{
		   System.out.println("Gmail mails count test passed");
		}
		else
		{
		   System.out.println("Gmail mails count test failed");
		}
		//Do Logout
		driver.findElement(By.xpath(
		  "//*[contains(@aria-label,'Google Account')]/span"))
				                                     .click();
		w.until(ExpectedConditions.visibilityOfElementLocated(
				                    By.linkText("Sign out")));
		driver.findElement(By.linkText("Sign out")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(
				                        By.name("password")));
		//Close site
		driver.close();
	}
}



