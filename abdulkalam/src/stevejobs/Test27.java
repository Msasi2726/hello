package stevejobs;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test27 
{
	public static void main(String[] args) throws Exception
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
	             "E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.mercurytravels.co.in");         
		Thread.sleep(5000);
		//Maximize browser window
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Get size of browser window
		int w=driver.manage().window().getSize().getWidth();
		int h=driver.manage().window().getSize().getHeight();
		System.out.println(w+" "+h);
		//Change size of browser window
		Dimension d=new Dimension(300,200); //width & height
		driver.manage().window().setSize(d);
		Thread.sleep(5000);
		//Get position of browser window
		int x=driver.manage().window().getPosition().getX();
		int y=driver.manage().window().getPosition().getY();
		System.out.println(x+" "+y);
		//Change position of browser window
		Point p=new Point(400,300); //x & y
		driver.manage().window().setPosition(p);
		Thread.sleep(5000);
		//close site
		driver.close();

	}

}







