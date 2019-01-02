package taining;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Key;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.sikuli.script.ScreenImage;

public class Test45 
{
	public static void main(String[] args) throws Exception 
	{

		System.setProperty("webdriver.chrome.driver","H:\\Selenium\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//lunch site
		driver.get("http://www.google.com");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		//capture full screens as screen shot(sikulix)
		File f=new File("H:\\Selenium\\firstproject\\fullscreen.png");
		Screen s=new Screen();
		ScreenImage si=s.capture();
		BufferedImage bi=si.getImage();
		ImageIO.write(bi,"png",f);
		//capture part of screen as screen as screen-short(sikulix)
		File f1=new File("H:\\Selenium\\firstproject\\Partofcreen.png");
		Region r=new Region(100,100,500,500);
		ScreenImage si1=s.capture(r);
		BufferedImage bi1=si1.getImage();
		ImageIO.write(bi1,"png",f1);
		//close
		s.keyDown(Key.ALT);
		s.keyDown(Key.F4);
		s.keyUp(Key.F4);
		s.keyUp(Key.ALT);
	}
}
