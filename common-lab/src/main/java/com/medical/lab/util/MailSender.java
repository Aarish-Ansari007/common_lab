package com.medical.lab.util;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;

@Service
public class MailSender {

	public Boolean sendMail(String to, String subject, String[] attachFiles)
	{
	
	  String result;
	  String from="mohammedaarif.ansari7@gmail.com";
	  String host = "smtp.gmail.com";
	  Properties properties = System.getProperties();
	  properties.setProperty("mail.transport.protocol", "smtp");     
	  properties.setProperty("mail.smtp.host", host);
	  properties.put("mail.smtp.auth", "true");  
	  properties.put("mail.smtp.port", "465");  
	  properties.put("mail.debug", "true");  
	  properties.put("mail.smtp.socketFactory.port", "465");  
	  properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
	  properties.put("mail.smtp.socketFactory.fallback", "false");
	  properties.put("mail.smtp.ssl.enable", "true");
	  Session mailSession = Session.getDefaultInstance(properties,  
	   new javax.mail.Authenticator() {
	      protected PasswordAuthentication getPasswordAuthentication() {  
//	      return new PasswordAuthentication("egovdolg@gmail.com","egov2017"); 
	      return new PasswordAuthentication("mohammedaarif.ansari7@gmail.com","Ad@min123");
	  }});  
	  try {

	  Transport transport = mailSession.getTransport();  
	  InternetAddress addressFrom = new InternetAddress(from);  
	  MimeMessage message = new MimeMessage(mailSession); 
	  message.setSender(addressFrom);  
	  message.setSubject(subject); 
	  
	  
	  MimeBodyPart messageBodyPart = new MimeBodyPart();
	  messageBodyPart.setText("Dear Customer,<br> Please refer to attachment for statement of account for your record<br>"
	  		+ "if there is any discrepancy, please notify us within 14days from then email date.<br>"
	  		+ "Thank you.<br>"
	  		+ "********************************************************************<br>"
	  		+ "Note: This is an automated system genrated latter from dept.<br>"
	  		+ "********************************************************************");
//	  messageBodyPart.setContent(message, "application/pdf");
//	  messageBodyPart.setFileName(fileName);
	 
	  Multipart multipart = new MimeMultipart();
	  multipart.addBodyPart(messageBodyPart);
	  
	// adds attachments
      if (attachFiles != null && attachFiles.length > 0) {
          for (String filePath : attachFiles) {
              MimeBodyPart attachPart = new MimeBodyPart();

              try {
                  attachPart.attachFile(filePath);
              } catch (IOException ex) {
                  ex.printStackTrace();
              }

              multipart.addBodyPart(attachPart);
          }
      }

      message.setContent(multipart);
//	  message.setContent(body, "text/plain");  
	  message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));  

	  transport.connect();  
	  Transport.send(message);  
	  transport.close();
	  return true;	
	  } 
	  catch (MessagingException mex) {
	     mex.printStackTrace();
	     result = "Error: unable to send message....";
	     System.out.print(result + mex);
	   return false;
	  }
	}
	
	
	
	


}
