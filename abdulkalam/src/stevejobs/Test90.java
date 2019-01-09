package stevejobs;

import java.util.Scanner;

public class Test90
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter marital status(y/n)");
		String l=sc.nextLine();
		char x=l.charAt(0); //0 means first char
		switch(x)
		{
			case 'y':
				System.out.println("Married");
				break;
			case 'n':
				System.out.println("Unmarried");
				break;
			default:
				System.out.println("Wrong question");
				break;
		}
	}
}







