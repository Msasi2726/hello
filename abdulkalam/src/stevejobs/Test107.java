package stevejobs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test107
{
	public static void main(String[] args)
	{
		String x="vjXDFRhc $90 jbRAMd$34 kbYUTIbv 12345";
		Pattern p=Pattern.compile("[0-9]+");
		Matcher m=p.matcher(x);
		while(m.find())
		{
			System.out.println(m.group());
		}
	}
}






