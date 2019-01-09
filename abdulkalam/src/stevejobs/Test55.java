package stevejobs;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Test55
{
	public static void main(String[] args)
	{
		DesiredCapabilities c=DesiredCapabilities.internetExplorer();
		c.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		System.setProperty("webdriver.ie.driver","E:\\batch241\\IEDriverServer.exe");
		InternetExplorerDriver driver = new InternetExplorerDriver(c);
		driver.manage().window().maximize();
		driver.get("https://cacert.org/");
		
	}

}
