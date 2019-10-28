package com.hcl.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;

import com.hcl.util.Util;

/**
 * Servlet implementation class TDSDownloadReport
 */
public class TDSDownloadReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TDSDownloadReport() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String empid=request.getParameter("empid");
		String FYEAR=request.getParameter("FYEAR");

		
		System.out.println(empid+"::"+FYEAR);
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		ResultSet rs=null;
	PrintWriter out=response.getWriter();
		con = Util.getConnection();
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		String qry=null;
		
		String pattern = "dd-MM-yyyy HH-mm-ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		String date = simpleDateFormat.format(new Date());
		
	   	String printFileName=null;
	    FileInputStream fileInputStream=null;
		String  path =  "C:/jasper/TDS/TDS Letters/";
		File theDir = new File(path);
		try{
			if(con!=null){
				qry="SELECT MAX(EMPLOYEEID) EMPLOYEEID FROM test.tbl_it_emp_detailS where STATUS='S' AND EMPLOYEEID= "+empid+" ";
				pstmt=con.prepareStatement(qry);
				rs = pstmt.executeQuery();
				if(rs.next()){

					hm.put("empid",rs.getString("EMPLOYEEID"));			
					JasperFillManager.fillReportToFile("C:/jasper/TDS/ITS.jasper/",hm,con);
					System.out.println("Done!");
					printFileName="C:/jasper/TDS/ITS.jrprint";
					JasperExportManager.exportReportToPdfFile(printFileName, ""+theDir+"/"+((String) hm.get("empid")).concat("_"+date)+".pdf");

				}


				response.setContentType("APPLICATION/OCTET-STREAM");
				response.setHeader("Content-Disposition", "attachment; filename=\""
						+((String) hm.get("empid")).concat("_"+date)+".pdf"+ "\"");
				fileInputStream = new FileInputStream(theDir+"/"+((String) hm.get("empid")).concat("_"+date)+".pdf");

				int i;
				while ((i = fileInputStream.read()) != -1) {
					out.write(i);
				}
				fileInputStream.close();
				out.close();


			}else{

				out.print("");
			}
		}catch(Exception e){
			out.println("");
		}


	}

}
