package taining;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Test37 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.ie.driver", "H:\\Selenium\\IEDriverserver.exe");
		DesiredCapabilities dc=DesiredCapabilities.internetExplorer();
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        InternetExplorerDriver driver=new InternetExplorerDriver(dc);
        driver.get("http://www.google.com");
	}
}
