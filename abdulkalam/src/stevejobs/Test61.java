package stevejobs;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Test61
{
	public static void main(String[] args) 
	{
		//Get text from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your text");
		String x=sc.nextLine();
		//Launch website
		System.setProperty("webdriver.chrome.driver",
				     "E:\\batch241\\chromedriver.exe");
		ChromeOptions co=new ChromeOptions();
        co.addArguments("--use-fake-ui-for-media-stream=1");
		ChromeDriver driver=new ChromeDriver(co);
		driver.get("http://www.google.co.in");
		WebDriverWait w=new WebDriverWait(driver,10);
		w.until(ExpectedConditions.visibilityOfElementLocated(
				                                 By.name("q")));
		driver.manage().window().maximize();
		//lick on mic icon
		driver.findElement(By.id("gsri_ok0")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(
				                             By.id("spchb")));
		//Send voice(FreeTTS+mbrola+VB-cable driver)
		System.setProperty("mbrola.base","E:\\batch241\\mbrola");
		VoiceManager vm=VoiceManager.getInstance();    
		Voice v=vm.getVoice("mbrola_us1");
		v.allocate();
		v.speak(x);
		v.deallocate();
		

	}

}




