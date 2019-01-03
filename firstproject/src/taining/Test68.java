package taining;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Test68 
{
	public static void main(String[] args) throws Exception 
	{
		//Get count of unique colors in given image
		System.out.println("hi");
		File pic=new File("photo.PNG");
		BufferedImage fullimg=ImageIO.read(pic);
		ArrayList<String> colors=new ArrayList<String>();
		//check color pixel
		for(int i=0;i<fullimg.getWidth();i++)
		{
			for(int j=0;j<fullimg.getHeight();j++)
			{
				int flag=0;
				Color ac=new Color(fullimg.getRGB(i,j));
				String temp=ac.getRed()+" "+ac.getGreen()+" "+ac.getBlue();
				for(int k=0;k<colors.size();k++)
				{
					if(temp.equals(colors.get(k)))
					{
						flag=1;
					}
				}
				if(flag==0)
				{
					colors.add(temp);
				}
			}
		}
		//Existing colors are
		System.out.println("Unique colors count:"+"  "+colors.size());
		//check existing colors percentage
		for(int i=0;i<colors.size();i++)
		{
			int count=0;
			for(int j=0;j<fullimg.getWidth();j++)
			{
				for(int k=0;k<fullimg.getHeight();k++)
				{
					Color ac=new Color(fullimg.getRGB(j,k));
					String temp=ac.getRed()+" "+ac.getGreen()+" "+ac.getBlue();
					if(temp.equals(colors.get(i)))
					{
						count=count+1;
					}
				}
			}
			System.out.println(colors.get(i)+" for "+count);
		}		
	}
}
