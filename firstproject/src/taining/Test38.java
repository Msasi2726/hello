package taining;

import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Test38
{
	public static void main(String[] args) 
	{
		DesiredCapabilities dc=DesiredCapabilities.opera();
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		OperaOptions c=new OperaOptions();
		c.setBinary("C:\\Program Files\\Opera\\53.0.2907.99\\opera.exe");		
		System.setProperty("webdriver.opera.driver","H:\\Selenium\\operadriver.exe");
		OperaDriver driver=new OperaDriver(c);
	}
}
