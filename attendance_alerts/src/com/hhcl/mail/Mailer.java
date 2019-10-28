
package com.hhcl.mail;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;



public class Mailer {
	
	Properties error_prop=new Properties();
	static final Logger LOGGER = Logger.getLogger(MailServices.class);
	
public  void send(StringBuffer toMail,String subject,String msg,StringBuffer CC_mail,String Name){

final String user="noreply@heterohealthcare.com";//change accordingly
final String pass="Hhcl@123";
//1st step) Get the session object	
Properties props = new Properties();
/*props.put("mail.smtp.host", "mail.javatpoint.com");//change accordingly
props.put("mail.smtp.auth", "true");*/

   /* props.put("mail.smtp.host","czismtp.logix.in");  
	props.put("mail.smtp.port","587"); 
	props.put("mail.smtp.starttls.enable", "true");
	//props.put("mail.transport.protocol", "true");
	props.put("mail.smtp.auth", "true");*/
	
	    props.put("mail.smtp.host","smtp.office365.com");  
		props.put("mail.smtp.port","587"); 
		props.put("mail.smtp.starttls.enable", "true");
		//props.put("mail.transport.protocol", "true");
		props.put("mail.smtp.auth", "true");
		

Session session = Session.getDefaultInstance(props,
new javax.mail.Authenticator() {
protected PasswordAuthentication getPasswordAuthentication() {
return new PasswordAuthentication(user,pass);
   }
});
//2nd step)compose message
try {
//StringBuffer toMail=new StringBuffer();
//toMail.append(to);
 MimeMessage message = new MimeMessage(session);
 message.setFrom(new InternetAddress(user));
 //message.addRecipient(Message.RecipientType.TO,new InternetAddress(toMail.toString()));
 message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toMail.toString(), false));
 
 try {
 message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(CC_mail.toString()));
 }catch(Exception emm) {
	emm.printStackTrace(); 
	
	LOGGER.debug("CC MAIL Error Sending mail at Mailer:" + emm);
	
 }
 
 
 message.setSubject(subject);
/* message.setText("Dear " + Name+" ,");
 message.setText(" ");
 message.setText(" ");
 message.setText(" \n\n\n");*/
 
 message.setContent(msg , "text/html");
 
 /*message.setText(" \n\n\n");
 
 message.setText("Regards");
 message.setText("\n");
 message.setText("Hetero HealthCare & Azista industries");
 */
 //3rd step)send message
 Transport.send(message);

 System.out.println("Done");

 } catch (MessagingException e) {
	 
	 LOGGER.debug("MessagingException Error Sending mail at Mailer:" + e);
	throw new RuntimeException(e);
	
	 
	
 }
	
}
}
