package taining;

import java.util.Scanner;

public class Test79
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
				System.out.print(j);
				if(j!=0)  //Start with "0" its required
				{
				if(j==i)
				{
					System.out.print(j+1);
					j++;
					i++;
				}
				}
			}
			System.out.println();
		}
	}
}
