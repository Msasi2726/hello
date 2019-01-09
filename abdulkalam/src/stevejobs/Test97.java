package stevejobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test97
{
	public static void main(String[] args) throws Exception 
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
		//Get count of unread mails via pagination
		int enourm=0;
		do
		{
			//Get count of mails in current page
			WebElement mbt=driver.findElement(By.xpath(
					                    "(//table)[4]/tbody"));
			List<WebElement> mails=mbt.findElements(
					                         By.tagName("tr"));
			int nomp=mails.size();
			for(int i=1;i<=nomp;i++)
			{
				WebElement e=driver.findElement(By.xpath(
				 "(//table)[4]/tbody/tr["+i+"]/td[5]/div[1]"));
				driver.executeScript(
		 "var v=arguments[0].textContent; window.alert(v);",e);
				String x=driver.switchTo().alert().getText();
				driver.switchTo().alert().dismiss();
				if(x.contains("unread,"))
				{
					enourm=enourm+1;
				}
				Thread.sleep(2000);
			}
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
		System.out.println(enourm);
		//Get actual count of unread mails
		String a=driver.findElement(By.xpath(
				"//*[contains(@data-tooltip,'Inbox')]"))
				                .getAttribute("data-tooltip");
		String b=a.substring(7,a.length()-1);
		int anourm=Integer.parseInt(b);
		System.out.println(anourm);
		//Validation
		if(enourm==anourm)
		{
		  System.out.println("Unread mails count test passed");
		}
		else
		{
		  System.out.println("Unread mails count test failed");
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









