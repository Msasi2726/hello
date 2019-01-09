package stevejobs;
import java.util.Scanner;
public class Test105 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter voter age");
		int x=sc.nextInt();
		if(x<18)
		{
			ArithmeticException obj=new 
				ArithmeticException("invalid to vote");
			throw obj;
		}
		else
		{
			System.out.println("valid to vote");
		}
	}
}








