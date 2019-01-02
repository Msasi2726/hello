package taining;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Scanner;
public class Test42 
{
	public static void main(String[] args) throws Exception 
	{
		Scanner sc=new Scanner(System.in);
        System.out.println("Enter input1");
        String x=sc.nextLine();
        System.out.println("Enter input2");
        String y=sc.nextLine();
        //Launch calculator
        Runtime.getRuntime().exec("calc.exe");
        Thread.sleep(3000);
        //send input1 calculator window
        StringSelection sx=new StringSelection(x);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sx, null);
        Robot r=new Robot();
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(3000);
        //perform
        r.keyPress(KeyEvent.VK_ADD);
        r.keyRelease(KeyEvent.VK_ADD);
        Thread.sleep(3000);
        //Send input2 calculator window
        StringSelection sy=new StringSelection(y);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sy, null);
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(3000);
        //perform =
        r.keyPress(KeyEvent.VK_EQUALS);
        r.keyRelease(KeyEvent.VK_EQUALS);
        Thread.sleep(3000);
        //Get output
        r.keyPress(KeyEvent.VK_CONTEXT_MENU);
        r.keyRelease(KeyEvent.VK_CONTEXT_MENU);
        Thread.sleep(3000);
        r.keyPress(KeyEvent.VK_DOWN);
        r.keyRelease(KeyEvent.VK_DOWN);
        Thread.sleep(3000);
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        String z=(String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        System.out.println(z);
        //close
        r.keyPress(KeyEvent.VK_ALT);
        r.keyPress(KeyEvent.VK_F4);
        r.keyRelease(KeyEvent.VK_F4);
        r.keyRelease(KeyEvent.VK_ALT);
        //shutdown
        r.keyPress(KeyEvent.VK_WINDOWS);        
        r.keyRelease(KeyEvent.VK_WINDOWS); 
        Thread.sleep(2000);
        for(int i=1;i<=2;i++)
        {
        r.keyPress(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_TAB);
        }
        r.keyPress(KeyEvent.VK_ENTER);        
        r.keyRelease(KeyEvent.VK_ENTER);
	}
}
