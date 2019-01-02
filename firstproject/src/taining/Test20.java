package taining;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test20
{
	@SuppressWarnings("resource")
	public static void main(String[] args) throws InterruptedException 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a word to Search");
		String x=sc.nextLine();
		System.out.println("Enter Expected Suggestion");
		String y=sc.nextLine();		
		//launch site
		System.setProperty("webdriver.chrome.driver", "H:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();		
		driver.get("http://www.google.co.in");
		//maximize window
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Enter text to Auto-Complete
		//To get Suggestion
		WebElement e=driver.findElement(By.name("q"));
		Actions a=new Actions(driver);
        a.sendKeys(e,x).build().perform();
        Thread.sleep(5000);
        int c=0;
        while(2>1)
        {
        	a.sendKeys(Keys.DOWN).build().perform();
            c=c+1;
            String z=e.getAttribute("value");            
            Thread.sleep(3000);
            System.out.println(z);
            if(z.equals(y))
            {
            	System.out.println("Item was found "+c);
            	Thread.sleep(5000);
            	a.sendKeys(Keys.ENTER).build().perform();
            	break;
            }
            if(c==10)
            {
            	System.out.println("Sorry item was Not fund");
            	break;
            }   
        }
        //Close
        driver.close();
	}
}
