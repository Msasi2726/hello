package stevejobs;

import java.util.Scanner;

public class Test101
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a string");
		String x=sc.nextLine();
		String z="";  //null
		for(int i=x.length()-1;i>=0;i--)
		{
			char y=x.charAt(i);
			z=z+y;
		}
		System.out.println(z);
		if(x.equals(z))
		{
			System.out.println("Palindrome");
		}
		else
		{
			System.out.println("not Palindrome");
		}
	}
}







