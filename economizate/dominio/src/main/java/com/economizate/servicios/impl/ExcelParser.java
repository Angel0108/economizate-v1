package com.economizate.servicios.impl;

import java.io.File;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.economizate.servicios.BaseParser;

public class ExcelParser extends BaseParser {

	public ExcelParser() {
		super();
	}

	@Override
	public String Read() {
		try {

		        File f = new File( FileName );
		        Workbook wb = WorkbookFactory.create(f);
		        Sheet mySheet = wb.getSheetAt(0);
		        Iterator<Row> rowIter = mySheet.rowIterator();
		        for ( Iterator<Row> rowIterator = mySheet.rowIterator() ;rowIterator.hasNext(); )
		        {
		            for (  Iterator<Cell> cellIterator = ((Row)rowIterator.next()).cellIterator() ; cellIterator.hasNext() ;  ) 
		            {
		                System.out.println ( ( (Cell)cellIterator.next() ).toString() );
		            }
		            System.out.println( " **************************************************************** ");
		        }
		    } catch ( Exception e )
		    {
		        System.out.println( "exception" );
		        e.printStackTrace();
		    }
		return "";
	}

	@Override
	public String toString() {
		return ParserType.EXCEL.toString();
	}
}
