package taining;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Test67 
{
	public static void main(String[] args) throws Exception 
	{
		//Take Expected color
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Expected color in RGB");
		int r=sc.nextInt();
		int g=sc.nextInt();
		int b=sc.nextInt();
		Color ec=new Color(r,g,b);
        int count=0;
        float Percentage;
        File f=new File("photo.PNG");
        BufferedImage fullimg=ImageIO.read(f);
        //check image color pixel by pixel
        int w=fullimg.getWidth();
        int h=fullimg.getHeight();
        for(int i=0;i<w;i++)
        {
        	for(int j=0;j<h;j++)
        	{
        		Color ac=new Color(fullimg.getRGB(i,j));
        		if(ac.getRed()==ec.getRed()&&ac.getGreen()==ec.getGreen()&&ac.getBlue()==ec.getBlue())
        		{
        			count=count+1;
        		}
        	}
        }
        System.out.println("Total pixels:"+"  "+(w*h)); 
        System.out.println("Expected color pixels:"+"  "+count);
        Percentage=(count*100)/(w*h);
        System.out.println("Expected color Percentage is:"+"  "+Percentage);
	}
}
