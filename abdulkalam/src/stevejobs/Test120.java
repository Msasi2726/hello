package stevejobs;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Test120 
{
	public static void main(String[] args) 
			                         throws Exception
	{
		//Open .xls file for test data reading
		File f=new File("w2smstestdata.xls");
		Workbook rwb=Workbook.getWorkbook(f);
		Sheet rsh=rwb.getSheet(0); //0 means Sheet1
		int nour=rsh.getRows(); //count of used rows
		//Open same excel file for results writing
		WritableWorkbook wwb=Workbook.createWorkbook(f,rwb);
		WritableSheet wsh=wwb.getSheet(0); //0 means Sheet1
		//Create results col, which is next to last used col
		int nouc=rsh.getColumns();
		SimpleDateFormat sf=
			 new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		Date d=new Date();
		String colname=sf.format(d);
		Label l=new Label(nouc,0,colname);
		wsh.addCell(l);
		//Data driven testing
		//1st row(index is 0) have columns names
		ChromeDriver driver=null;
		WritableFont wf=null;
		WritableCellFormat cf=null;
		//Common decorations for test passed
		wf=new WritableFont(WritableFont.ARIAL,15,
	               WritableFont.BOLD);
		wf.setColour(Colour.GREEN);
		cf=new WritableCellFormat(wf);
		cf.setAlignment(Alignment.JUSTIFY);
		cf.setWrap(true);
		for(int i=1;i<nour;i++)
		{
			String mbno=rsh.getCell(0,i).getContents();
			String mbnoc=rsh.getCell(1,i).getContents();
			String pwd=rsh.getCell(2,i).getContents();
			String pwdc=rsh.getCell(3,i).getContents();
			try
			{
				//Launch site
				System.setProperty("webdriver.chrome.driver",
			               "E:\\batch241\\chromedriver.exe");
				driver=new ChromeDriver();
				driver.get("http://www.way2sms.com");
				WebDriverWait w=new WebDriverWait(driver,20);
				w.until(ExpectedConditions
						.visibilityOfElementLocated(
						             By.name("mobileNo")));
				driver.manage().window().maximize();
				//Do login
				driver.findElement(By.name("mobileNo"))
				                           .sendKeys(mbno);
				driver.findElement(By.name("password"))
				                           .sendKeys(pwd);
				driver.findElement(By.xpath(
				  "(//button[contains(text(),'Login')])[1]")).click();
				Thread.sleep(5000);
				//Validations
				if(mbno.length()==0 && driver.findElement(By.xpath(
				      "//*[text()='Enter your mobile number']"))
						                         .isDisplayed())
				{
					Label l1=new Label(nouc,i,
							        "Blank mobile number test passed");
					l1.setCellFormat(cf);				
					wsh.addCell(l1);
				}
				else if(mbno.length()<10 && driver.findElement(
				  By.xpath("//*[text()='Enter valid mobile number']"))
                                                       .isDisplayed())
				{
					Label l2=new Label(nouc,i,
							  "Wrong size mobile number test passed");
					l2.setCellFormat(cf);
					wsh.addCell(l2);
				}
				else if(pwd.length()==0 && driver.findElement(By.xpath(
				   "(//*[text()='Enter password'])[2]")).isDisplayed())
				{
					Label l3=new Label(nouc,i,
							        "Blank password test passed");
					l3.setCellFormat(cf);
					wsh.addCell(l3);
				}
				else if(mbnoc.equalsIgnoreCase("invalid") &&
						driver.findElement(By.xpath(
				 "(//*[contains(text(),'not register with us')])[1]"))
						                               .isDisplayed())
				{
					Label l4=new Label(nouc,i,
							          "Invalid mobileno test passed");
					l4.setCellFormat(cf);
					wsh.addCell(l4);
				}
				else if(mbnoc.equalsIgnoreCase("valid") &&
					pwdc.equalsIgnoreCase("invalid") &&
					driver.findElement(By.xpath(
					"(//*[contains(text(),'Try Again')])[1]"))
					.isDisplayed())
				{
					Label l5=new Label(nouc,i,
							         "Invalid Pwd test passed");
					l5.setCellFormat(cf);
					wsh.addCell(l5);
				}
				else if(mbnoc.equalsIgnoreCase("valid") &&
						pwdc.equalsIgnoreCase("valid") &&
						driver.findElement(By.xpath(
						"//*[text()='SendSMS']")).isDisplayed())
				{
					Label l6=new Label(nouc,i,"Valid data test passed");
					l6.setCellFormat(cf);
					wsh.addCell(l6);
				}
				else
				{
					//Get screenshot
					String fname=sf.format(d)+".png";
					File src=driver.getScreenshotAs(OutputType.FILE);
					File dest=new File(fname);
					FileHandler.copy(src,dest);
					//Separate decorations for test failed
					Label l7=new Label(nouc,i,
							"Login test failed and see "+fname);
					wf=new WritableFont(WritableFont.COURIER,20,
				               WritableFont.BOLD);
					wf.setColour(Colour.RED);
					cf=new WritableCellFormat(wf);
					cf.setAlignment(Alignment.JUSTIFY);
					cf.setWrap(true);
					l7.setCellFormat(cf);
					wsh.addCell(l7);
				}
				//close site
				driver.quit();
			}
			catch(Exception ex)
			{
				driver.quit();
			Label l8=new Label(nouc,i,ex.getMessage());
				wsh.addCell(l8);
			}
		}
		//Save excel file
		wwb.write(); //save
		rwb.close();
		wwb.close();
	}
}






