package com.economizate.servicios;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public abstract class BaseParser {

	protected String FileName; 
	
	public BaseParser() 
    { 
        //Results = new List<IEmployeeResult>(); 
    } 
    
    public BaseParser(String FileName) 
    { 
        this.FileName = FileName; 
    } 
    
    public String Delimiter; 

    public String Read() throws IOException 
    { 
    	String content = null;
	    File file = new File(FileName); // For example, foo.txt
	    FileReader reader = null;
	    try {
	        reader = new FileReader(file);
	        char[] chars = new char[(int) file.length()];
	        reader.read(chars);
	        content = new String(chars);
	        reader.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        if(reader != null){
	            reader.close();
	        }
	    }
	    return content;
    } 
   

   //public  List<IEmployeeResult> Results { get; set; } 

	
}
