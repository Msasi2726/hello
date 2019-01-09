package stevejobs;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Test67
{
	public static void main(String[] args) throws Exception
	{
		//Launch gmail site(SWD)
		System.setProperty("webdriver.chrome.driver",
				"E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.gmail.com");
		WebDriverWait w=new WebDriverWait(driver,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(
				                       By.name("identifier")));
		//Do login
		driver.findElement(By.name("identifier"))
		                              .sendKeys("gvraman167");
		w.until(ExpectedConditions.elementToBeClickable(
				              By.xpath("//*[text()='Next']")));
		driver.findElement(By.xpath("//*[text()='Next']"))
		                                              .click();
		w.until(ExpectedConditions.visibilityOfElementLocated(
				                        By.name("password")));
		driver.findElement(By.name("password"))
		                                 .sendKeys("rams9666");
		w.until(ExpectedConditions.elementToBeClickable(
	                         By.xpath("//*[text()='Next']")));
        driver.findElement(By.xpath("//*[text()='Next']"))
                                                     .click();
        w.until(ExpectedConditions.visibilityOfElementLocated(
        		          By.xpath("//*[text()='Compose']")));
        //close notifications
        driver.findElement(By.xpath(
        		"//*[@role='button'][@class='bBe']")).click();
        //Do compose
        driver.findElement(By.xpath("//*[text()='Compose']"))
                                                     .click();
        w.until(ExpectedConditions.visibilityOfElementLocated(
        		                              By.name("to")));
        //Fill fields
        driver.findElement(By.name("to")).sendKeys(
        		                         "apj@abdulkalam.com");
        driver.findElement(By.name("subjectbox")).sendKeys(
        		                                    "wishes");
        driver.findElement(By.xpath(
        	"(//*[@aria-label='Message Body'])[2]")).sendKeys(
        			"Hi sir\nAdvanced happy birthday\nBye sir");
        driver.findElement(By.xpath(
        	"//*[@name='Filedata']/preceding::div[2]")).click();
        //Automate file upload window(Java Robot)
        Thread.sleep(10000); //for file upload window
        StringSelection x=new StringSelection(
        	 "C:\\Users\\Public\\Pictures\\Sample Pictures\\tulips.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard()
                                         .setContents(x,null);
        Robot r=new Robot();
        if(System.getProperty("os.name").contains("Windows"))
        {
        	r.keyPress(KeyEvent.VK_CONTROL);
        	r.keyPress(KeyEvent.VK_V);
        	r.keyRelease(KeyEvent.VK_V);
        	r.keyRelease(KeyEvent.VK_CONTROL);
        	Thread.sleep(5000);
        }
        else if(System.getProperty("os.name").contains("Mac"))
        {
        	r.keyPress(KeyEvent.VK_META);
        	r.keyPress(KeyEvent.VK_V);
        	r.keyRelease(KeyEvent.VK_V);
        	r.keyRelease(KeyEvent.VK_META);
        	Thread.sleep(5000);
        }
        else if(System.getProperty("os.name").contains("Linux"))
        {
        	r.keyPress(KeyEvent.VK_CONTROL);
        	r.keyPress(KeyEvent.VK_V);
        	r.keyRelease(KeyEvent.VK_V);
        	r.keyRelease(KeyEvent.VK_CONTROL);
        	Thread.sleep(5000);
        }
        else
        {
        	System.out.println("Unknown os");
        	System.exit(0);
        }
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
        //wait until file upload to start
        w.until(ExpectedConditions.visibilityOfElementLocated(
        		                By.xpath("//*[@class='vq']")));
        //wait until complete file upload
        w.until(ExpectedConditions.attributeContains(By.xpath(
        		         "//*[@class='vq']"),"role","button"));
        driver.findElement(By.xpath(
        		"//*[contains(@aria-label,'Send')]")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(
        	By.xpath("//*[contains(text(),'Message sent')]")));
        //Do logout after closing notifications
        driver.findElement(By.xpath(
        		"//*[@role='button'][@class='bBe']")).click();
        driver.findElement(By.xpath(
        		      "//*[contains(@class,'gbii')]")).click();
        w.until(ExpectedConditions.elementToBeClickable(
        		                     By.linkText("Sign out")));
        driver.findElement(By.linkText("Sign out")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        driver.close();
	}
}








