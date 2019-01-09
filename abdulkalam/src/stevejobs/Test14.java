package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test14
{
	public static void main(String[] args) throws Exception
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
				"E:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.mercurytravels.co.in/");
		Thread.sleep(5000);
		//Validate a radio button
		driver.findElement(By.partialLinkText("Flights"))
		                                            .click();
		Thread.sleep(5000);
		try
		{
		   WebElement e=driver.findElement(By.name("tripType"));
			if(e.isDisplayed())
			{
				System.out.println("Displayed");
				if(e.isEnabled())
				{
					System.out.println("Enabled");
					if(e.isSelected())
					{
						System.out.println("Selected");
					}
					else
					{
						System.out.println("Not Selected");
					}
				}
				else
				{
					System.out.println("Disabled");
				}
			}
			else
			{
				System.out.println("Hidden");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		//close site
		driver.close();
		

	}

}
