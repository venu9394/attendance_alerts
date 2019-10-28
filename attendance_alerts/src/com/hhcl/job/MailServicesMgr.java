package com.hhcl.job;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.apache.log4j.Logger;

class MailServicesMgr extends Thread{
String ThreadCnt;
String ThreadCnt1;
String ID;
String NAME;
Map map1=new HashMap();
Mailer SubMail=new Mailer();


Properties error_prop=new Properties();
static final Logger LOGGER = Logger.getLogger(MailServicesMgr.class);


@SuppressWarnings("unchecked")

public static void main(String[] args) {
		
	/*MailServices test[] = new MailServices[5];
		Map map1=new HashMap();
		int cont=0;
		*/
		/*for(int i=0;i<5;i++) {
			int k=i;
			map1.put("D", ""+k+"");
			test[i]=new MailServices(map1,""+k+"");
			test[i].start();
			System.out.println(k +" ::Thread Loop::" +i);
			
		}*/
		
	}

	
	
	//  RUN MANAGER*******************************************
	
	public  synchronized String  RunMgr(Map ManagerData_map,String mgrMail,int contloop) {
		// TODO Auto-generated method stub
		
		
		
		
		
		System.out.println(NAME +" :: Run Loop 2::" + ID);
		
		String  to=null, subject="Team Swipe Information", msg=null;
		
		StringBuffer toMail=new  StringBuffer(); 
		StringBuffer CC_Mail=new  StringBuffer();
		Mailer SubMail=new Mailer();
		
		toMail.append(mgrMail.toLowerCase());
		
		//toMail.append("venubabu.g@heterohealthcare.com");
		
		//if(mgrMail..)
		//toMail.append("venubabu.g@heterohealthcare.com");
		
		List FetchRecorde=new ArrayList();
		     FetchRecorde=(List) ManagerData_map.get(mgrMail);
		     Iterator Mgritr=FetchRecorde.iterator();
		
		     
 System.out.println(mgrMail.toLowerCase()  +" ::Manager Loop ::" + FetchRecorde.toString());
 
 LOGGER.info(mgrMail.toLowerCase() + "Before Sending Manager e-mail : "+FetchRecorde.toString() );
 
 
		//msg=NAME +"Good morning .....!" +ID;
		
		StringBuffer htmlboddy=new  StringBuffer();
	
		// *******************************************
		
		htmlboddy.append(" <!DOCTYPE html>    ");
		htmlboddy.append(" <html>   ");
		htmlboddy.append(" <head>   ");
		htmlboddy.append(" <title>Attendence Table</title>   ");
		htmlboddy.append(" <style>   ");
		htmlboddy.append(" body {   ");
		htmlboddy.append("	margin: 0px;   ");
		htmlboddy.append("	padding: 0px;   ");
		htmlboddy.append(" }   ");
		htmlboddy.append(" table {   ");
		htmlboddy.append("   font-family: arial, sans-serif;   ");
		htmlboddy.append("   border-collapse: collapse;   ");
		htmlboddy.append("   width: 100%;   ");
		htmlboddy.append("   font-size :12px;   ");
		htmlboddy.append(" }   ");
		htmlboddy.append("    ");
		htmlboddy.append(" th {   ");
		htmlboddy.append("   border-bottom: 2px solid #dddddd;   ");
		htmlboddy.append("   text-align: left;   ");
		htmlboddy.append("   padding: 6px;   ");
		htmlboddy.append("   color:#777777;   ");
		htmlboddy.append("   background-color:#f2f2f2;   ");
		htmlboddy.append("   font-size :12px;   ");
		htmlboddy.append("	  line-height: 1.42857143;   ");
		htmlboddy.append(" }   ");
		htmlboddy.append(" td {   ");
		htmlboddy.append("   border-bottom: 2px solid #dddddd;   ");
		htmlboddy.append("   text-align: left;   ");
		htmlboddy.append("   padding: 8px;   ");
		htmlboddy.append("   color:#777777;   ");
		htmlboddy.append("   font-size :12px;   ");
		htmlboddy.append(" }   ");
		htmlboddy.append("    ");
		
		htmlboddy.append(" span{   ");
		htmlboddy.append("   border-bottom: 2px solid #dddddd;   ");
		htmlboddy.append("   text-align: left;   ");
		htmlboddy.append("   padding: 10px;   ");
		htmlboddy.append("   color:#777777;   ");
		htmlboddy.append("   font-size :14px;   ");
		htmlboddy.append(" }   ");
		htmlboddy.append("    ");
		
		htmlboddy.append(" .leave-table tr:nth-child(even) {   ");
		htmlboddy.append("   background-color: #eaf8e5;   ");
		htmlboddy.append(" }   ");
		htmlboddy.append(" .title-txt {   ");
		htmlboddy.append("	background-color: #0088cc;   ");
		htmlboddy.append("	text-align: center;   ");
		htmlboddy.append("	color: #fff;   ");
		htmlboddy.append("	padding: 6px;   ");
		htmlboddy.append(" }   ");
		htmlboddy.append(" .leave-table {   ");
		htmlboddy.append("	width: 75%;   ");
		htmlboddy.append("	margin: 0 auto;  ");
		htmlboddy.append("	border: 1px solid #333;			  ");
		htmlboddy.append(" }   ");
		htmlboddy.append(" .title-txt1 {   ");
		htmlboddy.append("	background-color: #0a8090;   ");
		htmlboddy.append("	color: #fff;   ");
		htmlboddy.append("	font-style: italic;   ");
		htmlboddy.append("	text-align: center;   ");
		htmlboddy.append(" }   ");
		htmlboddy.append(" .title-txt1 a {   ");
		htmlboddy.append("	color: #f5ef00;   ");
		htmlboddy.append("	text-decoration: none;   ");
		htmlboddy.append(" }   ");
		htmlboddy.append(" .leave-table1 {   ");
		htmlboddy.append("	width: 75%;   ");
		htmlboddy.append("	background-color: #0088cc;   ");
		htmlboddy.append("	margin: 0 auto;  ");
		htmlboddy.append("	border-bottom: 3px solid #333 !important;  ");
		htmlboddy.append("	border-top: 5px solid #0a8090;  ");
		htmlboddy.append("	border-left: 1px solid #333;  ");
		htmlboddy.append("	border-right: 1px solid #333;  ");
		htmlboddy.append(" }   ");
		htmlboddy.append(" .leave-table1 tr td a {   ");
		htmlboddy.append("	color: #0088cc;			   ");
		htmlboddy.append("	text-decoration: none;   ");
		htmlboddy.append("	font-weight: 600;   ");
		htmlboddy.append("	text-align: center !important;  ");
		htmlboddy.append("	font-size: 11px;  ");
		htmlboddy.append(" }   ");
		htmlboddy.append(" .note-txt {   ");
		htmlboddy.append("	text-align: center !important;   ");
		htmlboddy.append("	color: #ffffff;	  ");
		htmlboddy.append("	font-size: 11px;  ");
		htmlboddy.append(" }   ");
		htmlboddy.append(" </style>   ");
		htmlboddy.append(" </head>   ");
		htmlboddy.append(" <body>   ");
		
		//************************************
		// htmlboddy.append(" <span> Dear    "+ map1.get("EMPNAME_"+ID).toString().toUpperCase()+"   , </span>");
		
		htmlboddy.append(" <span> Dear    Sir / Mam  , </span>");	
		
		htmlboddy.append("  <br/> ");
		htmlboddy.append("  <br/> ");
		
		
		//htmlboddy.append(" \t\t\t\t\\t\t\t\t\ ");
		
		htmlboddy.append(" <span>Please find Your Team swipe details as recorded in iConnect for recent working day. </span> ");
		htmlboddy.append("  <br/> ");
		htmlboddy.append("  <br/> ");
		
		//htmlboddy.append(" <span > &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;  </span> ");
		
		
	//************************************************
		
		htmlboddy.append(" <table class='leave-table'>   ");
		htmlboddy.append(" <tr>   ");
		htmlboddy.append(" <th colspan='10' class='title-txt' style='font-style:italic'> Team Swipe Information</th>   ");
		htmlboddy.append(" </tr>   ");
		htmlboddy.append(" <tr>   ");
		
		htmlboddy.append(" <th  colspan='2' >EMP ID</th>   ");
		htmlboddy.append(" <th  colspan='2' >Name</th>   ");
		htmlboddy.append(" <th  colspan='2' >DATE</th>   ");
		htmlboddy.append(" <th  colspan='2' >IN</th>   ");
		htmlboddy.append(" <th  colspan='2' >OUT</th>   ");
		htmlboddy.append("  ");
		htmlboddy.append(" </tr>   ");
		
		while(Mgritr.hasNext()) {
			
			List Sublist=new ArrayList();
			Sublist=(List) Mgritr.next();
		
			 /*myList_Sub.add(rs.getString("EmpCode"));
			   myList_Sub.add(rs.getString("EmpName"));
			   myList_Sub.add(rs.getString("DATEON"));
			   myList_Sub.add(rs.getString("InTime"));
			   myList_Sub.add(rs.getString("OutTime"));*/
			   
		htmlboddy.append(" <tr>   ");
		
		htmlboddy.append(" <td colspan='2'> "+ Sublist.get(0)+" </td>   ");
		htmlboddy.append(" <td colspan='2'> "+ Sublist.get(1)+" </td>   ");
		htmlboddy.append(" <td colspan='2'> "+ Sublist.get(2)+" </td>   ");
		htmlboddy.append(" <td  colspan='2'>"+Sublist.get(3)+"</td>   ");
		htmlboddy.append(" <td  colspan='2' >"+Sublist.get(4)+"</td>   ");
		
		/*htmlboddy.append(" <td colspan='2'> "+ map1.get("EMPDATE_"+ID).toString()+" </td>   ");
		htmlboddy.append(" <td colspan='2'> "+ map1.get("EMPDATE_"+ID).toString()+" </td>   ");
		htmlboddy.append(" <td colspan='2'> "+ map1.get("EMPDATE_"+ID).toString()+" </td>   ");
		htmlboddy.append(" <td  colspan='2'>"+map1.get("EMPIN_"+ID).toString()+"</td>   ");
		htmlboddy.append(" <td  colspan='2' >"+map1.get("EMPOUT_"+ID).toString()+"</td>   ");*/
		htmlboddy.append("  ");
		htmlboddy.append(" </tr>   ");
		
		}
		
		
		htmlboddy.append("  ");
		htmlboddy.append(" </table>   ");
		htmlboddy.append(" <table class='leave-table'>   ");
		htmlboddy.append(" <tr>   ");
		htmlboddy.append(" <th colspan='10' class='title-txt1' >   </th>   ");
		htmlboddy.append(" </tr>   ");
		//htmlboddy.append(" <tr>   ");
		
		//Regularize your attendance or Apply leave accordingly
		
		/*htmlboddy.append(" <th colspan='6' class='title-txt'>Your Leave Balance Report of  <B>"+ map1.get("EMPLEAVBAL_YEAR"+ID) +"  </B> </th>   ");   // Leave EMPLEAVBAL_YEAR  
		htmlboddy.append(" </tr>   ");
		htmlboddy.append(" <tr>   ");
		htmlboddy.append(" <th>Leave Type</th>   ");
		htmlboddy.append(" <th>Quota</th>   ");
		htmlboddy.append(" <th>Used</th>   ");
		htmlboddy.append(" <th>Deducted</th>   ");
		htmlboddy.append(" <th colspan='2'>Available</th>   ");
		htmlboddy.append(" </tr>   ");
		
		if(map1.get("EMPLEAVBAL_"+ID).toString()!=null || map1.get("EMPLEAVBAL_"+ID)!=null) {
		htmlboddy.append(map1.get("EMPLEAVBAL_"+ID).toString() );
		}else {
			
			htmlboddy.append(" <tr>   ");
			htmlboddy.append(" <td colspan='6'> No Data , Please contact concern department </td> ");
			htmlboddy.append(" </tr>   ");
		}*/
		
		
		htmlboddy.append(" </table>   ");
		htmlboddy.append("  ");
		htmlboddy.append(" <table class='leave-table1'>  ");
		htmlboddy.append("  ");
		htmlboddy.append(" <tr  style='background-color:#fff'>   ");
		//htmlboddy.append(" <td > <a href='http://www.heterohealthcare.com/'> About Organization </a> </td>   ");
		/*htmlboddy.append(" <td> &nbsp; &nbsp;&nbsp; </td>   ");
		*/
		htmlboddy.append(" <td colspan='2'> &nbsp;  &nbsp; &nbsp;&nbsp; </td>   ");
		
        
		htmlboddy.append(" <td colspan='2' style='color:white' >&nbsp;&nbsp; <a href='http://iconnect.heterohcl.com/heterodesk/'>iConnect (HYD)</a></td>   ");
		//htmlboddy.append(" <td style='color:white' > <a href='http://azistaindustries.com/'> Azista industries </a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  </td>  ");
		htmlboddy.append(" <td colspan='2' style='color:white' >&nbsp;&nbsp; <a href='http://iconnect.heterohcl.com/azistadesk/'>iConnect Azista</a>  </td>    ");
		htmlboddy.append(" <td colspan='2' style='color:white' > &nbsp;&nbsp; <a href='http://iconnect.heterohcl.com/fieldesk/'>iConnect Field (MUM)</a>  </td>    ");
		htmlboddy.append(" <td colspan='2' > &nbsp;  &nbsp; </td>   ");
		/*htmlboddy.append(" <td> &nbsp;  &nbsp; </td>   ");
		*/
		
		
		//htmlboddy.append(" <td style='color:white' ><a href='http://mydesk.heterohcl.com/IT/'>ITAX Public URL</a></td>   ");
		//htmlboddy.append(" <td style='color:white' ><a href='http://192.168.30.105:8080/IT/'>ITAX corporate URL</a></td>   ");
		htmlboddy.append(" </tr>   ");
		
		htmlboddy.append("  ");
		htmlboddy.append(" <tr>    ");
		htmlboddy.append(" <td colspan='10' class='note-txt'> Note : ** Please do not reply to this e-mail, e-mails sent to this address will not be answered. </td>      ");
		htmlboddy.append(" </tr>   ");
		htmlboddy.append("  ");
		htmlboddy.append(" </table>   ");
		htmlboddy.append(" </body>   ");
		htmlboddy.append(" </html>  ");
		
		
		htmlboddy.append("  <br/> ");
		htmlboddy.append("  <br/> ");
		
		htmlboddy.append(" <span>Regards </span> ");
		htmlboddy.append("  <br/> ");
		htmlboddy.append(" <span> Hetero HealthCare & Azista industries </span>");
		
		//htmlboddy.append("  <br/> ");
		
		//htmlboddy.append("<img src='cid:/Icon.png' />");
		
		//*******************************************
		
		//LOGGER.info(ID+ "Before Sending e-mail : "+NAME+"  and ID :"+ID+"  AND email-:"+toMail);
		
		try {
			//Name=map1.get("EMPNAME_"+ID).toString()
		  String Name="VENU" ;
		  SubMail.send(toMail, subject, htmlboddy.toString(),CC_Mail ,Name);
		}catch(Exception err) {
			
			LOGGER.debug("Error Sending mail :" + err);
			err.printStackTrace();
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
		
		
	}
	// STOP MANAGER*******************************************
	
}
