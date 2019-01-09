package stevejobs;
import java.util.Scanner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
public class Test9
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter browser name");
		String x=sc.nextLine();
		WebDriver driver;
		if(x.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",
					"E:\\batch241\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(x.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",
					"E:\\batch241\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(x.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver",
					"E:\\batch241\\iedriverserver.exe");
			driver=new InternetExplorerDriver();
		}
		else if(x.equals("opera"))
		{
			OperaOptions oo=new OperaOptions();
			oo.setBinary("C:\\Program Files\\Opera\\53.0.2907.68\\opera.exe");
			System.setProperty("webdriver.opera.driver",
			 "E:\\batch241\\operadriver_win64\\operadriver.exe");
			driver=new OperaDriver(oo);
		}
		else
		{
			System.out.println("Unknown browser");
			System.exit(0);
		}
		//Launch site
		
		//Automate site
		//Close site
	}
}





