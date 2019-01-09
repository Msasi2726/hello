package stevejobs;
public class Sample12
{
	public int add()
	{
		int x,y,z;
		x=10;
		y=20;
		z=x+y;
		return(z);
	}
	public int add(int a)
	{
		int x,y,z;
		x=a;
		y=20;
		z=x+y;
		return(z);
	}
	public int add(int a, int b)
	{
		int x,y,z;
		x=a;
		y=b;
		z=x+y;
		return(z);
	}
	public int add(int a, float b)
	{
		int x,z;
		float y;
		x=a;
		y=b;
		z=(int) (x+y);
		return(z);
	}
}


