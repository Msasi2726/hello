package project2;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GmailModified 
{
	public static void main(String[] args) throws Exception
	{
		WebDriver driver=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter browser name");
		String b=sc.nextLine();
		if(b.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver","H:\\Selenium\\chromedriver.exe");
        driver=new ChromeDriver();
		}
		else if(b.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","H:\\Selenium\\geckodriver.exe");
	        driver=new FirefoxDriver();	
		}
		else if(b.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver","H:\\Selenium\\IEDriverserver.exe");
	        driver=new InternetExplorerDriver();
		}
		else if(b.equalsIgnoreCase("opera"))
		{
			OperaOptions c=new OperaOptions();
			c.setBinary("C:\\Program Files\\Opera\\54.0.2952.51\\opera.exe");
			System.setProperty("webdriver.opera.driver","H:\\Selenium\\operadriver.exe");
	        driver=new OperaDriver(c);
		}
		else
		{
			System.out.println("invalid browser name");
			System.exit(0);
		}
		//Launch site
        driver.manage().deleteAllCookies();        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Launch site
        driver.get("http://www.gmail.com");
        //Maximize
        driver.manage().window().maximize();
        //Login
        driver.findElement(By.xpath("//input[@name='identifier']")).sendKeys("msasikiran225");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Next']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Ms@si2726");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Next']")).click();
        Thread.sleep(4000);          
        //Input give to select
        @SuppressWarnings("resource")
		Scanner sc9=new Scanner(System.in);
        System.out.println("Enter name ex:-Primary");
        String x=sc9.nextLine();
        Thread.sleep(5000); 
        WebElement d=driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[7]"));   	
        WebElement e=driver.findElement(By.xpath("//div[@gh='mtb']/div/div/child::div[2]/div[3]"));    	
        WebElement f=driver.findElement(By.xpath("//div[@gh='mtb']/div/div/child::div[4]"));
        Thread.sleep(2000); 
        int i=1;
        {
        	if(x.equals("Trash"))
        	{
        	//Count no.of mails in Trash and Delete 
            Thread.sleep(8000);                       
            driver.findElement(By.xpath("(//div[@class='n6'])/descendant::span[3]/div")).click();
            Thread.sleep(10000);           
            driver.findElement(By.xpath("((//div[@class='aim'])/div/div/div/span/a)[last()]")).click();
            Thread.sleep(3000);   
            //Trash Count
            WebElement a=driver.findElement(By.xpath("(//span[@class='ts'])[6]"));
            ((RemoteWebDriver) driver).executeScript("var x=arguments[0].textContent;window.alert(x);",a);
            String q=driver.switchTo().alert().getText();
            System.out.println(q);
            driver.findElement(By.name("q")).sendKeys("b");
            Thread.sleep(3000);
            driver.switchTo().alert().dismiss();
            //Convert to integer
            String number=b;
            int result=Integer.parseInt(number);
            System.out.println(result);
            Thread.sleep(10000);
            	for(i=1;i<=result;) 	
                {        	
        		driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[7]")).click();
            	Thread.sleep(2000);
            	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[37]")).click();
            	Thread.sleep(2000);
            	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[11]")).click();
            	Thread.sleep(2000);
            	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[25]")).click();            	            	
                }
            }        	
        if(x.equals("Primary"))
        {
        	//Count no.of mails in Primary
            driver.findElement(By.xpath("(//div[@class='aKz'])[1]")).click();
            Thread.sleep(2000);
            //Count on Primary
            WebElement k=driver.findElement(By.xpath("(//span[@class='ts'])[3]"));
            ((RemoteWebDriver) driver).executeScript("var x=arguments[0].textContent;window.alert(x);",k);
            String j=driver.switchTo().alert().getText();
            System.out.println(j);
            Thread.sleep(3000);
            //Convert to integer
            String number=j;
            int result=Integer.parseInt(number);
            System.out.println(result);
            //Go to table inside
        	driver.findElement(By.xpath("(//div[@class='aKz'])[1]")).click();
        	@SuppressWarnings("resource")
			Scanner sc1=new Scanner(System.in);
        	System.out.println("Enter name ex:-Unread");
            String x1=sc1.nextLine();
            Thread.sleep(4000);
            if(x1.equals("All"))
            {
            	for(i=1;i<=result;)
            {        	
        		d.click();
            	Thread.sleep(4000);            	
            	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[40]")).click();
            	Thread.sleep(1000);
            	e.click();
            	Thread.sleep(4000);
            	f.click();            	
        	} 
            }            
            if(x1.equals("Read"))
            {
            	for(i=1;i<=result;)            
            {        	
            		d.click();
            		Thread.sleep(4000);            	
                	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[44]")).click();
                	Thread.sleep(1000);
                	e.click();
                	Thread.sleep(4000);
                	f.click();                	
        	} 
            }
            if(x1.equals("Unread"))
            {   
            	for(i=1;i<=result;)
            	{            	
            		d.click();
            		Thread.sleep(4000);            	
                	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[46]")).click();
                	Thread.sleep(1000);
                	e.click();
                	Thread.sleep(4000);
                	f.click();                	
        	}  
            }
            if(x1.equals("Starred"))
            {
            	for(i=1;i<=result;)
            {        	
            		d.click();
            		Thread.sleep(4000);            	
                	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[48]")).click();
                	Thread.sleep(1000);
                	e.click();
                	Thread.sleep(4000);
                	f.click();                	
        	} 
            }
            if(x1.equals("Unstarred"))
            {      
            	for(i=1;i<=result;)
            	{            	
            		d.click();
            		Thread.sleep(4000);           	
                	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[50]")).click();
                	Thread.sleep(1000);
                	e.click();
                	Thread.sleep(4000);
                	f.click();                	
        	} 
            }
        }
        if(x.equals("Social"))
        {
        	//Count no.of mails in Social
            driver.findElement(By.xpath("(//div[@class='aKz'])[2]")).click();
            Thread.sleep(2000);
            //Count on Social
            WebElement q=driver.findElement(By.xpath("(//span[@class='ts'])[3]"));
            ((RemoteWebDriver) driver).executeScript("var x=arguments[0].textContent;window.alert(x);",q);
            String r=driver.switchTo().alert().getText();
            System.out.println(r);
            driver.switchTo().alert().accept(); 
            Thread.sleep(3000);
            //Convert to integer
            String number=r;
            int result=Integer.parseInt(number);
            System.out.println(result);            
            //Go to table inside
        	driver.findElement(By.xpath("(//div[@class='aKz'])[2]")).click();        	
        	@SuppressWarnings("resource")
			Scanner sc2=new Scanner(System.in);
        	System.out.println("Enter name ex:-Unread");
            String x2=sc2.nextLine();
            Thread.sleep(4000);
            if(x2.equals("All"))
            {        	
            	for(i=1;i<=result;)
            	{
            		d.click();
            		Thread.sleep(4000);            	
                	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[40]")).click();
                	Thread.sleep(1000);
                	e.click();
                	Thread.sleep(4000);
                	f.click();                	
        	}    
            }
            if(x2.equals("Read"))
            {        	
            	for(i=1;i<=result;)
            	{
            		d.click();
            		Thread.sleep(4000);            	
                	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[44]")).click();
                	Thread.sleep(1000);
                	e.click();
                	Thread.sleep(4000);
                	f.click();                	
        	} 
            }
            if(x2.equals("Unread"))
            {      
            	for(i=1;i<=result;)
            	{
            		d.click();
            		Thread.sleep(4000);           	
                	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[46]")).click();
                	Thread.sleep(1000);
                	e.click();
                	Thread.sleep(4000);
                	f.click();                	
        	}  
            }
            if(x2.equals("Starred"))
            {    
            	for(i=1;i<=result;)
            	{
            		d.click();
            		Thread.sleep(4000);           	
                	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[48]")).click();
                	Thread.sleep(1000);
                	e.click();
                	Thread.sleep(4000);
                	f.click();                	
        	} 
            }
            if(x2.equals("Unstarred"))
            {      
            	for(i=1;i<=result ;)
            	{
            		d.click();
            		Thread.sleep(4000);            	
                	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[50]")).click();
                	Thread.sleep(1000);
                	e.click();
                	Thread.sleep(4000);
                	f.click();                	
        	}    
            }  
        }
        if(x.equals("Promotions"))
        {
        	 //Count no.of mails in Promotions
            driver.findElement(By.xpath("(//div[@class='aKz'])[3]")).click();
            Thread.sleep(2000);
            //Count on Promotions
            WebElement s=driver.findElement(By.xpath("(//span[@class='ts'])[3]"));
            ((RemoteWebDriver) driver).executeScript("var x=arguments[0].textContent;window.alert(x);",s);
            String t=driver.switchTo().alert().getText();
            System.out.println(t);
            driver.switchTo().alert().accept();
            //Convert to integer
            String number=t;
            int result=Integer.parseInt(number);
            System.out.println(result);
            Thread.sleep(3000);                        
            //Go to inside table
        	driver.findElement(By.xpath("(//div[@class='aKz'])[3]")).click();
        	@SuppressWarnings("resource")
			Scanner sc3=new Scanner(System.in);
        	System.out.println("Enter name ex:-Unread");
            String x3=sc3.nextLine();
            Thread.sleep(4000);
            if(x3.equals("All"))
            {    
            	for(i=1;i<=result;)
            	{
            		d.click();
            		Thread.sleep(4000);            	
                	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[40]")).click();
                	Thread.sleep(1000);
                	e.click();
                	Thread.sleep(4000);
                	f.click();                	
        	}   
            }
            if(x3.equals("Read"))
            {   
            	for(i=1;i<=result;)
            	{
            		d.click();
            		Thread.sleep(4000);            	
                	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[44]")).click();
                	Thread.sleep(1000);
                	e.click();
                	Thread.sleep(4000);
                	f.click();                	
        	} 
            }
            if(x3.equals("Unread"))
            {
            	for(i=1;i<=result;)
            	{
            		d.click();
            		Thread.sleep(4000);            	
                	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[46]")).click();
                	Thread.sleep(1000);
                	e.click();
                	Thread.sleep(4000);
                	f.click();                	
        	} 
            }
            if(x3.equals("Starred"))
            {
            	for(i=1;i<=result;)
            	{
            		d.click();
            		Thread.sleep(4000);            	
                	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[48]")).click();
                	Thread.sleep(1000);
                	e.click();
                	Thread.sleep(4000);
                	f.click();                	
        	} 
            }
            if(x3.equals("Unstarred"))
            {
            	for(i=1;i<=result;)
            	{
            		d.click();
            		Thread.sleep(4000);            	
                	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[50]")).click();
                	Thread.sleep(1000);
                	e.click();
                	Thread.sleep(4000);
                	f.click();                	
        	}
            }
        }        
        if(x.equals("Updates"))
        {
        	//Count no.of mails in Updates
            driver.findElement(By.xpath("(//div[@class='aKz'])[4]")).click();
            Thread.sleep(2000);
            //Count on Updates
            WebElement u=driver.findElement(By.xpath("(//span[@class='ts'])[3]"));
            ((RemoteWebDriver) driver).executeScript("var x=arguments[0].textContent;window.alert(x);",u);
            String y=driver.switchTo().alert().getText();
            System.out.println(y);
            driver.switchTo().alert().accept();
            //Convert to integer
            String number=y;
            int result=Integer.parseInt(number);
            System.out.println(result);
            Thread.sleep(3000);            
            //Go to inside table
        	driver.findElement(By.xpath("(//div[@class='aKz'])[4]")).click();
        	@SuppressWarnings("resource")
			Scanner sc4=new Scanner(System.in);
        	System.out.println("Enter name ex:-Unread");
            String x4=sc4.nextLine();
            Thread.sleep(4000);
            if(x4.equals("All"))
            {
            	for(i=1;i<=900;)
            	{
            		d.click();
            		Thread.sleep(4000);         	
                	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[40]")).click();
                	Thread.sleep(1000);
                	e.click();
                	Thread.sleep(4000);
                	f.click();                	
        	}    
            }
            if(x4.equals("Read"))
            {
            	for(i=1;i<=result;)
            	{
            		d.click();
            		Thread.sleep(4000);            	
                	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[44]")).click();
                	Thread.sleep(1000);
                	e.click();
                	Thread.sleep(4000);
                	f.click();                	
        	} 
            }
            if(x4.equals("Unread"))
            {
            	for(i=1;i<=result;)
            	{
            		d.click();
            		Thread.sleep(4000);            	
                	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[46]")).click();
                	Thread.sleep(1000);
                	e.click();
                	Thread.sleep(4000);
                	f.click();                	
        	}  
            }
            if(x4.equals("Starred"))
            {
            	for(i=1;i<=result;)
            	{
            		d.click();
            		Thread.sleep(4000);            	
                	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[48]")).click();
                	Thread.sleep(1000);
                	e.click();
                	Thread.sleep(4000);
                	f.click();                	
        	} 
            }
            if(x4.equals("Unstarred"))
            {
            	for(i=1;i<=result;)
            	{
            		d.click();
            		Thread.sleep(4000);            	
                	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[50]")).click();
                	Thread.sleep(1000);
                	e.click();
                	Thread.sleep(4000);
                	f.click();                	
        	}  
            }
        }
        if(x.equals("Forums"))
        {
        	//Count no.of mails in Forums
            driver.findElement(By.xpath("(//div[@class='aKz'])[5]")).click();
            Thread.sleep(2000);
            //Count on Forums
            WebElement w=driver.findElement(By.xpath("(//span[@class='ts'])[3]"));
            ((RemoteWebDriver) driver).executeScript("var x=arguments[0].textContent;window.alert(x);",w);
            String y=driver.switchTo().alert().getText();
            System.out.println(y);
            driver.switchTo().alert().accept();
            //Convert to integer
            String number=y;
            int result=Integer.parseInt(number);
            System.out.println(result);
            Thread.sleep(3000);            
            //Go to inside table
        	driver.findElement(By.xpath("(//div[@class='aKz'])[5]")).click();
        	@SuppressWarnings("resource")
			Scanner sc5=new Scanner(System.in);
        	System.out.println("Enter name ex:-Unread");
            String x5=sc5.nextLine();
            Thread.sleep(4000);            
            if(x5.equals("All"))
            {
            	for(i=1;i<=result;)
            	{
            		d.click();
            		Thread.sleep(4000);           	
                	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[40]")).click();
                	Thread.sleep(1000);
                	e.click();
                	Thread.sleep(4000);
                	f.click();                	
        	}    
            }
            if(x5.equals("Read"))
            {
            	for(i=1;i<=result;)
            	{
            		d.click();
            		Thread.sleep(4000);           	
                	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[44]")).click();
                	Thread.sleep(1000);
                	e.click();
                	Thread.sleep(4000);
                	f.click();                	
        	} 
            }
            if(x5.equals("Unread"))
            {
            	for(i=1;i<=result;)
            	{
            		d.click();
            		Thread.sleep(4000);            	
                	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[46]")).click();
                	Thread.sleep(1000);
                	e.click();
                	Thread.sleep(4000);
                	f.click();                	
        	}  
            }
            if(x5.equals("Starred"))
            {
            	for(i=1;i<=result;)
            	{
            		d.click();
            		Thread.sleep(4000);          	
                	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[48]")).click();
                	Thread.sleep(1000);
                	e.click();
                	Thread.sleep(4000);
                	f.click();               	
        	} 
            }
            if(x5.equals("Unstarred"))
            {
            	for(i=1;i<=result;)
            	{
            		d.click();
            		Thread.sleep(4000);            	
                	driver.findElement(By.xpath("//div[@gh='mtb']/descendant::div[50]")).click();
                	Thread.sleep(1000);
                	e.click();
                	Thread.sleep(4000);
                	f.click();                	
        	}    
            }
            }        
        }       
        Thread.sleep(5000);
        //close
        driver.close();
	}	
}
