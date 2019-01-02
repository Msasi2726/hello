package project2;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Syntaxes 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","H:\\\\Selenium\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//Date 8-6-2018
		driver.findElement(By.name("xxxx"));
		driver.findElement(By.id("xxxx"));
		driver.findElement(By.className("xxxxx"));
		driver.findElement(By.tagName("xxxxx"));
		driver.findElement(By.linkText("xxxx"));
		driver.findElement(By.partialLinkText("xxxxx"));
		driver.findElement(By.cssSelector("xxxx"));
		driver.findElement(By.xpath("xxxx"));
		/*types of xpaths
		kind 1
		//tagname[@attribute='value']
		kind 2
		//*[@attribute='value']
		kind 3
		//*[@attribute='value'][@attribute='value']
		kind 4
		//*[contains(@attribute,'part of value')] 
		kind 5
		//*[starts-with(@attribute,'starting value')]
		kind 6
		//*[text()='XXXX']
		kind 7
		(//*[@attribute='value'])[index]
		kind 7-1
		(//*[@attribute='value'])[last()]
        kind 7-2
        (//*[@attribute='value'])[last()-1]
        kind 8
        ((//*[@attribute='value'])[index])|(//*[contains(@attribute,'part of value')] )
        kind 9
        //*[contains(text(),'part of value')orcontains(text(),'part of value')]
        kind 10
        //*[@attribute='value']/child::*
        kind 11
        //*[@attribute='value']/parent::*
        kind 12
        //*[@attribute='value']/child::*[index]
        kind 13
        //*[@attribute='value']/preceding::*[index]
        kind 14
        //*[@attribute='value']/preceding-sibling::*[index]
        kind 15
        //*[@attribute='value']/following::*[index]
        kind 16
        //*[@attribute='value']/following-sibling::*[index]
        kind 17
        //*[@attribute='value']/ancestor::*[index]
        kind 18
        //*[@attribute='value']/descendant::*[index]
         */
		//open webpage
        driver.get(url);
        //close active page
        driver.close();
        //close all pages in active browser
        driver.quit();
        //to findElement
        driver.findElement(arg0);
        //Click Operation 
        driver.findElement(arg0).click();
        //Sendkeys to page
        driver.findElement(arg0).sendkeys();
        //Clear data
        driver.findElement(arg0).clear();
        //Get tittle
        driver.getTitle();
        //To get secured browser or not
        driver.getCurrentUrl();
        //get page source
        driver.getPageSource();
        //Get Attribute
        driver.findElement(arg0).getAttribute('attribute');
        //Get text
        driver.findElement(arg0).getText();
        //Get css value
        driver.findElement(arg0).getCssValue();
        //Frame concept
        driver.switchTo().frame(arg0);
        or
        WebElement e=driver.findElement(By.xpath(xpathExpression));
        driver.switchTo().frame(e);
        or 
        driver.switchTo().frame(0);
        //back to main
        driver.switchTo().defaultContent();
        or
        driver.switchTo().parentFrame();
        //window
        driver.switchTo().window(arg0);
        //Array list
        ArrayList<String> x=new ArrayList<String>(driver.getWindowHandle());
        //switch to back
        driver.switchTo().window(x.get(0));
        //switch to 3rd window
        driver.switchTo().window(x.get(2));
        //Alert
        driver.switchTo().alert();
        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
        driver.switchTo().alert().getText();
        driver.switchTo().alert().sendKeys(arg0);
        driver.switchTo().activeElement();
        //navigate
        driver.navigate().to(arg0); 
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.findElement(arg0).isDisplayed();
        driver.findElement().isEnabled();
        driver.findElement(arg0).isSelected();
        //window
        driver.manage().window().maximize();
        driver.manage().window().getSize();
        driver.manage().window().setSize(arg0);
        driver.manage().window().getPosition();
        driver.manage().window().setPosition(arg0);
        //Get width and height
        int a=driver.manage().window().getSize().getWidth();
        int b=driver.manage().window().getSize().getHeight();
        System.out.println(a+"  "+b);
        //change size
        Dimension c=new Dimension(10,20);
        driver.manage().window().setSize(d);
        //Get position
        int c=driver.manage().window().getPosition().getX();
        int d=driver.manage().window().getPosition().getY();
        System.out.println(c+"  "+d);
        //Change position
        Point e=new Point(10,20);
        driver.manage().window().setPosition(p);
        //wait
        driver.manage().timeouts().implicitlyWait(driver, TimeUnit.SECONDS);
        //Cookies
        driver.manage().deleteAllCookies();
        driver.manage().getCookies().size();
        //more than one elements
        driver.findElements(arg0);
        //list
        List<WebElement> f=driver.findElements(arg0);
        System.out.println("count of elements"+ f.size());
        //getScreenshotAs
        File src=driver.getScreenshotAs(OutputType.FILE);
        File dest=new File("path of file");
        FileUtils.copyFile(src, dest);
        //Get Options
        WebElement g=driver.findElement(arg0);
        Select h=new Select(g);
        List<WebElement> i=h.getOptions();
        System.out.println(i.size());
        //selectByVissibleText
        h.selectByVisibleText(arg0);
        //selectByValue
        h.selectByValue(arg0);
        //selectByIndex
        h.selectByIndex(arg0);
        //Single select and Multiple Select
        h.getOptions();
        h.isMultiple();
        //Single select
        h.selectByIndex(arg0);
        h.selectByValue(arg0);
        h.selectByVisibleText(arg0);
        //Multiple select
        h.deselectByIndex(arg0);
        h.deselectByValue(arg0);
        h.deselectByVisibleText(arg0);
        h.getFirstSelectedOption();
        h.getAllSelectedOptions();
        h.deselectAll();
        //Actions 
        Action i=new Action(driver);
        WebElement g=driver.findElement(arg0);
        //click
        i.click(g).build().perform();
        //sendkeys
        i.sendkeys(g,"xxxx").build().perform();
        //doubleclick
        i.doubleclick(g).build().perform();
        //rightclick
        i.contextclick(g).build().perform();
        //movetoelement
        i.moveToElement(g).build().perform();
        //getLocation
        int j=e.getLocation().getX();
        int k=e.getLocation().getY();
        i.moveByOffset(j,k).build().perform();
        //Slider by x direction
        i.dragAndDropby(g,100,0).build().perform();
        i.dragAndDropby(g,-100,0).build().perform();
        //Slider by y direction
        i.dragAndDropby(g,0,100).build().perform();
        i.dragAndDropby(g,0,-100).build().perform();
        //Scanner 
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter value from keyboard");
        String l=sc.nextLine();
		}
}
