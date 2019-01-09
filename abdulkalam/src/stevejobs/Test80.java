package stevejobs;

public class Test80
{
	public static void main(String[] args) 
	{
		//create obj to interface with help of concrete
		Sample5 obj1=new Sample6();
		int r1=obj1.add(20, 80);
		System.out.println(r1);
		//create obj to concrete class
		Sample6 obj2=new Sample6();
		int r2=obj2.add(20, 80);
		System.out.println(r2);
	}
}




