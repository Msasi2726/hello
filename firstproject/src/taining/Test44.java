package taining;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Button;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.sikuli.script.ScreenImage;

public class Test44
{
	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","H:\\Selenium\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//lunch site
		driver.get("http://www.youtube.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait w=new WebDriverWait(driver,10);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Search']")));
		driver.manage().window().maximize();
		//fill fields for search required video(swd)
		driver.findElement(By.name("search_query")).sendKeys("abdhulkalam speeches");
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@aria-label='Search'])[3]/child::*[1]")));
		driver.findElement(By.xpath("(//*[@aria-label='Search'])[3]/child::*[1]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@title,'Dr. A P J Abdul Kalam in European Parliament')]")));
		driver.findElement(By.xpath("//a[contains(@title,'Dr. A P J Abdul Kalam in European Parliament')]")).click();	
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Abdul Kalam in European Parliament')])[3]")));
		//Automate video elements(sikulix)
		Screen s=new Screen();
		Thread.sleep(5000);//to get skip add in advertisement
		if(s.exists("Skipad.png")!= null)
		{
			s.click("Skipad.png");
		}
		//pause
		Thread.sleep(5000);
		Location l=new Location(300,300);
		s.wheel(l,Button.LEFT,0);
		s.click("full.png");
		Thread.sleep(6000);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(5000);
		s.wheel(l,Button.LEFT,0);
		s.click("pause.png");
		Thread.sleep(5000);//Click play Button
		s.wheel(l,Button.LEFT,0);
		s.click("play.png");
		Thread.sleep(5000);
		//capture full screens as screen shot(sikulix)
		File f=new File("H:\\Selenium\\firstproject\\fullscreen2.png");
		Screen s1=new Screen();
		ScreenImage si=s1.capture();
		BufferedImage bi=si.getImage();
		ImageIO.write(bi,"png",f);
		//move mouse to video body move to volume
		s.wheel(l,Button.LEFT,0);
		s.mouseMove("volume.png");
		//Automate slider from right to left(decrease volume)
		Match e=s.find("buble.png");
		int x=e.getX();
		int y=e.getY();
		Location l1=new Location(x-50,y);
		s.dragDrop(e,l1);
		Thread.sleep(5000);
		//Automate slider from left to right(increase volume)
		Location l2=new Location(x+50,y);
		s.dragDrop(e,l2);
		Thread.sleep(6000);  
		//capture part of screen as screen as screen-short(sikulix)
		File f2=new File("H:\\Selenium\\firstproject\\Partofcreen2.png");
		Region r1=new Region(100,100,500,500);
		ScreenImage si1=s.capture(r1);
		BufferedImage bi1=si1.getImage();
		ImageIO.write(bi1,"png",f2);
		s.wheel(l,Button.LEFT,0);
		s.click("pause.png");		
		s.wheel(l,Button.LEFT,0);		
		Thread.sleep(5000);
		s.click("play.png");
		Thread.sleep(5000);
		//close
		driver.close();
	}
}
