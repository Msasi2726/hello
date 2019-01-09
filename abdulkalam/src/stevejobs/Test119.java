package stevejobs;
import java.io.File;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
public class Test119
{
	public static void main(String[] args) 
			                           throws Exception
	{
		//Open ".xls" file for reading
		File f=new File("book1.xls");
		Workbook rwb=Workbook.getWorkbook(f);
		Sheet rsh=rwb.getSheet(0); //0 means Sheet1
		int nour=rsh.getRows(); //count of used rows
		//Open same excel file for writing
		WritableWorkbook wwb=Workbook.createWorkbook(f,rwb);
		WritableSheet wsh=wwb.getSheet(0); //0 means Sheet1
		//Data driven from 2nd row(index is 1)
		//1st row(index is 0) have names of columns 
		for(int i=1;i<nour;i++)
		{
			int x=Integer.parseInt(
					    rsh.getCell(0,i).getContents());
			int y=Integer.parseInt(
					    rsh.getCell(1,i).getContents());
			int z=x+y;
			Number n=new Number(2,i,z); 
			WritableFont wf=new WritableFont(WritableFont.COURIER,
					                        20,WritableFont.BOLD);
			wf.setColour(Colour.BLUE);
			WritableCellFormat cf=new WritableCellFormat(wf);
			cf.setAlignment(Alignment.JUSTIFY);
			cf.setWrap(true);
			cf.setBackground(Colour.GREEN);
			n.setCellFormat(cf);
			wsh.addCell(n);
		}
		//Save excel file
		wwb.write(); //save
		rwb.close();
		wwb.close();	
	}
}






