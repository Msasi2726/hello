package stevejobs;

import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class Test4 
{
	public static void main(String[] args) 
	{
		OperaOptions oo=new OperaOptions();
		oo.setBinary("C:\\Program Files\\Opera\\53.0.2907.68\\opera.exe");
		System.setProperty("webdriver.opera.driver",
		 "E:\\batch241\\operadriver_win64\\operadriver.exe");
		OperaDriver driver=new OperaDriver(oo);
		

	}

}




