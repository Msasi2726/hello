package stevejobs;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
public class Test8
{
	public static void main(String[] args) throws InterruptedException
	{
		//Launch gmail site
		System.setProperty("webdriver.chrome.driver",
				"E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		Thread.sleep(5000);
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		//Do login
		driver.findElement(By.name("identifier"))
		                            .sendKeys("gvraman167");
		driver.findElement(By.xpath("//*[text()='Next']"))
		                            .click();
		Thread.sleep(5000);
		driver.findElement(By.name("password"))
		                                .sendKeys("rams@5559");
		driver.findElement(By.xpath("//*[text()='Next']"))
										.click();
		Thread.sleep(5000);
		//click compose
		driver.findElement(By.xpath("//*[text()='Compose']"))
		                                              .click();
		Thread.sleep(5000);
		//Fill compose
		driver.findElement(By.name("to"))
		                       .sendKeys("apj@abdulkalam.com");
		driver.findElement(By.name("subjectbox"))
		                                   .sendKeys("Wishes");
		driver.findElement(By.xpath(
			"(//*[@aria-label='Message Body'])[2]"))
		   .sendKeys("Hi sir,\nHow are you in heaven?\nBye");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='bBe']"))
		                                            .click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(
			   "//*[contains(@data-tooltip,'Send')]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath(
		  "//*[contains(@aria-label,'Google Account')]/span"))
		                                            .click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Sign out")).click();
		Thread.sleep(5000);
		//close site
		driver.close();
	}

}






