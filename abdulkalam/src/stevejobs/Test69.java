package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Key;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;

public class Test69
{
	public static void main(String[] args) throws Exception 
	{
		//Launch site(SWD)
		System.setProperty("webdriver.chrome.driver",
				"E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.youtube.com");
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(
				                              By.id("search")));
		//Search for a video(SWD)
		driver.findElement(By.id("search")).sendKeys(
				                    "abdul kalam sir speeches");
		driver.findElement(By.xpath(
			"(//button[@aria-label='Search'])[2]/child::*[1]"))
		                                              .click();
		w.until(ExpectedConditions.visibilityOfElementLocated(
		                                             By.xpath(
		 "//*[contains(text(),'Kalam in European Parliament')]")
		                                                    ));
		//Start video(SWD)
		driver.findElement(By.xpath(
		 "//*[contains(text(),'Kalam in European Parliament')]")
				                                     ).click();
		//Skip add if exists(SikuliX)
		Thread.sleep(10000);
		Screen s=new Screen();
		if(s.exists("skipadd.png")!=null)
		{
			s.click("skipadd.png");
		}
		//Pause video(SikukliX)
		s.mouseMove(200,200);//move mouse pointer to video body
		s.click("pause.png");
		//Play video(SikukliX)
		Thread.sleep(5000);
		s.mouseMove(200,200);//move mouse pointer to video body
		s.click("play.png");
		//Decrease volume(SikukliX)
		Thread.sleep(5000);
		s.mouseMove(200,200);//move mouse pointer to video body
		s.mouseMove("volume.png");
		Match e=s.find("bubble.png");
		int x=e.getX();
		int y=e.getY();
		Location l1=new Location(x-50,y);
		s.dragDrop(e,l1);
		Thread.sleep(5000);
		//Increase volume(SikukliX)
		Location l2=new Location(x+50,y);
		s.dragDrop(e,l2);
		Thread.sleep(5000);
		//Close site(Sikulix)
		s.keyDown(Key.ALT);
		s.keyDown(Key.F4);
		s.keyUp(Key.F4);
		s.keyUp(Key.ALT);
	}
}







