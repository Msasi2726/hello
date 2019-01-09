package stevejobs;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
public class Test66
{
	public static void main(String[] args) throws Exception 
	{
		//Launch calculator software
		Runtime.getRuntime().exec("calc.exe");
		Thread.sleep(5000);
		//Send input1 to clip-board
		StringSelection x=new StringSelection("345");
		Toolkit.getDefaultToolkit().getSystemClipboard()
		                                  .setContents(x,null);
		//send clip-board data to window
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		//Click +
		r.keyPress(KeyEvent.VK_ADD);
		r.keyRelease(KeyEvent.VK_ADD);
		Thread.sleep(5000);
		//Send input2 to clip-board
		StringSelection y=new StringSelection("5467");
		Toolkit.getDefaultToolkit().getSystemClipboard()
		                                  .setContents(y,null);
		//send clip-board data to window
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		//Click =
		r.keyPress(KeyEvent.VK_EQUALS);
		r.keyRelease(KeyEvent.VK_EQUALS);
		Thread.sleep(5000);
		//Get output
		r.keyPress(KeyEvent.VK_CONTEXT_MENU);
		r.keyRelease(KeyEvent.VK_CONTEXT_MENU);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		String z=(String) Toolkit.getDefaultToolkit()
				 .getSystemClipboard().getData(
						 DataFlavor.stringFlavor);
		System.out.println(z);
		//Close window
		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_F4);
		r.keyRelease(KeyEvent.VK_F4);
		r.keyRelease(KeyEvent.VK_ALT);
	}
}
