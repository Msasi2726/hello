package revision;

public class Rev2 
{
	public static void main(String[] args) throws Exception
	{
	 //starting
     Sample1 obj=new Sample1();
     obj.lunch("http:\\www.gmail.com");
     obj.waiting("//*[@id='identifierId']");
     obj.max();
     obj.find("//*[@id='identifierId']", "msasikiran225");
     obj.click("//span[text()='Next']");
     obj.waiting("//*[@name='password']");
     obj.find("//*[@name='password']","Ms@si2726");
     obj.click("//span[text()='Next']");
     Thread.sleep(30000);
     obj.close();
	}
}
