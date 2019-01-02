package taining;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test83 
{
	public static void main(String[] args) throws Exception
	{
		//Take a word from Keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a word");
		String x=sc.nextLine();
		//Launch site
		System.setProperty("webdriver.chrome.driver","H:\\Selenium\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.google.co.in");
		WebDriverWait wait=new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		//maximize
		driver.manage().window().maximize();
		//Reports
		ExtentReports er=new ExtentReports("H:\\Selenium\\firstproject\\html\\googleres.html", false);
		ExtentTest et=er.startTest("googleres");
		driver.findElement(By.name("q")).sendKeys(x,Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='All']")));
		//Test title
		int flag=0;
		while(2>1)
		{
			String t=driver.getTitle();
			if(!t.contains(x))
			{
				flag=1;
				break;
			}
			else
			{
				try
				{
					//Go to next page
					driver.findElement(By.xpath("//*[text()='Next']")).click();
					Thread.sleep(3000);
				}
				catch(Exception ex)
				{
					break;
				}
			}
		}
		//get Screenshot 
		SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
		Date d=new Date();
		String ssname=sf.format(d);
		File src=driver.getScreenshotAs(OutputType.FILE);
		File dest=new File(ssname+".png");
		FileUtils.copyFile(src,dest);
		if(flag==0)
		{
			et.log(LogStatus.PASS,"Google Test passed"+et.addScreenCapture(ssname+".png"));
		}
		else
		{
			et.log(LogStatus.FAIL,"Google Test Failed"+et.addScreenCapture(ssname+".png"));
		}
		//Close site
		driver.close();
		er.endTest(et);
		er.flush();
	}
}
