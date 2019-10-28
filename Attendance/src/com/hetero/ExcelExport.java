package com.hetero;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;

public class ExcelExport {
	
	static Statement st=null;
	
	public static int ExcelGenarate(String NAME,Statement st) throws SQLException
    {
		int i=0;
		int cout=0;
	
	try {
	    
		 
	    
	  //  StringBuffer BU =new StringBuffer();
	    
	   
	   
	  /* if(NAME.equalsIgnoreCase("Assam_Daily_Attendance"))
	   {
		   BU.append("CALL PROCEDURE.ATTENDANCE('15,16', '1001,1092,1401','2019-01-27',curdate()) ");
		  
	   }
	  // 
	    //HYD
	   else if(NAME.equalsIgnoreCase("HYD_Daily_Attendance"))
	   {
		   BU.append(" CALL procedure.Attendance((SELECT GROUP_CONCAT(BUSINESSUNITID) FROM hcladm_prod.tbl_businessunit where callname='HYD' AND BUSINESSUNITID NOT IN (15,16,17)), '1001,1092,1401','2019-01-27',curdate());  ");
	   }
	    /// Mumbai Attendance
	   else if(NAME.equalsIgnoreCase("Mumbai_Daily_Attendance"))
	   {
	    BU.append("CALL PROCEDURE.ATTENDANCE_MUM((SELECT GROUP_CONCAT(EMPLOYEESEQUENCENO) FROM HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY A JOIN HCLADM_PROD.TBL_COSTCENTER B ON A.COSTCENTERID=B.COSTCENTERID AND B.NAME='OFFICE' JOIN HCLADM_PROD.TBL_BUSINESSUNIT C ON B.BUSINESSUNITID=C.BUSINESSUNITID AND C.STATUS=1001 AND C.CALLNAME='MUM' ");
	    BU.append("WHERE A.STATUS=1001 and a.employeesequenceno not in(10160,10179,10182,10302,101194,106957,201550,204936) ),'2019-02-01',curdate()) ") ;
	   }
	   
	   else if(NAME.equalsIgnoreCase("Ahmedabad_Daily_Attendance"))
	   {
		   BU.append("CALL PROCEDURE.ATTENDANCE('17', '1001,1092,1401','2019-01-27',curdate()) ");  
	   
	   }*/
	   
	    ///
	    
	   ///Prasad
	   
	    
	   
	   
	   String Att_Query=ExcelExport.Query(NAME);
	    
	   
	   System.out.println(NAME+"------>"+Att_Query.toString());
	    
	    ResultSet rs = st.executeQuery(Att_Query.toString());
	    HSSFWorkbook workbook = new HSSFWorkbook();
	    HSSFSheet sheet = workbook.createSheet("Attendance");
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
	    style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
	    /*style.setFillPattern(CellStyle.SOLID_FOREGROUND);*/
	    style.setAlignment(CellStyle.ALIGN_CENTER);

	    
	        /*style.setBorderTop(HSSFCellStyle.BORDER_THIN);
	  		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	  		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
	  		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);*/
	    
	    
	    sheet.createFreezePane(0, 1); // Freeze 1st Row   sheet.createFreezePane(int colSplit, int rowSplit, int leftmostColumn, int topRow)

	    //
	    
	    CellStyle style1 = workbook.createCellStyle();
	    Font font1 = workbook.createFont();
	    font1.setFontHeightInPoints((short)10);
	   /* font.setFontName(HSSFFont.FONT_ARIAL);
	    font.setBoldweight(HSSFFont.COLOR_NORMAL);*/
	    
	    font1.setFontName ( "Calibri" );
	    //font1.setBoldweight ( Font.BOLDWEIGHT_BOLD );
	    font1.setColor ( HSSFColor.BLACK.index );
	    
	    //font.setColor(HSSFColor.BLACK.index);
         
	    style1.setFont(font1);
	    //Add these lines     
	    style1.setFillForegroundColor(IndexedColors.WHITE.getIndex());
//	    style1.setFillPattern(CellStyle.SOLID_FOREGROUND);
	  //  style1.setFillPattern(CellStyle.);
	    
	    /*style1.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style1.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style1.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style1.setBorderBottom(HSSFCellStyle.BORDER_THIN);*/
	    
	  //  style1.setAlignment(CellStyle.ALIGN_CENTER);
	    
	    ////
	    
	    ResultSetMetaData rsmd = rs.getMetaData();
	    
	    for (i = 1; i <=rsmd.getColumnCount(); i++) 
	    	
	    { 
	    	// rowhead.createCell((short) i-1).setCellValue(rsmd.getColumnName(i));
	    	 rowhead.setRowStyle(style);
	    	 //Set the cell0 Style        
	    	 HSSFCell cell0 = rowhead.createCell(i-1);
	    	 cell0.setCellStyle(style);
	    	 cell0.setCellValue(rsmd.getColumnLabel(i));
	    	 //Set the cell1 Style        
	    }
	    
 // ResultSetMetaData rsmd = rs.getMetaData();
	    
	   /* 
	    rowhead.createCell((short) 0).setCellValue("CellHeadName1");
	    rowhead.createCell((short) 1).setCellValue("CellHeadName2");
	    rowhead.createCell((short) 2).setCellValue("CellHeadName3");*/
	      i = 1;
	    
	    
	    while (rs.next()){
	        HSSFRow row = sheet.createRow((short) i);
	        
	        for (int j = 1; j <=rsmd.getColumnCount(); j++) 
		    	
		    { 
	        	
	        	//System.out.println(rsmd.getColumnName(j));
		    	// rowhead.createCell((short) i-1).setCellValue(rsmd.getColumnName(i));
		    	 
		    	 row.setRowStyle(style1);
		    	 //Set the cell0 Style        
		    	 HSSFCell cell0 = row.createCell(j-1);
		    	
		    	 cell0.setCellValue(rs.getString(j));
		    	 cell0.setCellStyle(style1);
		    	// System.out.println(rs.getString(j).getClass());
		    	  
		    	 //row.createCell((short) j-1).setCellValue(rs.getString(j));
		    	  
	        	/* row.createCell((short) j-1).setCellStyle(style1);
		    	 
		    	 row.createCell((short) j-1).setCellValue(rs.getString(j));*/
		    	// row.createCell((short) j-1).setCellStyle(style1);
		    	 
		    	// cell0.setCellValue(rs.getString(j));
		    	 //Set the cell1 Style        
		    	 
		    }
	       
	        
	        /*row.createCell((short) 0).setCellValue(rs.getString("FIRSTNAME"));
	        row.createCell((short) 1).setCellValue(rs.getString("LASTNAME"));
	        row.createCell((short) 2).setCellValue(rs.getString("CALLNAME"));*/
	        sheet.autoSizeColumn(i);
	        i++;
	    }
	    
	    
	    
	    
	    String yemi = "C:/Users/sapproject/Desktop/Daily Attendance/"+NAME+".xls";
	    FileOutputStream fileOut = new FileOutputStream(yemi);
	    workbook.write(fileOut);
	    fileOut.close();
	    System.out.println(NAME+"-----------> Done....");
	    
	    } catch (SQLException e1) {
	        e1.printStackTrace();
	    } catch (FileNotFoundException e1) {
	    	
	    	
	        e1.printStackTrace();
	    } catch (IOException e1) {
	        e1.printStackTrace();
	    }
	
	
	   
		
		return cout;
  	  
    }
	
	public static void main(String []args) throws SQLException

	{
		Connection con = null;
		
	try {
	    
		  con = Util.getConnection();
	      st = con.createStatement();
	      
		ArrayList<String> al=new ArrayList<String>();
	      
	      al.add("Assam_Daily_Attendance");
	      al.add("HYD_Daily_Attendance");
	      al.add("Mumbai_Daily_Attendance");
	      al.add("Ahmedabad_Daily_Attendance");
	      	      
	      int i=0;
	      
	      Iterator<String> itr=al.iterator();
	      
	      
	      while(itr.hasNext())
	      {
	    	  String value=(String)itr.next();
	    	  
	    	    i=ExcelGenarate(value,st);
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
	
	
	/*public static void DD(String[] args)throws Exception {
	      XSSFWorkbook workbook = new XSSFWorkbook(); 
	      XSSFSheet spreadsheet = workbook.createSheet("Fontstyle");
	      XSSFRow row = spreadsheet.createRow(2);

	      //Create a new font and alter it.
	      XSSFFont font = workbook.createFont();
	      font.setFontHeightInPoints((short) 30);
	      font.setFontName("IMPACT");
	      font.setItalic(true);
	      font.setColor(HSSFColor..index);

	      //Set font into style
	      XSSFCellStyle style = workbook.createCellStyle();
	      style.setFont(font);

	      // Create a cell with a value and set style to it.
	      XSSFCell cell = row.createCell(1);
	      cell.setCellValue("Font Style");
	      cell.setCellStyle(style);
	      
	      FileOutputStream out = new FileOutputStream(new File("fontstyle.xlsx"));
	      workbook.write(out);
	      out.close();
	      System.out.println("fontstyle.xlsx written successfully");
	   }*/
	
	public static String Query(String Type)
	{

		  // TODO Auto-generated method stub
		  List<Date> dates = new ArrayList<Date>();
		  
		  
		  
		  ///DATES
		    /*DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			System.out.println(dateFormat.format(cal)); //2016/11/16 12:08:43
*/
		  String str_date ="";
		  
		  if(Type.equalsIgnoreCase("Mumbai_Daily_Attendance"))
		  {
			  str_date ="2019-07-01";
			  
			  
		  }
		  else
		  {
			  str_date ="2019-06-26";
			  
		  }
		  
		  
		 // String end_date =dateFormat.format(cal).toString();
		  
		  String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		  String end_date =timeStamp;
		  
		  

		  DateFormat formatter ; 

		  formatter = new SimpleDateFormat("yyyy-MM-dd");
		  Date startDate = null;
		  try {
		   startDate = (Date)formatter.parse(str_date);
		  } catch (ParseException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  } 
		  Date endDate = null;
		  try {
		   endDate = (Date)formatter.parse(end_date);
		  } catch (ParseException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
		  long interval = 24*1000 * 60 * 60; // 1 hour in millis
		  long endTime =endDate.getTime() ; // create your endtime here, possibly using Calendar or Date
		  long curTime = startDate.getTime();
		  while (curTime <= endTime) {
		      dates.add(new Date(curTime));
		      curTime += interval;
		  }
		  
		  
		  
		  StringBuffer Sb=new StringBuffer();
		  
		   
		  Sb.append(" select k.employeesequenceno AS ID ,k.callname AS NAME,ST.NAME AS STATUS,DATE_FORMAT(HH.DATEOFJOIN,'%d-%m-%Y') AS DOJ, BU.name AS BU , DEP.CODE AS DEPT,G.NAME AS COST_CENTER, ");
		 
		  
		 // String Type="HYD";
		  
		  
	    //String Type="MUM";
	   // String Type="Assam";
		  
		 // String Type="AHMEDABAD";
		  
		  
		  //
		  
		 /* al.add("Assam_Daily_Attendance");
	      al.add("HYD_Daily_Attendance");
	      al.add("Mumbai_Daily_Attendance");
	      al.add("Ahmedabad_Daily_Attendance");*/
	      	      



		  for(int i=0;i<dates.size();i++){
		      Date lDate =(Date)dates.get(i);
		      String ds = formatter.format(lDate);    
		     // System.out.println(" Date is ..." + ds);
		      
		      //Sb.append(" IFNULL(max(if(a.dateon='"+ds+"' ,if(a.dateon=b.leaveon, b.leave_type ,concat(a.att_in,' || ',a.att_out))  ,'--' )) ,'A') AS '"+ds+"' " );
		      //Hyd All
		    // Sb.append(" IFNULL(MAX(CASE WHEN a.DATEON='"+ds+"' THEN IF(a.DAY_STATUS='P' , concat(a.ATT_IN,'||',a.ATT_OUT) , if(a.DAY_STATUS='A' AND a.DAYTYPE!='HL',if(dayname(a.DATEON)='Sunday','WOFF',concat(b.leave_type,' / ',b.MANAGER_STATUS)), if(a.DAYTYPE='HL',a.DAYTYPE ,a.DAY_STATUS))) END),'A') AS '"+ds+"' ");
		   //below Assam open for assam
		      
		     //  Sb.append(" IFNULL(MAX(CASE WHEN a.DATEON='"+ds+"' THEN IF(a.DAY_STATUS='P' , concat(a.ATT_IN,'||',a.ATT_OUT,'||',if(xc.req_type='AR','AR',ifnull(b.leave_type,'--'))) , if(a.DAY_STATUS='A' AND a.DAYTYPE!='HL',if(dayname(a.DATEON)='Sunday','WOFF',concat(b.leave_type,' / ',b.MANAGER_STATUS)), if(a.DAYTYPE='HL',a.DAYTYPE ,a.DAY_STATUS))) END),'A') AS '"+ds+"' ");

		       if(Type.equalsIgnoreCase("HYD_Daily_Attendance")||Type.equalsIgnoreCase("Mumbai_Daily_Attendance")||Type.equalsIgnoreCase("Ahmedabad_Daily_Attendance"))
		       {
		    	  		    	   
		    	//   Sb.append(" IFNULL(MAX(CASE WHEN a.DATEON='"+ds+"' THEN IF(a.DAY_STATUS='P' , concat(a.ATT_IN,'||',a.ATT_OUT) , if(a.DAY_STATUS='A' AND a.DAYTYPE!='HL',if(dayname(a.DATEON)='Sunday','WOFF',concat(b.leave_type,' / ',b.MANAGER_STATUS)), if(a.DAYTYPE='HL',a.DAYTYPE ,a.DAY_STATUS))) END),'A') AS '"+ds+"' ");
		    	
		    	   //weekof with out
		    	  Sb.append(" IF ( DATE_FORMAT(HH.DATEOFJOIN,'%Y-%m-%d') >'"+ds+"','--', IFNULL(MAX(CASE WHEN a.DATEON='"+ds+"' THEN IF(a.DAY_STATUS='P' , concat(a.ATT_IN,'||',a.ATT_OUT) , if(a.DAY_STATUS='A' AND a.DAYTYPE!='HL',if(dayname(a.DATEON)='Sunday','WOFF',concat(b.leave_type,' / ',b.MANAGER_STATUS)), if(a.DAYTYPE='HL',a.DAYTYPE ,a.DAY_STATUS))) END),'A') ) AS '"+ds+"' ");

		    	   //Weekof include leaves
		    	 //  Sb.append(" IF ( DATE_FORMAT(HH.DATEOFJOIN,'%Y-%m-%d') >'"+ds+"','--', IFNULL(MAX(CASE WHEN a.DATEON='"+ds+"' THEN IF(a.DAY_STATUS='P' , concat(a.ATT_IN,'||',a.ATT_OUT) , if(a.DAY_STATUS='A' AND a.DAYTYPE!='HL',concat(b.leave_type,' / ',b.MANAGER_STATUS), if(a.DAYTYPE='HL',a.DAYTYPE ,a.DAY_STATUS))) END),'A') ) AS '"+ds+"' ");
  
		        }
		       
		       else  if(Type.equalsIgnoreCase("Assam_Daily_Attendance"))
		       {
		    	  // Sb.append(" IFNULL(MAX(CASE WHEN a.DATEON='"+ds+"' THEN IF(a.DAY_STATUS='P' , concat(a.ATT_IN,'||',a.ATT_OUT,'||',if(xc.req_type='AR','AR',ifnull(b.leave_type,'--'))) , if(a.DAY_STATUS='A' AND a.DAYTYPE!='HL',if(dayname(a.DATEON)='Sunday','WOFF',concat(b.leave_type,' / ',b.MANAGER_STATUS)), if(a.DAYTYPE='HL',a.DAYTYPE ,a.DAY_STATUS))) END),'A') AS '"+ds+"' ");

		    	   //Weekof without leaves
		    	   //Sb.append(" IF ( DATE_FORMAT(HH.DATEOFJOIN,'%Y-%m-%d') >'"+ds+"','--',IFNULL(MAX(CASE WHEN a.DATEON='"+ds+"' THEN IF(a.DAY_STATUS='P' , concat(a.ATT_IN,'||',a.ATT_OUT,'||',if(xc.req_type='AR','AR',ifnull(b.leave_type,'--'))) , if(a.DAY_STATUS='A' AND a.DAYTYPE!='HL',if(dayname(a.DATEON)='Sunday','WOFF',concat(b.leave_type,' / ',b.MANAGER_STATUS)), if(a.DAYTYPE='HL',a.DAYTYPE ,a.DAY_STATUS))) END),'A') ) AS '"+ds+"'   ");
		    		 		    	   
		    	   //Weekof include leaves
		    	   Sb.append(" IF ( DATE_FORMAT(HH.DATEOFJOIN,'%Y-%m-%d') >'"+ds+"','--',IFNULL(MAX(CASE WHEN a.DATEON='"+ds+"' THEN IF(a.DAY_STATUS='P' , concat(a.ATT_IN,'||',a.ATT_OUT,'||',if(xc.req_type='AR','AR',ifnull(b.leave_type,'--'))) , if(a.DAY_STATUS='A' AND a.DAYTYPE!='HL',concat(b.leave_type,' / ',b.MANAGER_STATUS), if(a.DAYTYPE='HL',a.DAYTYPE ,a.DAY_STATUS))) END),'A') ) AS '"+ds+"'   ");
		    		
		    	 }
		      
		     //b.leave_type 
		      if(i!=dates.size()-1)
		      {
		    	  Sb.append(",");
		      }
		      
		  }
		  
		  
		  Sb.append("  from hclhrm_prod.tbl_employee_primary K ");
		  Sb.append("  left join test_mum.tbl_att_leave_in_out_status_report a on a.employeeid=k.employeesequenceno ");
		  // Assam
		  /*Sb.append(" left join hclhrm_prod_others.tbl_emp_attn_req xc on xc.employeeid=k.employeesequenceno ");
		  Sb.append(" and a.dateon=xc.REQ_DATE and xc.req_type='AR' ");*/ 
		  //Assam
		  
		  
		  
		  if(Type.equalsIgnoreCase("Assam_Daily_Attendance"))
	      {
			  Sb.append(" left join hclhrm_prod_others.tbl_emp_attn_req xc on xc.employeeid=k.employeesequenceno ");
			  Sb.append(" and a.dateon=xc.REQ_DATE and xc.req_type='AR' ");  
	       }
		  
		  
		  Sb.append("  left join hclhrm_prod_others.tbl_emp_leave_report B ON b.employeeid=a.employeeid AND a.dateon=b.leaveon and b.MANAGER_STATUS in ('A','P') ");
		  Sb.append("  LEFT JOIN HCLADM_PROD.TBL_BUSINESSUNIT BU ON k.COMPANYID=BU.BUSINESSUNITID ");
		  Sb.append("  LEFT JOIN hclhrm_prod.tbl_employee_professional_details DD ON K.EMPLOYEEID=DD.EMPLOYEEID ");
		  Sb.append("  LEFT JOIN HCLADM_PROD.TBL_DEPARTMENT DEP ON DD.DEPARTMENTID=DEP.DEPARTMENTID ");
		  Sb.append("  LEFT JOIN HCLADM_PROD.TBL_COSTCENTER G ON K.COSTCENTERID=G.COSTCENTERID ");
		  Sb.append("  LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PROFILE HH ON K.EMPLOYEEID=HH.EMPLOYEEID ");
		  Sb.append("  LEFT JOIN hclhrm_prod.tbl_status_codes ST ON ST.STATUS=K.STATUS ");
		  //Sb.append("  where K.companyid in(15,16) ");
		  if(Type.equalsIgnoreCase("Assam_Daily_Attendance"))
	      {
			  Sb.append("  where K.companyid in(15,16) and k.status in(1001,1092)  ");  
	       }
		  
		  
		  if(Type.equalsIgnoreCase("HYD_Daily_Attendance"))
	      {
			  Sb.append("  where  bu.callname in('HYD') and K.companyid not in(15,16,17)   and k.status in(1001,1092) ");
			  
			  //Manager ID------->and DD.MANAGERID=103426
			  // and k.employeesequenceno=11666
	      }
		  
		  if(Type.equalsIgnoreCase("Mumbai_Daily_Attendance"))
		  {
			  Sb.append(" where bu.callname in('MUM') and G.NAME='OFFICE' ");
			  Sb.append(" and k.employeesequenceno not in(10160,10179,10182,10302,101194,106957,201550,204936) and  k.status in(1001)  ");
		  }
		  
		  
		  if(Type.equalsIgnoreCase("Ahmedabad_Daily_Attendance"))
	      {
			  Sb.append("  where   K.companyid in(17) and k.status in(1001,1092)  ");
			  
			  //Manager ID------->and DD.MANAGERID=103426
	      }
		  
		  //3,5,6,7,8,12,13,23,30
		 // Sb.append("  where K.companyid in(17) ");
		//  Sb.append("  where K.companyid in(10,11,14,17,18,19,20,21,22,24,25,26,27,28,29) ");
		  //10,11,14,17,18,19,20,21,22,24,25,26,27,28,29
		  Sb.append("  and a.dateon between '"+str_date+"' and '"+end_date+"' ");
		  Sb.append("   group by a.employeeid  ");
		  
		  System.out.println(Sb.toString());
		  
		  
		  
		/*  CALL PROCEDURE.SFAAttendance(
				  (SELECT GROUP_CONCAT(BUSINESSUNITID)ID FROM HCLADM_PROD.TBL_BUSINESSUNIT WHERE STATUS=1001 AND CALLNAME IN ('HYD'))
				  ,'1001,1092','2019-01-27','2019-02-23');*/
		
		  
		  return Sb.toString();

		 
	}
	
	

}
