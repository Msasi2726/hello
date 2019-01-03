package revision;

public class Rev3 
{
	public static void main(String[] args) throws Exception
	{
	 //start
     Sample2 obj=Sample2.create();
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
