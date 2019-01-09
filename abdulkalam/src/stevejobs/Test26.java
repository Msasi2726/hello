package stevejobs;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test26
{
	public static void main(String[] args) throws Exception
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
			             "E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.mercurytravels.co.in");
		Thread.sleep(5000);
		//find text-box elements and get x,y, width & height
		List<WebElement> l=driver.findElements(
				             By.xpath("//input[@type='text']"));
		for(int i=0;i<l.size();i++)
		{
			if(l.get(i).isDisplayed())
			{
				int x=l.get(i).getLocation().getX();
				int y=l.get(i).getLocation().getY();
				int w=l.get(i).getSize().getWidth();
				int h=l.get(i).getSize().getHeight();
				//get page screenshot
				File ss=driver.getScreenshotAs(OutputType.FILE);
				BufferedImage  fullimg=ImageIO.read(ss);
				//Get element screenshot from page screenshot
				BufferedImage elescreenshot= 
	                            fullimg.getSubimage(x,y,w,h);
				ImageIO.write(elescreenshot,"png",ss);
				//Save element screenshot
				File dest=new File("myeless"+i+".png");
				FileUtils.copyFile(ss,dest);
			}//if condition closing
		} //loop closing
		//close site
		driver.close();
	}
}
