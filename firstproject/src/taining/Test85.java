package taining;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test85 
{
	public static void main(String[] args) throws Exception 
	{
		//Get data From Keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter userid");
		String u=sc.nextLine();
		System.out.println("Enter criteria");
		String uc=sc.nextLine();
		String p="";
		String pc="";
		if(uc.equals("valid"))
		{
			System.out.println("Enter password");
			p=sc.nextLine();
			System.out.println("Enter password Criteria");
			pc=sc.nextLine();
		}
		//Create html results file
		ExtentReports er=new ExtentReports("H:\\Selenium\\firstproject\\html\\gmailresult.html",false);
		ExtentTest et=er.startTest("Gmail login testing");
		//Login
		System.setProperty("webdriver.chrome.driver","H:\\Selenium\\chromedriver.exe");
        ChromeDriver driver=new ChromeDriver();
        driver.get("http://www.gmail.com");
        WebDriverWait w=new WebDriverWait(driver,100);
        Thread.sleep(5000);
        //Login
        driver.findElement(By.xpath("//input[@name='identifier']")).sendKeys(u);       
        driver.findElement(By.xpath("//span[text()='Next']")).click();
        Thread.sleep(5000);
        //validation
        try
        {
        	//userid Testing
        	if(u.length()==0 && driver.findElement(By.xpath("//*[contains(text(),'Enter an email')]")).isDisplayed())
        	{
        	    et.log(LogStatus.PASS,"Blank Uid Test passed");	
        	}       
        	else if(uc.equals("invalid") && driver.findElement(By.xpath("(//div[@aria-live='assertive'])[1]")).isDisplayed())
			{
				et.log(LogStatus.PASS,"Invalid Uid Test passed");
			}
        	else if(uc.equals("valid") && driver.findElement(By.name("password")).isDisplayed())
			{
				et.log(LogStatus.PASS,"valid Uid Test passed");
			{
        	//Password Testing
        	driver.findElement(By.xpath("//input[@name='password']")).sendKeys(p);
        	w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Next']")));
            driver.findElement(By.xpath("//span[text()='Next']")).click();
            Thread.sleep(5000);
        	if(p.length()==0 && driver.findElement(By.xpath("//*[text()='Enter a password']")).isDisplayed())
        	{
        		et.log(LogStatus.PASS,"Blank Pwd Test passed");
        	}
        	else if(pc.equals("invalid") && driver.findElement(By.xpath("//*[contains(text(),'Wrong password')]")).isDisplayed())
			{
				et.log(LogStatus.PASS,"Invalid Pwd Test passed");
			}
        	else if(pc.equals("valid") && driver.findElement(By.xpath("//*[text()='Compose']")).isDisplayed())
			{
				et.log(LogStatus.PASS,"valid Pwd Test passed");
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
    			et.log(LogStatus.FAIL,"Pwd login Test Failed"+et.addScreenCapture(ssname+".png"));
        	}
        }
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
			et.log(LogStatus.FAIL,"Uid Test Failed"+et.addScreenCapture(ssname+".png"));
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
			et.log(LogStatus.ERROR,"Gmail login Test interupted"+et.addScreenCapture(ssname+".png"));
        }
        	//close site
        	driver.close();
        	//Save and close Results
        	er.endTest(et);
        	er.flush();
        }
}
