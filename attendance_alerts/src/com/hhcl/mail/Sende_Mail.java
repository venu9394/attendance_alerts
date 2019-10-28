package com.hhcl.mail;

import com.bonecp.util.DBUtil;
import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class Sende_Mail
{

    public Sende_Mail()
    {
    }

    public static synchronized void DoSend()
    {
        FileReader reader = null;
        Properties p = null;
        Connection con = null;
        String FetchQuery = null;
        GetDbData DataObj = new GetDbData();
        Properties error_prop = new Properties();
        error_prop.setProperty("DoSendStart", "Email Start polar");
        try
        {
            reader = new FileReader("C:\\mailconfig_new\\email.properties");
        }
        catch(FileNotFoundException e)
        {
            System.out.println("in Valid Config Path File ");
            e.printStackTrace();
            error_prop.setProperty("ConfigFile", e.toString());
        }
        p = new Properties();
        try
        {
            p.load(reader);
            error_prop.setProperty("DoSendStart", "Load Config File");
        }
        catch(IOException e)
        {
            error_prop.setProperty("DoSendStart IOException", e.toString());
            e.printStackTrace();
        }
        try
        {
           /* Class.forName("com.mysql.jdbc.Driver");
            String URL = p.getProperty("connectionURL");
            String username = p.getProperty("username");
            String password = p.getProperty("password");
            FetchQuery = p.getProperty("FetchQuery");
            con = DriverManager.getConnection(URL, username, password);*/
        	FetchQuery = p.getProperty("FetchQuery");
        	try{
        	con=DBUtil.getConnection();
        	System.out.println("BoneCp Connection Building ...!");
        	}catch(Exception err){
        		err.printStackTrace();
        	}
            if(con != null)
            {
                System.out.println("Connection Established ..!");
                error_prop.setProperty("Connection ", "Connection Established ..!");
            }
        }
        catch(Exception EE)
        {
            System.out.println("Connection could not be established...!");
            error_prop.setProperty("Connection ", EE.toString());
        }
        ResultSet Res = null;
        StringBuffer To_email = new StringBuffer();
        StringBuffer CC_mail = new StringBuffer();
        String Sender_Name = null;
        String subject_Mail = null;
        String Mail_body = null;
        String Hrf_link = null;
        String updateF1 = null;
        String updateF2 = null;
        boolean sendMail_process_flag = false;
        try
        {
            System.out.println((new StringBuilder("Fetch Query::")).append(FetchQuery.toString()).toString());
            error_prop.setProperty("Fetch Query::", FetchQuery.toString());
            for(Res = DataObj.FetchData(FetchQuery.toString(), "Calling Query To Send Approval Mails", Res, con); Res.next(); error_prop.setProperty("Connection ", "Connection Established ..!"))
            {
                updateF1 = Res.getString(1);
                updateF2 = Res.getString(2);
                Sender_Name = Res.getString(3);
                To_email.append(Res.getString(4));
                CC_mail.append(Res.getString(5));
                subject_Mail = Res.getString(6);
                Mail_body = Res.getString(7);
                Hrf_link = Res.getString(8).concat(Res.getString(9));
                sendMail_process_flag = true;
            }

        }
        catch(SQLException Er)
        {
        
        	System.out.println("ERROR:::" +Er);
         /*
        	try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
            sendMail_process_flag = false;
            System.out.println((new StringBuilder("Exception At Er::")).append(Er).toString());
        }
        try
        {
            error_prop.setProperty("To Mail ", To_email.toString());
            error_prop.setProperty("CC Mail ", CC_mail.toString());
            if(sendMail_process_flag)
            {
                MailSend(To_email, CC_mail, Sender_Name, subject_Mail, Mail_body, Hrf_link, p, con, updateF1, updateF2, error_prop);
            } else
            {
                error_prop.setProperty("Failed To Load MailSend  Flag value", (new StringBuilder()).append(sendMail_process_flag).toString());
            }
        }
        catch(AddressException e)
        {
            error_prop.setProperty("Error At Load MailSend-1  ", e.toString());
            e.printStackTrace();
        }
        catch(MessagingException e)
        {
            error_prop.setProperty("Error At Load MailSend-1  ", e.toString());
            e.printStackTrace();
        }finally{
        	
        	
        	
       if(Res!=null){
        		
        		
        		
        		try {
        			Res.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        	
        	
        	if(con!=null){
        		
        		
        		
        		try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        }
        LogReport(error_prop);
    }

    public static void MailSend(StringBuffer To_email, StringBuffer CC_mail, String Sender_Name, String subject_Mail, String Mail_body, String Hrf_link, Properties p, Connection con, 
            String updateF1, String updateF2, Properties error_prop)
        throws AddressException, MessagingException
    {
        error_prop.setProperty("MailSend Function Loaded:  ", "Load Success");
        String message_update = "SUCCESS";
        String ErrorMessage = "Done";
        final String user = p.getProperty("frommail");
        final String userpassword = p.getProperty("mailpwd");
        Properties props = new Properties();
        props.put("mail.smtp.host", p.getProperty("mail.smtp.host"));
        props.put("mail.smtp.port", p.getProperty("mail.smtp.port"));
        props.put("mail.smtp.starttls.enable", p.getProperty("mail.smtp.starttls.enable"));
        props.put("mail.smtp.auth", p.getProperty("mail.smtp.auth"));
        Session session = Session.getDefaultInstance(props, new Authenticator() {

        

            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(user, userpassword);
            }

            
        });
        MimeMessage message = null;
        Multipart multipart = null;
        try
        {
            System.out.println((new StringBuilder("Step 3:")).append(session).toString());
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            System.out.println((new StringBuilder(String.valueOf(To_email.toString()))).append("~~~~").append(CC_mail.toString()).toString());
            message.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse(To_email.toString(), false));
            message.setRecipients(javax.mail.Message.RecipientType.CC, InternetAddress.parse(CC_mail.toString()));
            System.out.println((new StringBuilder(String.valueOf(Mail_body))).append(Hrf_link).append(p.getProperty("Notice_mail")).append(Sender_Name).toString());
           
              String Hrf_link_R=Hrf_link.concat("&mode=R");
		      String Hrf_link_A=Hrf_link.concat("&mode=A");           

		   String content = "<html>\n<body>\n";
            content = (new StringBuilder(String.valueOf(content))).append("Dear  Sir/Madam\n").toString();
            content = (new StringBuilder(String.valueOf(content))).append("\n").toString();
            content = (new StringBuilder(String.valueOf(content))).append("<br/><br/>").toString();
            content = (new StringBuilder(String.valueOf(content))).append("<center>").toString();
            content = (new StringBuilder(String.valueOf(content))).append(" ").append(Mail_body).append(" ").toString();
            content = (new StringBuilder(String.valueOf(content))).append("</center>").toString();
            content = (new StringBuilder(String.valueOf(content))).append("<br/><br/>").toString();
            content = (new StringBuilder(String.valueOf(content))).append("</center>").toString();
	  
		   content += "<a ";
           content += " href='"+Hrf_link_A+"' ";
           content += " >";
           content += "<span style='color:green'><Strong><B>Approve</B> </Strong></span></a> &nbsp;&nbsp;&nbsp; <Strong><B>/</B> </Strong> &nbsp;&nbsp;&nbsp; <a href='"+Hrf_link_R+"'>  <span style='color:red'><Strong><B>Reject</B> </Strong></span>";
           content += "</a>";
		   
			/*
            content = (new StringBuilder(String.valueOf(content))).append("<a ").toString();
			
            content = (new StringBuilder(String.valueOf(content))).append(" href='").append(Hrf_link).append("' ").toString();
            content = (new StringBuilder(String.valueOf(content))).append(" >").toString();
            content = (new StringBuilder(String.valueOf(content))).append("Approved/Reject/View").toString();
			
            content = (new StringBuilder(String.valueOf(content))).append("</a>").toString();
            content = (new StringBuilder(String.valueOf(content))).append("</center>").toString();
			*/
            content = (new StringBuilder(String.valueOf(content))).append("<br/> <br/> <br/>").toString();
            content = (new StringBuilder(String.valueOf(content))).append("Regards ").toString();
            content = (new StringBuilder(String.valueOf(content))).append("<br/> <br/> ").toString();
            content = (new StringBuilder(String.valueOf(content))).append(" ").append(Sender_Name).append(" ").toString();
            content = (new StringBuilder(String.valueOf(content))).append("<br/><br/>").toString();
            content = (new StringBuilder(String.valueOf(content))).append("<br/> ").append(p.getProperty("Notice_mail")).toString();
            content = (new StringBuilder(String.valueOf(content))).append("</body>\n</html>").toString();
            message.setContent(content, "text/html");
            message.setSubject(subject_Mail);
            try
            {
                Transport.send(message);
            }
            catch(Exception ERRRR)
            {
                System.out.println((new StringBuilder("ERRRR~~~~::")).append(ERRRR).toString());
            }
            System.out.println("message sent....");
        }
        catch(MessagingException ex)
        {
            message_update = "FAILD";
            ErrorMessage = ex.toString();
            error_prop.setProperty("MessagingException :: ", ex.toString());
            System.out.println((new StringBuilder("MessagingException :: ")).append(ex.toString()).toString());
            ex.printStackTrace();
        }
        try
        {
            QryUpdate(message_update, ErrorMessage, p, con, updateF1, updateF2, error_prop);
            error_prop.setProperty("QryUpdate ", "Calling");
        }
        catch(Exception Error)
        {
            error_prop.setProperty("QryUpdate ", Error.toString());
            System.out.println((new StringBuilder("Error Message At Query Update Faild::::------------------>")).append(Error).toString());
        }
        LogReport(error_prop);
    }

    public static void QryUpdate(String message_update, String ErrorMessage, Properties p, Connection con, String updateF1, String updateF2, Properties error_prop)
    {
        error_prop.setProperty("QryUpdate ", "Loaded");
        error_prop.setProperty("QryUpdate ", (new StringBuilder(String.valueOf(message_update))).append("~QryUpdate~~").append(ErrorMessage).append("~~~").append(updateF1).append("~~~").append(updateF2).toString());
        System.out.println((new StringBuilder(String.valueOf(message_update))).append("~QryUpdate~~").append(ErrorMessage).append("~~~").append(updateF1).append("~~~").append(updateF2).toString());
        System.out.println((new StringBuilder("Connection ::")).append(con).toString());
        PreparedStatement statement=null;
        try
        {
            
            if(message_update.equalsIgnoreCase("SUCCESS"))
            {
                System.out.println((new StringBuilder("Success Update::")).append(p.getProperty("FetchUpdate_S").toString()).toString());
                statement = con.prepareStatement((new StringBuilder()).append(p.getProperty("FetchUpdate_S").toString()).toString());
                System.out.println((new StringBuilder("statement::")).append(statement).toString());
            } else
            {
                System.out.println((new StringBuilder("Success Faild::")).append(p.getProperty("FetchUpdate_F").toString()).toString());
                statement = con.prepareStatement(p.getProperty("FetchUpdate_F").toString());
            }
            int rowsInserted = 0;
            try
            {
                statement.setString(1, ErrorMessage);
                statement.setInt(2, Integer.parseInt(updateF1));
                statement.setInt(3, Integer.parseInt(updateF2));
                rowsInserted = statement.executeUpdate();
            }
            catch(Exception Eff)
            {
                System.out.println((new StringBuilder("Update Sql Exception ::")).append(Eff).toString());
            }
            error_prop.setProperty("QryUpdate~rowsInserted ", (new StringBuilder()).append(rowsInserted).toString());
            if(rowsInserted > 0)
            {
                if(con != null)
                {
                    con.close();
                }
            } else
            if(con != null)
            {
                con.close();
            }
        }
        catch(Exception e)
        {
            error_prop.setProperty("QryUpdate~Exception ", e.toString());
            System.out.println((new StringBuilder("Error At QryUpdate::")).append(e).toString());
        }finally {
        	if(statement!=null){
        		try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        	 if(con != null)
             {
                 try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
             }
        	
        }
        LogReport(error_prop);
    }

    public static void LogReport(Properties error_prop)
    {
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
            String date = sdf.format(new Date());
            error_prop.setProperty("STATUS", "DONE");
            File file1 = new File((new StringBuilder("C:\\mailconfig_new\\EmailStatusReport_")).append(date).append(".properties").toString());
            if(!file1.exists())
            {
                file1.createNewFile();
            }
            File file = new File((new StringBuilder("C:\\mailconfig_new\\EmailStatusReport_")).append(date).append(".properties").toString());
            FileOutputStream fileOut = new FileOutputStream(file, true);
            error_prop.store(fileOut, "E-mail Success/Faild Status Report");
            fileOut.close();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("Done ....! ");
    }

    public static void main(String args[])
    {
        try
        {
            DoSend();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
