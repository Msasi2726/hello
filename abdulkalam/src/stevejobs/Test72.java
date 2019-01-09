package stevejobs;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Key;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.sikuli.script.ScreenImage;

public class Test72 
{
	public static void main(String[] args) throws Exception
	{
		//Launch site(SWD)
		System.setProperty("webdriver.chrome.driver",
				   "E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.google.co.in");
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(
				                                By.name("q")));
		driver.manage().window().maximize();
		//capture full screen as screen-shot(Sikulix)
		File f1=new File("E:\\batch241\\fullscreen.png");
		Screen s=new Screen();
		ScreenImage si1=s.capture();
		BufferedImage bi1=si1.getImage();
		ImageIO.write(bi1,"png",f1);
		//capture part of the screen as screen-shot(Sikulix)
		File f2=new File("E:\\batch241\\partofscreen.png");     
		Region r=new Region(100,100,500,400); //x,y,width,height
		ScreenImage si2=s.capture(r);
		BufferedImage bi2=si2.getImage();
		ImageIO.write(bi2,"png",f2);
		//close site(SikuliX)
		s.keyDown(Key.ALT);
		s.keyDown(Key.F4);
		s.keyUp(Key.F4);
		s.keyUp(Key.ALT);

	}

}
