package stevejobs;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
public class Test54 
{
	public static void main(String[] args) 
	{
		DesiredCapabilities c=DesiredCapabilities.chrome();
		c.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
		System.setProperty("webdriver.chrome.driver",
				  "E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver(c);
		driver.get("https://cacert.org/"); 
	}
}




