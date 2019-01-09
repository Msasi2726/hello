package stevejobs;

import org.sikuli.script.Button;
import org.sikuli.script.Screen;

public class Test70
{
	public static void main(String[] args) throws Exception
	{
		Screen s=new Screen();
		s.click("minimize.png");
		Thread.sleep(5000);
		s.click("register.png");
		Thread.sleep(5000);
		s.wheel(Button.MIDDLE,5);
		Thread.sleep(5000);
		s.click("ok.png");
		Thread.sleep(5000);
		s.wheel(Button.WHEEL_UP,5);
		

	}

}





