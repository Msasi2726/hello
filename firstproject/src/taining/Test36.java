package taining;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class Test36 
{
	public static void main(String[] args) 
	{
		ProfilesIni p=new ProfilesIni();
		FirefoxProfile fp=p.getProfile("default");
		fp.setAcceptUntrustedCertificates(true);
		fp.setAssumeUntrustedCertificateIssuer(false);
		System.setProperty("webdriver.gecko.driver","H:\\Selenium\\geckodriver.exe");
        FirefoxDriver driver=new FirefoxDriver();
        driver.get("http://www.google.com");
	}
}
