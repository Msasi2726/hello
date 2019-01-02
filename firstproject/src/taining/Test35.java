package taining;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Test35
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","H:\\\\Selenium\\\\chromedriver.exe");
		DesiredCapabilities dc=DesiredCapabilities.chrome();
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		ChromeDriver driver=new ChromeDriver(dc);
		driver.get("http://www.google.com");
		//close
		driver.close();
	}
}
