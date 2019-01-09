package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test7 
{
	public static void main(String[] args) throws InterruptedException 
	{
		//Launch site using chrome
		System.setProperty("webdriver.chrome.driver",
				"E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		Thread.sleep(5000);
		driver.get("http://newtours.demoaut.com");
		Thread.sleep(5000);
		//Click register link
		driver.findElement(By.linkText("REGISTER")).click();
		Thread.sleep(5000);
		//Fill registration page
		driver.findElement(By.name("firstName"))
		                                   .sendKeys("abdul");
		driver.findElement(By.name("lastName"))
		                                    .sendKeys("kalam");
		driver.findElement(By.name("phone"))
		                               .sendKeys("9000624323");
		driver.findElement(By.name("userName"))
		                       .sendKeys("apj@abdulkalam.com");
		driver.findElement(By.name("address1"))
		                            .sendKeys("Mosque street");
		driver.findElement(By.name("address2"))
		                          .sendKeys("Dhanushkoti road");
		driver.findElement(By.name("city"))
		                               .sendKeys("Rameshwaram");
		driver.findElement(By.name("state"))
		                                 .sendKeys("Tamilnadu");
		driver.findElement(By.name("postalCode"))
		                                    .sendKeys("600032");
		//Drop-down automation
		WebElement e=driver.findElement(By.name("country"));
		Select s=new Select(e);
		s.selectByVisibleText("INDIA");
		//Automate further elements
		driver.findElement(By.name("email")).sendKeys("apj11");
		driver.findElement(By.name("password"))
		                                 .sendKeys("batch241");
		driver.findElement(By.name("confirmPassword"))
		                                 .sendKeys("batch241");
		driver.findElement(By.name("register")).click();
		Thread.sleep(5000);
		//Close site
		driver.close();
	}
}




