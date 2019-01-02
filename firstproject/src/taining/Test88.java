package taining;

import java.util.Scanner;

public class Test88 
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number");
		String cc=sc.nextLine();
		 switch(cc)
		 {
		 case "visa":
			 System.out.println("valid card");
			 break;
		 case "master":
			 System.out.println("valid card");
			 break;
		 case "american":
			 System.out.println("valid card");
			 break;
		 default:
			 System.out.println("Wrong card");
			 break;
		 }
	}
}
