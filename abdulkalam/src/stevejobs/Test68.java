package stevejobs;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.chrome.ChromeDriver;
public class Test68 extends Thread
{
	public void run() 
	{
		try
		{
			Thread.sleep(10000); //for pop-up activation
			//Automate pop-up
			Robot r=new Robot();
			StringSelection x=new StringSelection("mindq");
			Toolkit.getDefaultToolkit().getSystemClipboard()
			                             .setContents(x,null);
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(5000);
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(5000);
			StringSelection y=new StringSelection("mindq123");
			Toolkit.getDefaultToolkit().getSystemClipboard()
			                             .setContents(y,null);
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(5000);
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(5000);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		}
		catch(Exception e)
		{
		}
	}
	public static void main(String[] args) throws Exception
	{
		Test68 obj=new Test68();
		obj.start(); //call run method
		System.setProperty("webdriver.chrome.driver",
				"E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://eforms.agility.com/");
		
	}
}




