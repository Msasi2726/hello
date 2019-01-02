 package project2;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Brid2
{
	public static void main(String[] args) throws Exception 
	{			
		System.setProperty("webdriver.chrome.driver","H:\\Selenium\\chromedriver.exe");
        ChromeDriver driver=new ChromeDriver();		
        driver.manage().deleteAllCookies();       
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Launch site
        driver.get("https://www.bidwarriors.com/warriors-treat.php?auid=BE1806");
        //Maximize
        driver.manage().window().maximize();
        // click on Login
        driver.findElement(By.xpath("//a[text()='Login'][1]")).click();
        //login
        driver.findElement(By.name("mobileNumber")).sendKeys("8919125458");
        driver.findElement(By.name("password")).sendKeys("Ms@si27265");
        driver.findElement(By.xpath("//button[@id='login-btn']")).click();
        //Select Auctions   
        driver.findElement(By.xpath("//h5[text()='Auction ID - A97B52']")).click();               
        String x=driver.findElement(By.xpath("//span[@id='new-min-bid-price']")).getText();
        System.out.println(x);
        String y=driver.findElement(By.xpath("//span[@id='new-max-bid-price']")).getText();
        System.out.println(y);   
        int c=0;
        if(x!=y)
        {
        	while(2>1)
        		{
        	     driver.findElement(By.xpath("//input[@id='new-bid-amount']")).sendKeys(x);
        	     WebDriverWait w=new WebDriverWait(driver, 20);
        	     
        	     driver.findElement(By.xpath("//button[@id='bid']")).click();
        	     Thread.sleep(1000);
        	     c=c+1;
        	     if(c==10)
        	     {
        	    	 break;
        	     }
               }
        } 
        else if(x==x)
        {
        driver.findElement(By.xpath("//input[@id='new-bid-amount']")).sendKeys(y);
        driver.findElement(By.xpath("//button[@id='bid']")).click();
        }            
        else if(y==y)
        {
        	driver.findElement(By.xpath("//input[@id='new-bid-amount']")).sendKeys(x);
        	driver.findElement(By.xpath("//button[@id='bid']")).click();
        }        
        driver.findElement(By.xpath("(//b[@class='caret'])[1]")).click();
        driver.findElement(By.xpath("(//a[@href='logout.php'])[1]")).click();
        //Close
        Thread.sleep(5000);
        driver.close();
	}
}
