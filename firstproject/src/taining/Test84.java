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

public class Test84 
{
	public static void main(String[] args) throws Exception 
	{
		//Take a word from Keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter mobile number");
		String mno=sc.nextLine();
		System.out.println("Enter Criteria");
		String mnoc=sc.nextLine();
		System.out.println("Enter Password");
		String p=sc.nextLine();
		System.out.println("Enter Criteria");
		String pc=sc.nextLine();
		//Launch site
		System.setProperty("webdriver.chrome.driver","H:\\Selenium\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.way2sms.com");
		WebDriverWait wait=new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mobileNo")));
		//maximize
		driver.manage().window().maximize();
		//Login
		driver.findElement(By.name("mobileNo")).sendKeys(mno);
		driver.findElement(By.name("password")).sendKeys(p);
		driver.findElement(By.xpath("(//*[contains(text(),'Login')]) [2]")).click();
		//validation
		ExtentReports er=new ExtentReports("H:\\Selenium\\firstproject\\html\\Way2smsres.html", false);
		ExtentTest et=er.startTest("Way2sms login Testing");
		try
		{
			if(mno.length()==0 && driver.findElement(By.xpath("//*[text()='Enter your mobile number']")).isDisplayed())
			{
				et.log(LogStatus.PASS,"Blank space mobile number test Passed");
			}
			else if(mno.length()<10 && driver.findElement(By.xpath("//*[text()='Enter valid mobile number']")).isDisplayed())
			{
				et.log(LogStatus.PASS,"Wrong size mobile number test Passed");
			}
			else if(mnoc.equals("invalid") && driver.findElement(By.xpath("(//*[contains(text(),'not register')])[1]")).isDisplayed())
			{
				et.log(LogStatus.PASS,"Invalid mobile number test Passed");
			}
			else if(p.length()==0 && driver.findElement(By.xpath("//*[text()='Enter password']")).isDisplayed())
			{
				et.log(LogStatus.PASS,"Blank pwd test Passed");
			}
			else if(pc.equals("invalid") && driver.findElement(By.xpath("(//*[contains(text(),'Try Again')])[1]")).isDisplayed())
			{
				et.log(LogStatus.PASS,"Invalid pwd test Passed");
			}
			else if(mnoc.equals("valid") && pc.equals("valid") && driver.findElement(By.xpath("//*[text()='SendSMS']")).isDisplayed())
			{
				et.log(LogStatus.PASS,"Valid mno and pwd test Passed");
			}			
			else
			{
				//Get Screenshot
				SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yy-hh-mm-ss");
				Date d=new Date();
				String ssname=sf.format(d);
				File src=driver.getScreenshotAs(OutputType.FILE);
				File dest=new File(ssname+".png");
				FileUtils.copyFile(src,dest);
				et.log(LogStatus.FAIL,"Way2sms login Test failed"+et.addScreenCapture(ssname+".png"));
			}
		}
		catch(Exception ex)
		{
			//Get Screenshot
			SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yy-hh-mm-ss");
			Date d=new Date();
			String ssname=sf.format(d);
			File src=driver.getScreenshotAs(OutputType.FILE);
			File dest=new File(ssname+".png");
			FileUtils.copyFile(src,dest);
			et.log(LogStatus.ERROR,"Way2sms login Test interupted"+et.addScreenCapture(ssname+".png"));
		}
		//close site
		driver.close();
		//Save and close Results
		er.endTest(et);
		er.flush();
	}
}
