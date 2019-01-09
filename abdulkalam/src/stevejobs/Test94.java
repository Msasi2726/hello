package stevejobs;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class Test94
{
	public static void main(String[] args) 
			                         throws Exception
	{
		//Make results file
		ExtentReports er=new ExtentReports(
				                "googleres.html",false);
		ExtentTest et=er.startTest(
				           "Google results title test");
		//Get test data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a word");
		String x=sc.nextLine();
		//Launch site
		System.setProperty("webdriver.chrome.driver",
				     "E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.co.in");
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(
				                               By.name("q")));
		//Enter data to search
		driver.findElement(By.name("q")).sendKeys(x,Keys.ENTER);
		w.until(ExpectedConditions.visibilityOfElementLocated(
				              By.xpath("//*[text()='All']")));
		//Validation
		while(2>1)   //Infinite loop
		{
			String t=driver.getTitle();
			if(!t.contains(x))
			{
				//Get screenshot
				SimpleDateFormat sf=new SimpleDateFormat(
			                            "dd-MM-yy-hh-mm-ss");
				Date d=new Date();
				String fname=sf.format(d)+".png";
			  File src=driver.getScreenshotAs(OutputType.FILE);
				File dest=new File(fname);
				FileHandler.copy(src,dest);
				//Display result as test failed
				et.log(LogStatus.FAIL,"Google title test failed"+
				                        et.addScreenCapture(fname));
				//terminate from loop
				break;
			}
			//Go to next page
			try
			{
				if(driver.findElement(By.xpath(
						  "//*[text()='Next']")).isDisplayed())
				{
					driver.findElement(By.xpath(
							    "//*[text()='Next']")).click();
				}
			}
			catch(Exception ex)
			{
			et.log(LogStatus.PASS,"Google test passed");
				break; //terminate from infinite loop
			}
		}
		//Close site
		driver.close();
		//Save results
		er.endTest(et);
		er.flush();
	}
}




