package stevejobs;
public class Sample9
{
	public int x;
	private Sample9()
	{
		x=10;
	}
	public static Sample9 create()
	{
		Sample9 obj1=new Sample9();
		return(obj1);	
	}
	public void display()
	{
		System.out.println(x);
	}
}


