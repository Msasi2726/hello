package taining;

import java.util.List;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test82 
{
	public static void main(String[] args) throws Exception 
	{
		//Selenium
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a word");
		String z=sc.nextLine();
		System.setProperty("webdriver.chrome.driver","H:\\Selenium\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//launch site
		driver.get("http://www.gmail.com");
		WebDriverWait wait=new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
		//maximize
		driver.manage().window().maximize();
		//Reports
		ExtentReports er=new ExtentReports("gmailress.html", false);
		ExtentTest et=er.startTest("gmailress");
		//login
		driver.findElement(By.name("identifier")).sendKeys("msasikiran225");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		//Wait for Password
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		driver.findElement(By.name("password")).sendKeys("Ms@si2726");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		//wait for Compose
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Compose']")));
		//pagenation for mailbox
		int norm=0;
		while(2>1)
		{
			List<WebElement> rl=driver.findElements(By.xpath("((//table)[4]/tbody/tr)"));
			int noam=rl.size();
			Thread.sleep(5000);
			for(int i=1;i<noam;i++)
			{
				String x=driver.findElement(By.xpath("((//table)[4]/tbody/tr["+i+"]/td[5])")).getText();
				if(x.equalsIgnoreCase(z))
				{
					norm=norm+1;
				}					
			}
			//Go to next Page
			try
			{
				if(driver.findElement(By.xpath("//*[@aria-label='Older']")).getAttribute("aria-disabled").equals("true"))
				{
					break;
				}
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath("//*[@aria-label='Older']")).click();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//SPAN[contains(@class, \"v1\")]")));
				Thread.sleep(5000);
			}
		}//while loop closing
		et.log(LogStatus.PASS,"Total mails  "+norm);
		//Do logout
		driver.findElement(By.xpath("//*[contains(@aria-label,'Google Account:')]/span")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Sign out")));
		driver.findElement(By.linkText("Sign out")).click();
		//close site
		driver.close();
		er.endTest(et);
		er.flush();
	}
}
