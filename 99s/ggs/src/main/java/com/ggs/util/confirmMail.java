package com.ggs.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class ConfirmMail {
	
	//메일 보내기
	public int sendMail(String mailAddress){
		
		String host 	= "smtp.naver.com";   		//네이버 메일 이용
		String user 	= "desertfish@naver.com";   //보내는 사람 네이버 메일 주소
		String password = "desert8304";              //보내는 사람 네이버 비밀번호
		
		//String to = mailAddress;         			// 받은사람 메일 주소
		
		Properties props = new Properties();
		int random= (int)(Math.random()*1000000);
		
		props.put("mail.smtp.host", host);			//smtp 설정값
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "ture");
		props.put("mail.smtp.ssl.trust", host);
		
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		
		session.setDebug(true);
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailAddress));
			
			message.setSubject("99s 인증번호 발송 메일 입니다.");     //메일 제목
			  
			message.setText("인증번호 : "+random);    //메일 내용    
			
			Transport.send(message);
			System.out.println("success");
			
		}catch(AddressException e) {
			e.printStackTrace();
		}catch(MessagingException e) {
			e.printStackTrace();
		}
					
		return random;
	}

}
