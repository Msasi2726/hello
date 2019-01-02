package project2;

import java.awt.image.BufferedImage;

import java.io.File;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.sikuli.script.ScreenImage;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.ImageHelper;
import net.sourceforge.tess4j.util.LoadLibs;
public class Indane
{
	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","H:\\Selenium\\chromedriver.exe");
        ChromeDriver driver=new ChromeDriver();		
        driver.manage().deleteAllCookies();       
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Launch site
        driver.get("https://indane.co.in/");
        //Maximize
        driver.manage().window().maximize();
        // click on Login
        driver.findElement(By.xpath("//input[@value='Username']")).sendKeys("Msasi27265");
        driver.findElement(By.xpath("//input[@value='Password']")).sendKeys("Ms@si9494");
        driver.findElement(By.xpath("//input[@title='Login']")).click();
        WebDriverWait w=new WebDriverWait(driver, 10);
        Screen s=new Screen();
        if(s.exists("Consumer")!= null)
        {
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Ms@si9494");
        //Select Captcha  
        WebElement a1=driver.findElement(By.xpath("//img[@id='captcha_img']"));
        int w1=a1.getSize().getWidth();
        int h=a1.getSize().getHeight();
        int x=a1.getLocation().getX();
        int y=a1.getLocation().getY();
        System.out.println(w1+" "+" "+h+" "+" "+x+" "+y+" ");
        Region r=new Region(x,y+110,w1,h);
        s.mouseMove(r);
        File image= new File("H:\\Selenium\\secondproject\\captch.png");
        Screen s1=new Screen();
		ScreenImage si=s1.capture(r);
		BufferedImage bi=si.getImage();
		ImageIO.write(bi,"png",image);
        //Load tessdata file
        File fo=LoadLibs.extractTessResources("tessdata");
        Tesseract obj=new Tesseract();
        obj.setDatapath(fo.getAbsolutePath());
        obj.setLanguage("eng");
        ImageHelper.convertImageToGrayscale(bi);
        Thread.sleep(10000);
        String result=obj.doOCR(image);
        Thread.sleep(20000);
        System.out.println(result);
        driver.findElement(By.xpath("//input[@name='captcha']")).sendKeys(result);
        driver.findElement(By.xpath("//input[@value='Submit']")).click();
        //close
        //driver.close();
        }
	}
}
