package stevejobs;

import java.util.Scanner;

public class Test109
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a line of text");
		String x=sc.nextLine();
		String[] y=x.split("a");
		for(int i=0;i<y.length;i++)
		{
			System.out.println(y[i]);
		}
	}

}






