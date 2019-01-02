package project2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;

public class ir 
{
	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver","H:\\Selenium\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);		
		//launch site
	    driver.get("https://www.irctc.co.in/nget/train-search");
	    Screen s1=new Screen();	   
	    if(s1.exists("login.png")!= null)
	    {
	    	s1.click("login.png");
	    }
	    WebDriverWait w=new WebDriverWait(driver,100);
	    w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='From*']")));
	    driver.manage().window().maximize();
	    driver.findElement(By.xpath("//a[@id='loginText']")).click();	    
	    w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@id='captchaImg']")));
	    WebElement f=driver.findElement(By.xpath("//img[@id='captchaImg']"));	
	    Screen s=new Screen();	    
	    driver.executeScript("arguments[0].style.border='2px blue solid';",f);	     	    
	    /*File image= new File("captcha");
	    Region r=new Region();   
		ScreenImage si=s.capture(r);
		BufferedImage bi=si.getImage();
		ImageIO.write(bi,"png",image);
	    ITesseract im = new Tesseract();        
        String re = im.doOCR(image);
        System.out.println(re);        
        driver.findElement(By.name("nlpAnswer")).sendKeys(re);*/
	}

}
