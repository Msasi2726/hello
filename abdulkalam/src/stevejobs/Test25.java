package stevejobs;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test25 
{
	public static void main(String[] args) throws Exception
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
						    "E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		//find element and get x,y, width & height
		WebElement e=driver.findElement(By.xpath(
				         "//*[@id='hplogo']/descendant::*[2]"));
		int x=e.getLocation().getX();
		int y=e.getLocation().getY();
		int w=e.getSize().getWidth();
		int h=e.getSize().getHeight();
		//get page screenshot
		File ss=driver.getScreenshotAs(OutputType.FILE);
		BufferedImage  fullimg=ImageIO.read(ss);
		//Get only element screenshot from page screenshot
		BufferedImage elescreenshot= 
				               fullimg.getSubimage(x,y,w,h);
		ImageIO.write(elescreenshot,"png",ss);
		//Save element screenshot
		File dest=new File("myeless.png");
		FileUtils.copyFile(ss,dest);
		//close site
		driver.close();
		
		
		

	}

}




