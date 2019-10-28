package com.hhcl.mail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;

public class job1_sub {
	  
	Properties error_prop=new Properties();
	static final Logger LOGGER = Logger.getLogger(job1_sub.class);
	
public synchronized Map calljob (int minLimit, int MaxLimit, Connection con,String FETCHQUERY,String INSERTQURY,int CallNum,Connection conSql,String Masql_FETCHQUERY){
	
	 //System.out.println("15");
		
		Map  map=new HashMap()  ;
		int[] excutBatch;
		ArrayList empiid=new ArrayList();
		Map parrams=new HashMap();
		int finalCount=0;
		System.out.println("E-mailFetchQuery:" +FETCHQUERY);
		
		Set ManagerData=new HashSet();
		Map ManagerData_map=new HashMap();
		
		try{
			
			//System.out.println("12");
			boolean flag=false;
			int MiniLimit_m=minLimit+1000;
			int MaxLimit_m=MaxLimit+1000;
			String DATEON=null;
			String DAYTYPE=null;
			
			map.put("minLimit", ""+MiniLimit_m+"");
			map.put("MaxLimit", ""+MaxLimit_m+"");
			//String Query=Job1.fetchQuery;
			/*PreparedStatement pstmt = con.prepareStatement( Query.toString());*/
			/*select IFNULL(A.HOLIDAYDATE,'0000-00-00') HOLIDAYDATE
			from HCLHRM_PROD.TBL_HOLIDAYS A left join
			HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY B ON A.BUSINESSUNITID=B.companyid
			where A.employeeid in(20314)*/
			
			//System.out.println("2");
			PreparedStatement pstmt=null;
		    pstmt = con.prepareStatement(FETCHQUERY);
		   
		//   Masql_FETCHQUERY= "select  A.AttendanceDate , B.EmployeeCode, B.EmployeeId , B.EmployeeName ,convert(varchar,CAST(A.InTime as datetime),8) as intime,convert(varchar,CAST(A.OutTime as datetime),8) as outtime , A.LateBy , A.EarlyBy , A.ShiftId,A.Duration ,convert(varchar(5),DateDiff(s, A.InTime, A.outTime)/3600)+':'+convert(varchar(5),DateDiff(s, A.InTime, A.outTime)%3600/60)+':'+convert(varchar(5),(DateDiff(s, A.InTime, A.outTime)%60)) workinghours from dbo.AttendanceLogs  A left join dbo.Employees  B ON B.employeeid=A.employeeid where A.AttendanceDate in(?) and B.EmployeeCode in(?)";
		  
		   StringBuffer Buffatt=new StringBuffer();
		   StringBuffer Holidays=new StringBuffer();
	      
	       
	         
	        /* Buffatt.append(" select  A.AttendanceDate ,B.EmployeeCode, B.EmployeeId , B.EmployeeName ,A.InTime as intime,A.OutTime as outtime , A.LateBy , A.EarlyBy , A.ShiftId,A.Duration As workinghours from dbo.AttendanceLogs  A ");
	         Buffatt.append(" left join dbo.Employees  B ON B.employeeid=A.employeeid where A.AttendanceDate in(?) and B.EmployeeCode in(?) ");
	        
	         */
		  // PreparedStatement MsSqlpstmt = null;
		   Statement MsSqlpstmt = conSql.createStatement();
		 
		   ResultSet rs=null;
		  // pstmt.setInt(1, minLimit); for limit Set
		   System.out.println(pstmt);
		  //   PreparedStatement stmt=con.prepareStatement(INSERTQURY);
		     rs = pstmt.executeQuery();
		     StringBuffer EmployeeId=new StringBuffer();
		     StringBuffer EmployeeIdMysql=new StringBuffer();
		 
		     
		   while (rs.next()) {
		    
			   flag=true;
			   DATEON=rs.getString(1);
			 //  DAYTYPE=rs.getString("Daytype");
			   
			   List myList_Main = new ArrayList();
			   List myList_Sub = new ArrayList();
			   
			   empiid.add(rs.getString("EmpCode"));
			   
			   /*
			   updateF1 = Res.getString(1);
               updateF2 = Res.getString(2);
               Sender_Name = Res.getString(3);
               To_email.append(Res.getString(4));
               CC_mail.append(Res.getString(5));
               subject_Mail = Res.getString(6);
               Mail_body = Res.getString(7);
               Hrf_link = Res.getString(8).concat(Res.getString(9));
               sendMail_process_flag = true;
               */
			   map.put("RID_"+rs.getString(1) , rs.getString(1));
			   map.put("EMPLOYEEID_"+rs.getString(1) , rs.getString(2));
			   map.put("EMPNAME_"+rs.getString(1) , rs.getString(3));
			   map.put("EMPMGR_"+rs.getString(1) , rs.getString(4));
			   map.put("CC_mail_"+rs.getString(1) , rs.getString(5));
			   map.put("subject_Mail_"+rs.getString(1) , rs.getString(6));
			   map.put("Mail_body"+rs.getString(1) , rs.getString(7));
			   map.put("Hrf_link_"+rs.getString(1) , rs.getString(8).concat(rs.getString(9)));
			   
			   EmployeeId.append(rs.getString(1));
			   EmployeeId.append(",");
			   finalCount ++;
		   }
	    EmployeeId.append("0101010101");
	    EmployeeIdMysql.append("0101010101");
	   System.out.println(DATEON +" ~~~ " +EmployeeId);
		System.out.println(flag +" ::: flag");
		  // flag=false;
		   
	Iterator ltr=empiid.iterator();
	if(flag){
		
		MailServices test[] = new MailServices[empiid.size()+2];
		int i=0;
		
		
		try{
			
		while(ltr.hasNext()){
			
			
			
			Thread.sleep(10000);
			String Empid=ltr.next().toString();
			/*Map map1=new HashMap();
			map1.put("D", Empid);
			map1.put("ID"+Empid ,map.get("EMPID_"+Empid));
			map1.put("NAME"+Empid, map.get("EMPNAME_"+Empid));*/
		try {
			test[i]=new MailServices(map,Empid,i);
			test[i].start();
			/*
			test[i].sleep(1000);
			test[i].join();*/
			
			i=i+1;
			
		}catch(Exception Err) {
			Err.printStackTrace();
		}
			
		}
		try {
			
		
		for(int j=0 ;j<i ;j++) {
		  
			test[j].join();
			Thread.sleep(1000);
			
		}
		}catch(Exception err) {
			err.printStackTrace();
		}
		
	//**********************************************************Manager Mail ID
	/*	try {
		Thread.sleep(10000*5);
		}catch(Exception err) {
			err.printStackTrace();
		}

		
		try {
			 
			//MailServicesMgr Obj_mgr = new MailServicesMgr();
			String MgrStatus=null;
			Iterator Mgritr=ManagerData.iterator();
		int K=0;
		while(Mgritr.hasNext()){
			String MgrMail=Mgritr.next().toString();
			//MgrStatus=Obj_mgr.RunMgr(ManagerData_map,MgrMail,K);
			
			try {
				Thread.sleep(10000*2);
				}catch(Exception err) {
					err.printStackTrace();
				}
			
			K=K+1;
		}	
		}catch(Exception Err) {
			Err.printStackTrace();
		}
		*/
//****************************************************************Manager Mail ID
		
		
		
		
		
		
		
		
		
		
		
		
		}catch(Exception err){
			flag=false;
			System.out.println("Exception At AddBatch"+err);
		}
		
		map.put("exuFlag", "false");
		// map.put("exuFlag", "true"); for limit use
	     map.put("DATEON", DATEON);
	       
		
	}else{
		   
	    map.put("minLimit", "0");
		map.put("MaxLimit", "0");
		map.put("exuFlag", "false");
	   
   }
	
	
	
		  /* 
		   if(flag){
			   
			   System.out.println("Excecute Batch");
		 //  excutBatch=stmt.executeBatch();
		   if(excutBatch.length>0){
		      map.put("exuFlag", "true");
		      if(CallNum==1){
		       map.put("DATEON", DATEON);
		      }
		   }else{
			   map.put("exuFlag", "false");
		   }
		   
		   }else{
			   
			    map.put("minLimit", "0");
				map.put("MaxLimit", "0");
				map.put("exuFlag", "false");
			   
		   }
		   */
		}catch(Exception Err){
			System.out.println("Email Exception at sub class" +Err);
		}
	     System.out.println("Email Final Mail processed Count :::" +finalCount);
	     LOGGER.info("******************************* Email Final Count At End************" +finalCount);
		 return map;
	}
}
