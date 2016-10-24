package com.lin.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMail {
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
 
	public static void generateAndSendEmail(String fromEmail, String toEmailID, String password) throws AddressException, MessagingException {
 
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
 
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(fromEmail));
//		generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("michael.cong2016@gmail.com"));
		generateMailMessage.setSubject("Your order from SiXiang");
		String emailBody = "Thank you for your order. We will deliver your order ASAP when it get ready. " + "<br><br> Meanwhile, "
				+ "we set up an account for you when you placed the order in order to send you the rewards. The username is email that "
				+ "you used to order food and the default password is '123456'. <br> Please go to our website to update your password "
				+ "ASAP <br><br>Best regards, <br>SiXiang group";
		generateMailMessage.setContent(emailBody, "text/html");
 
		Transport transport = getMailSession.getTransport("smtp");
		transport.connect("smtp.gmail.com", toEmailID, password);
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}
}
