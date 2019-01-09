package stevejobs;

import java.util.Scanner;

public class Test91 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter credit card type");
		String cc=sc.nextLine();
		switch(cc)
		{
			case "visa":
				System.out.println("Valid card");
				break;
			case "rupay":
				System.out.println("Valid card");
				break;
			case "master":
				System.out.println("Valid card");
				break;
			default:
				System.out.println("Wrong type");
				break;	
		}
	}
}







