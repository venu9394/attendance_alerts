package com.hetero;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;  
public class Statements {  
	
	static Statement st=null;
public static int ExcelStatements (String NAME,Statement st)throws Exception{  
	
	 //in i=0;
	int cout=0;
	
    FileReader reader=new FileReader("src//db.properties");  
      
    Properties p=new Properties();  
    p.load(reader);  
      
  //  System.out.println(p.getProperty("ArrearReport"));  
   // System.out.println(p.getProperty("password")); 
    
      String Query="";
      
      
      
      Query= p.getProperty(NAME);
      
	
      System.out.println(NAME+"------>"+Query.toString());
try {
    
	  
      ResultSet rs = st.executeQuery(Query.toString());
      
     /* if(NAME.equalsIgnoreCase("LOPReport"))
      {
    	  st.setString(1, "201901");
    	  st.setString(2, "MUM");
      }
      else if ()
      {
    	  
    	   
      }*/
      
      
     /* st.setString(2, "201901");
      st.setString(3, "201901");*/
    
    //ResultSet rs = st.executeQuery();
    HSSFWorkbook workbook = new HSSFWorkbook();
    HSSFSheet sheet = workbook.createSheet("MasterData");
    HSSFRow rowhead = sheet.createRow((short) 0);
    ///
    CellStyle style = workbook.createCellStyle();
    Font font = workbook.createFont();
    font.setFontHeightInPoints((short)10);
   /* font.setFontName(HSSFFont.FONT_ARIAL);
    font.setBoldweight(HSSFFont.COLOR_NORMAL);*/
    
    font.setFontName ( "Calibri" );
    font.setBoldweight ( Font.BOLDWEIGHT_BOLD );
    font.setColor ( HSSFColor.RED.index );
    //font.setColor(HSSFColor.BLACK.index);
    style.setFont(font);
    //Add these lines     
   // style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
    /*style.setFillPattern(CellStyle.SOLID_FOREGROUND);*/
    style.setAlignment(CellStyle.ALIGN_CENTER);
    sheet.createFreezePane(0, 1); // Freeze 1st Row   sheet.createFreezePane(int colSplit, int rowSplit, int leftmostColumn, int topRow)
 
    CellStyle style1 = workbook.createCellStyle();
    Font font1 = workbook.createFont();
    font1.setFontHeightInPoints((short)10);
    font1.setFontName ( "Calibri" );
    font1.setColor ( HSSFColor.BLACK.index );
    
    style1.setFont(font1);
    style1.setFillForegroundColor(IndexedColors.WHITE.getIndex());
    
    ResultSetMetaData rsmd = rs.getMetaData();
    for (int i = 1; i <=rsmd.getColumnCount(); i++) 
    	
    { 
    	// rowhead.createCell((short) i-1).setCellValue(rsmd.getColumnName(i));
    	 rowhead.setRowStyle(style);
    	 //Set the cell0 Style        
    	 HSSFCell cell0 = rowhead.createCell(i-1);
    	 cell0.setCellStyle(style);
    	 cell0.setCellValue(rsmd.getColumnLabel(i));
    	 //Set the cell1 Style        
    }
     
    int i = 1;
    while (rs.next()){
        HSSFRow row = sheet.createRow((short) i);
        for (int j = 1; j <=rsmd.getColumnCount(); j++) 
	    { 
	    	 row.setRowStyle(style1);
	    	 HSSFCell cell0 = row.createCell(j-1);
	    	 cell0.setCellValue(rs.getString(j));
	    	 cell0.setCellStyle(style1);
	    }
        
        sheet.autoSizeColumn(i);
        i++;
    }
     
    String timeStamp = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss").format(Calendar.getInstance().getTime());
    
    String yemi = "C:/Users/sapproject/Desktop/Daily Attendance/MasterSheet/"+NAME+".xls";
    FileOutputStream fileOut = new FileOutputStream(yemi);
    workbook.write(fileOut);
    fileOut.close();
    System.out.println("Done....");
    
    } catch (SQLException e1) {
        e1.printStackTrace();
    } catch (FileNotFoundException e1) {
        e1.printStackTrace();
    } catch (IOException e1) {
        e1.printStackTrace();
    }
return cout;


}


public static void main(String []args) throws Exception

{
	Connection con = null;
	
try {
	
	//String Type="";
    
	  con = Util.getConnection();
      st = con.createStatement();
      
	ArrayList<String> al=new ArrayList<String>();
      
     al.add("MasterSheet_Promoters");
     al.add("MasterSheet_HYD");
   // al.add("MasterSheet");
      al.add("MasterSheet_MUM");
       
      //-----------------Statements--------------
      
      
      
      
   /*   al.add("JV_CODE_AZISTA");
      al.add("JV_CODE_AZISTA");
      al.add("JV_CODE_MUM");*/
      
       ///BANK STATENET
	  //al.add("PAYSHEET_Promoters");
     // al.add("Bank_Statement_Promoters");
      
      
    /*  if(Type.equa
     * lsIgnoreCase("Hyd_Payroll_Statemets"))
      {
    	  
      }*/
      
     
      	      
      int i=0;
      
      Iterator<String> itr=al.iterator();
      
      while(itr.hasNext())
      {
    	  String value=(String)itr.next();
    	  
    	    i=ExcelStatements(value,st);
      }
	
	 

} catch (SQLException e1) {
    e1.printStackTrace();
}  

finally
{
	   st.close();
	   con.close();
	   System.out.println("Connection closed....     ");
}

}
 
}  