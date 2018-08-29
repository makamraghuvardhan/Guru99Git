package com.org.webApplication.Framework;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.JXLException;
import jxl.Sheet;
import jxl.Workbook;
	
	public class ReadExcelData extends InitializeBrowser {
	    public File inputWorkbook;
	    public Sheet sheet;
	    public ReadExcelData(String sheetname) throws JXLException, IOException
	    {
	        inputWorkbook = new File("/home/raghu/eclipse-workspace/Framework/testdata.xls");
	        Workbook w;
	        inputWorkbook.getAbsoluteFile();
	        w = Workbook.getWorkbook(inputWorkbook);
	        sheet =w.getSheet(sheetname);
	    }
	   public String readData(int i,int j)
	   {
	        Cell cell=sheet.getCell(i, j);
	        return cell.getContents();
	   }
}


