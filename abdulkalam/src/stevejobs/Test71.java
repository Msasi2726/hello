package stevejobs;

import java.util.Iterator;

import org.sikuli.script.Match;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

public class Test71
{
	public static void main(String[] args) throws Exception
	{
		Screen s=new Screen();
		s.click("minimize.png");
		Thread.sleep(5000);
		/*Iterator<Match> e=s.findAll("maximize.png");
		e.next();
		e.next().click(); */
		Region r=new Region(100,100,700,700);
		r.click("maximize.png");

	}

}





