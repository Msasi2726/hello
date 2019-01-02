package taining;

import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.LoadLibs;

public class Test71 
{
	public static void main(String[] args) throws Exception 
	{
		//load Tessdata folder which have characters
		File fo=LoadLibs.extractTessResources("tessdata");
		//create object to apply OCR on image
		Tesseract obj=new Tesseract();
		obj.setDatapath(fo.getAbsolutePath());
		//obj.setLanguage("eng");
		//take screen shot file,which have text in content
		File F=new File("H:\\Selenium\\secondproject\\Cap.PNG");
		String result=obj.doOCR(F); 
		Thread.sleep(20000);
		System.out.println(result);
	}
}
   