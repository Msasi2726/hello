package stevejobs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Test58
{
	public static void main(String[] args) 
	{
		FirefoxProfile fp=new FirefoxProfile();
		fp.setPreference("dom.webnotifications.enabled",false);
		WebDriver driver = new FirefoxDriver();
		driver.get("https://jabong.com");

	}

}
