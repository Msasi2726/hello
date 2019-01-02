package taining;

public class Sample4
{
	//Data members
	public int x;
	public float y;
	public char z;
	public boolean w;
	public String s;
	public Sample4()
	{
		x=10;
		s="mindq";
	}
	public Sample4(String temp)
	{
	   x=20;
	   s=temp;
	}
	public void display()
    {
	  System.out.println(x);
	  System.out.println(y);
	  System.out.println(z);
	  System.out.println(w);
	  System.out.println(s);
	}
}
