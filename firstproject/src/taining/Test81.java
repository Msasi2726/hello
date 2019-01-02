package taining;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test81
{
	public static void main(String[] args) throws Exception 
	{
		//Take a word from keyboard 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a word");
		String x=sc.nextLine();
		//Selenium
		System.setProperty("webdriver.chrome.driver","H:\\Selenium\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//launch site
		driver.get("http://www.google.co.in");
		WebDriverWait wait=new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		//maximize
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys(x,Keys.ENTER);
		//count no.of results pages
		int count=1;
		while(2>1)
		{
		try
		{
			if(driver.findElement(By.xpath("//span[text()='Next']")).isDisplayed())
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Next']")));
				driver.findElement(By.xpath("//span[text()='Next']")).click();
				count=count+1;
			}
		}
		catch(Exception ex)
		{
			break;
		}
		}
		//output
		System.out.println(count);
		//close site
		Thread.sleep(10000);
		driver.close();
	}

}
