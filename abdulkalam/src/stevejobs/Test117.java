package stevejobs;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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

public class Test117
{
	public static void main(String[] args)
	{
		//Get test data
		HashMap<String,String> pwds=
				new HashMap<String,String>();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter test data size");
		int noi=Integer.parseInt(sc.nextLine());
		for(int i=0;i<noi;i++)
		{
			System.out.println("Enter pwd");
			String x=sc.nextLine();
			System.out.println("Enter pwd criteria");
			String y=sc.nextLine();
			pwds.put(x,y);
		}
		//Create html reports file
		ExtentReports er=new ExtentReports("gmailddt.html",
				                                      false);
		ExtentTest et=er.startTest("Gmail pwd testing");
		//Data driven testing
		ChromeDriver driver=null;
		for(Map.Entry<String,String> e:pwds.entrySet())
		{
			try
			{
				//Launch site
				System.setProperty("webdriver.chrome.driver",
			           "E:\\batch241\\chromedriver.exe");
				driver=new ChromeDriver();
				driver.get("http://www.gmail.com");
				WebDriverWait w=new WebDriverWait(driver,20);
				w.until(ExpectedConditions
						.visibilityOfElementLocated(
						             By.name("identifier")));
				driver.manage().window().maximize();
				//Enter valid userid and click next
				driver.findElement(By.name("identifier"))
											.sendKeys("gvraman167");
				w.until(ExpectedConditions.elementToBeClickable(
						              By.xpath("//*[text()='Next']")));
				driver.findElement(By.xpath("//*[text()='Next']"))
				                                             .click();
				w.until(ExpectedConditions.visibilityOfElementLocated(
						                        By.name("password")));
				//Enter password and click
				driver.findElement(By.name("password"))
				                           .sendKeys(e.getKey());
				w.until(ExpectedConditions.elementToBeClickable(
						           By.xpath("//*[text()='Next']")));
				driver.findElement(By.xpath("//*[text()='Next']"))
                                                            .click();
				Thread.sleep(5000);//not able to use specific condition
				//Validations
				if(e.getKey().length()==0 && driver.findElement(
				   By.xpath("//*[text()='Enter a password']"))
						                           .isDisplayed())
				{
					et.log(LogStatus.PASS,"Blank PWD test passed");
				}
				else if(e.getValue().equalsIgnoreCase("invalid") && 
						driver.findElement(By.xpath(
					    "//*[contains(text(),'Wrong password')]"))
						                              .isDisplayed())
				{
					et.log(LogStatus.PASS,"Inalid PWD test passed");
				}
				else if(e.getValue().equalsIgnoreCase("valid") && 
				 driver.findElement(By.xpath("//*[text()='Compose']"))
				                                      .isDisplayed())
				{
					et.log(LogStatus.PASS,"Valid PWD test passed");
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
					et.log(LogStatus.FAIL,"PWD test failed"+
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



