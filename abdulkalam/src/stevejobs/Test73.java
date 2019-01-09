package stevejobs;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class Test73
{
	public static void main(String[] args) throws Exception
	{
		ExtentReports er=new ExtentReports("googleres.html",false);
		ExtentTest et=er.startTest("Google title test");
		//Launch site(SWD)
		System.setProperty("webdriver.chrome.driver",
						   "E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.google.co.in");
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(
			                                By.name("q")));
		driver.manage().window().maximize();
		//Title testing
		String t=driver.getTitle();
		if(t.equals("google"))
		{
			et.log(LogStatus.PASS,"Title test passed");
		}
		else
		{
			//Take current date and time as file name
			Date d=new Date();
			SimpleDateFormat f=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
			String fname=f.format(d)+".png";
			//Get sceen-shot
			File src=driver.getScreenshotAs(OutputType.FILE);
			//Save screen-shot
			File dest=new File(fname);
			FileHandler.copy(src,dest);
			//Attach to extent reports html file
			et.log(LogStatus.FAIL,"Title test failed"+
			                    et.addScreenCapture(fname));
		}
		//Close site
		driver.close();
		//Save results
		er.endTest(et);
		er.flush();
	}

}



