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

public class Irctc 
{
	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver","H:\\Selenium\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		/*Scanner s=new Scanner(System.in);
		System.out.println("From where");
		String x=s.nextLine();
		System.out.println("to");
		String y=s.nextLine();
		System.out.println("No.of passengers like 1 or 2");
		int z=s.nextInt();*/
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
	    driver.findElement(By.xpath("//input[@name='userId']")).sendKeys("Msasi225");
	    driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("Ms@si1244");	  
	    w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@id='captchaImg']")));
	    WebElement f=driver.findElement(By.xpath("//img[@id='captchaImg']"));	
	    int w1=f.getSize().getWidth();
	    int h=f.getSize().getHeight();
	    int x=f.getLocation().getX();
	    int y=f.getLocation().getY();
	    Screen ss=new Screen();	    	    
	    Region r=new Region(x,y+110,w1,h);
        ss.mouseMove(r);
        File image= new File("H:\\Selenium\\secondproject\\captch.png");
		ScreenImage si=s1.capture(r);
		BufferedImage bi=si.getImage();
		ImageIO.write(bi,"png",image);              
        /*driver.findElement(By.name("nlpAnswer")).sendKeys(r1);   
	    driver.findElement(By.xpath("//button[text()='SIGN IN']")).click();
	    driver.findElement(By.xpath("//input[@placeholder='From*']")).sendKeys(x);	    
	    Thread.sleep(2000);
	    Actions a=new Actions(driver);
	    a.sendKeys(Keys.DOWN).build().perform();	    
	    a.sendKeys(Keys.ENTER).build().perform();	    
	    driver.findElement(By.xpath("//input[@placeholder='To*']")).sendKeys(y);  	  
	    Thread.sleep(2000);
	    a.sendKeys(Keys.DOWN).build().perform();
	    a.sendKeys(Keys.ENTER).build().perform();
	    driver.findElement(By.xpath("(//input[@type='text'])[4]")).click();
	    Thread.sleep(1000);
	    WebElement b=driver.findElement(By.xpath("(//a[@draggable='false'])[30]"));
	    Thread.sleep(2000);	   
	    a.click(b).build().perform();   
	    driver.findElement(By.xpath("//div[contains(@class,'ui-dropdown')]/span")).click();
	    Thread.sleep(1000);
	    WebElement c1=driver.findElement(By.xpath("//span[text()='Sleeper (SL)']"));
	    a.click(c1).build().perform();	    
	    //driver.findElement(By.xpath("//*[text()='Flexible With Date']")).click();
	    w.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@label='Find Trains']")));
	    driver.findElement(By.xpath("//button[@label='Find Trains']")).click();	 
	    Thread.sleep(3000);
	    w.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(@class,'ui-dropdown')])[2]")));
	    WebElement c=driver.findElement(By.xpath("(//span[contains(@class,'ui-dropdown')])[2]"));
	    a.click(c).build().perform();
	    if(z==1)
	    {
	    	for(int i=1;i<=2;i++)
	    	{
	    a.sendKeys(Keys.DOWN).build().perform();	   
	    }
	    }
	    else if(z==2)
	    {
	    	for(int i=1;i<=3;i++)
	    	{
	    a.sendKeys(Keys.DOWN).build().perform();	    
	    }
	    }
	    else if(z==3)
	    {
	    	for(int i=1;i<=4;i++)
	    	{
	    a.sendKeys(Keys.DOWN).build().perform();	  
	    }
	    }
	    else if(z==4)
	    {
	    	for(int i=1;i<=5;i++)
	    	{
	    a.sendKeys(Keys.DOWN).build().perform();	   
	    }
	    }
	    else if(z==5)
	    {
	    	for(int i=1;i<=6;i++)
	    	{
	    a.sendKeys(Keys.DOWN).build().perform();	  
	    }
	    }
	    else if(z==6)
	    {
	    	for(int i=1;i<=7;i++)
	    	{
	    a.sendKeys(Keys.DOWN).build().perform();	    
	    }
	    }
	    w.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(@class,'ui-dropdown')])[5]")));
	    WebElement d=driver.findElement(By.xpath("(//span[contains(@class,'ui-dropdown')])[5]"));	    
	    w.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='SIMHAPURI EXP']")));
	    driver.findElement(By.xpath("(//button[text()='Check availability & fare '])[2]")).click();
	    Thread.sleep(3000);
	    //scroll to element
	    WebElement e=driver.findElement(By.xpath("//span[text()='GOUTAMI EXP']"));
	    driver.executeScript("arguments[0].scrollIntoView;", e);
	    driver.executeScript("window.scrollTo(0,document.body.scrollHeight);");
	    driver.executeScript("window.scrollTo(document.body.scrollHeight,0);");
	    driver.executeScript("arguments[0].scrollIntoView;", e);
	    //close
	    //driver.close();*/
	}
	}
