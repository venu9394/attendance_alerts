package com.hcl.servlets;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class itcals extends javax.servlet.http.HttpServlet
{
  public itcals() {}
  
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException
  {
    PrintWriter out = response.getWriter();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    response.setContentType("text/html");
    String id = request.getParameter("id");
    String financialyear=request.getParameter("financialyear");
    StringBuffer eligibleQry = new StringBuffer();
    
    eligibleQry.append(" SELECT A.EMPLOYEESEQUENCENO,A.CALLNAME,IFNULL(C.NAME,'NA') DESIGNATION,IFNULL(D.NAME,'NA') DEPARTMENT,");
    eligibleQry.append(" TIMESTAMPDIFF(YEAR, A.DATEOFBIRTH, CURDATE())AS AGE,COUNT(*)VALID,");
    eligibleQry.append(" (SELECT COUNT(*) FROM TEST.TBL_EMP_IT_TDS where EMPLOYEEID IN (" + id + ") AND STATUS=1001");
    eligibleQry.append(" AND FY IN ('"+financialyear+"')) GM,IF(IFNULL(E.PAN,'')=IFNULL(PAN.PANNUMBER,''),IFNULL(E.PAN,''),IFNULL(PAN.PANNUMBER,E.PAN)) PAN");
  
    
   /* eligibleQry.append(" SELECT CASE WHEN MONTH(CURDATE())<=3 THEN CONCAT(YEAR(CURDATE())-1, '-',YEAR(CURDATE()))");
    eligibleQry.append("        ELSE CONCAT(YEAR(CURDATE()),'-', YEAR(CURDATE())+1) END)");*/
   
  
    
    eligibleQry.append(" FROM");    
    eligibleQry.append(" HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY A");
    eligibleQry.append(" LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PROFESSIONAL_DETAILS B ON A.EMPLOYEEID=B.EMPLOYEEID");
    eligibleQry.append(" LEFT JOIN HCLADM_PROD.TBL_DESIGNATION C ON B.DESIGNATIONID=C.DESIGNATIONID");
    eligibleQry.append(" LEFT JOIN HCLADM_PROD.TBL_DEPARTMENT D ON D.DEPARTMENTID=B.DEPARTMENTID");
    eligibleQry.append(" LEFT JOIN HCLHRM_PROD.tbl_employee_personalinfo E ON A.EMPLOYEEID=E.EMPLOYEEID");
    eligibleQry.append(" LEFT JOIN test.tbl_it_emp_details PAN ON A.EMPLOYEESEQUENCENO=PAN.EMPLOYEEID");
    eligibleQry.append(" WHERE EMPLOYEESEQUENCENO IN (" + id + ") AND PAN.REFNO=(SELECT MAX(REFNO) FROM test.tbl_it_emp_details WHERE EMPLOYEEID IN (" + id + ") )");
    try
    {
      conn = com.hcl.util.Util.getConnection();
    } catch (Exception e) {
      e.printStackTrace();
    }
    try {
      ps = conn.prepareStatement(eligibleQry.toString());
      System.out.println(ps);
    } catch (Exception e) {
      e.printStackTrace();
    }
    try {
      rs = ps.executeQuery();
    } catch (Exception e) {
      e.printStackTrace();
    }
    try
    {
      ArrayList al = new ArrayList();
      if (rs.next()) {
        al.add("'" + rs.getString(1) + "'");
        al.add("'" + rs.getString(2) + "'");
        al.add("'" + rs.getString(3) + "'");
        al.add("'" + rs.getString(4) + "'");
        al.add("'" + rs.getString(5) + "'");
        al.add("'" + rs.getString(6) + "'");
        al.add("'" + rs.getString(7) + "'");
        al.add("'" + rs.getString(8) + "'");
      }
      out.write(al.toString());
    }
    catch (Exception e2)
    {
      e2.printStackTrace();
      

      out.close();
      try {
        conn.close();
        ps.close();
        rs.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    finally
    {
      out.close();
      try {
        conn.close();
        ps.close();
        rs.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}