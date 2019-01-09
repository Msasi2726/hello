package stevejobs;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Test56
{
	public static void main(String[] args)
	{
		DesiredCapabilities c=DesiredCapabilities.firefox();
		c.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		System.setProperty("webdriver.gecko.driver","E:\\batch241\\geckodriver.exe");
		FirefoxDriver driver=new FirefoxDriver(c);
		driver.manage().window().maximize();
		driver.get("https://cacert.org/");
		

	}

}
