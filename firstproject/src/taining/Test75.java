package taining;

import java.util.Scanner;

public class Test75 
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter limit");
		int x=sc.nextInt();
		//print pyramid
		int n=x;
		int k=2*n;
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<k;j++)
			{
				System.out.print(" ");
			}
			k=k-1;		
			for(int j=0;j<=i;j++)
			{
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
}
