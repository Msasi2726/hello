package stevejobs;
import org.openqa.selenium.chrome.ChromeDriver;
public class Test106 
{
	public void finalize()
	{
		System.out.println("Testing completed");
	}  
	public static void main(String[] args) throws 
	                                          Exception 
	{
		Test106 obj=new Test106();
		obj=null;
		System.setProperty("webdriver.chrome.driver",
		           "E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		driver.close();
		//finalize() can run automatically
		System.gc();
	}
}




