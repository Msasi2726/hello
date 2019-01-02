package taining;

public class Java6 
{
	public static void main(String[] args) 
	{
		//create object in interface class
		Sample6 obj=new Sample7();
		int a=obj.add(12, 20);
		System.out.println(a);
        //create object to concrete class
	    Sample7 obj1=new Sample7();
	    int b=obj1.add(12,20);
	    System.out.println(b);
	}
}
