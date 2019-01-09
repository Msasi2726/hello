package stevejobs;

public class Sample3
{
	//Data members
	public int x;
	public float y;
	public char z;
	public String w;
	public boolean b;
	//methods
	public Sample3() //Constructor method
	{
		x=10;
		w="kalam";
	}
	public Sample3(int a) //Constructor method
	{
		x=a;
		w="kalam";
	}
	public Sample3(float a) //Constructor method
	{
		y=a;
		w="kalam";
	}
	public Sample3(int a, String s) //Constructor method
	{
		x=a;
		w=s;
	}
	public void display() //Operational method
	{
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		System.out.println(w);
		System.out.println(b);	
	}
}

