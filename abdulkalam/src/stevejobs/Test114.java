package stevejobs;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test114
{
	public static void main(String[] args) 
			                        throws Exception
	{
		//Get test data
		ArrayList<String> uids=new ArrayList<String>();
		ArrayList<String> cs=new ArrayList<String>();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter test data size");
		int noi=Integer.parseInt(sc.nextLine());
		for(int i=0;i<noi;i++)
		{
			System.out.println("Enter uid");
			uids.add(sc.nextLine());
			System.out.println("Enter uid criteria");
			cs.add(sc.nextLine());
		}
		//Create html reports file
		ExtentReports er=new ExtentReports("gmailddt.html",
				                                       false);
		ExtentTest et=er.startTest("Gmail uid testing");
		//Data driven testing
		ChromeDriver driver=null;
		for(int i=0;i<noi;i++)
		{
			try
			{
				//Launch site
				System.setProperty("webdriver.chrome.driver",
			           "E:\\batch241\\chromedriver.exe");
				driver=new ChromeDriver();
				driver.get("http://www.gmail.com");
				WebDriverWait w=new WebDriverWait(driver,20);
				w.until(ExpectedConditions.visibilityOfElementLocated(
						                       By.name("identifier")));
				driver.manage().window().maximize();
				//Enter userid and click next
				driver.findElement(By.name("identifier"))
												.sendKeys(uids.get(i));
				w.until(ExpectedConditions.elementToBeClickable(
						              By.xpath("//*[text()='Next']")));
				driver.findElement(By.xpath("//*[text()='Next']"))
				                                             .click();
				Thread.sleep(5000);
				//Validations
				if(uids.get(i).length()==0 && driver.findElement(
				   By.xpath("//*[contains(text(),'Enter an email')]"))
						                           .isDisplayed())
				{
					et.log(LogStatus.PASS,"Blank UID test passed");
				}
				else if(cs.get(i).equalsIgnoreCase("valid") && 
				 driver.findElement(By.name("password")).isDisplayed())
				{
					et.log(LogStatus.PASS,"Valid UID test passed");
				}
				else if(cs.get(i).equalsIgnoreCase("invalid") && 
					driver.findElement(By.xpath(
				    "(//*[contains(text(),'find your Google')])[2]"))
					                                  .isDisplayed())
				{
					et.log(LogStatus.PASS,"Inalid UID test passed");
				}
				else
				{
					SimpleDateFormat sf=new SimpleDateFormat(
							                  "dd-MM-yy-hh-mm-ss");
					Date d=new Date();
					String fname=sf.format(d)+".png";
			  File src=driver.getScreenshotAs(OutputType.FILE);
					File dest=new File(fname);
					FileHandler.copy(src,dest);
					et.log(LogStatus.FAIL,"UID test failed"+
					               et.addScreenCapture(fname));				
				}
				//close site
				driver.close();
			}
			catch(Exception ex)
			{
				driver.close();
			   et.log(LogStatus.ERROR,ex.getMessage());
			}
		}
		//Save results
		er.endTest(et);
		er.flush();
	}
}




