package project2;

import org.sikuli.script.Screen;

public class OCR 
{
	public static void main(String[] args) throws Exception 
	{
		Screen s=new Screen();
		String x=s.find("login.png").text();
		System.out.println(x);
	}

}
