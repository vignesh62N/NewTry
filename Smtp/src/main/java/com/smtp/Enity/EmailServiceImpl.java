package com.smtp.Enity;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;
@Service
public class EmailServiceImpl implements EmailService {
	@Autowired 
	private JavaMailSender javaMailSender;
	@Value("${spring.mail.username}") private String sender;
	public String sendSimpleMail(EmailDetails details) {
		try {
			SimpleMailMessage mailMessage= new SimpleMailMessage();
			mailMessage.setFrom(sender);
			mailMessage.setTo(details.getRecipient());
			mailMessage.setText(details.getMsgBody());
			mailMessage.setSubject(details.getSubject());
			mailMessage.setCc(details.getRecipient2());
		
			javaMailSender.send(mailMessage);
			return " Mail send  Sucessfully";
			
		} catch (Exception e) {
			return "Error While Sending Mail";
		}
		
	}
	public String sendMailWithAttachment(EmailDetails details) {
		MimeMessage mm= javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		try {
			mimeMessageHelper= new MimeMessageHelper(mm,true);
			mimeMessageHelper.setFrom(sender);
			mimeMessageHelper.setTo(details.getRecipient2());
			mimeMessageHelper.setText(details.getMsgBody());
			mimeMessageHelper.setSubject(details.getSubject());
			mimeMessageHelper.setCc(details.getRecipient());
		//	mimeMessageHelper.setTo(new String[]{details.getRecipient(),details.getRecipient2()});
			
			
			FileSystemResource file=new FileSystemResource(new File(details.getAttachment()));
			mimeMessageHelper.addAttachment(file.getFilename(), file);
			javaMailSender.send(mm);
			return "Mail sent Successfully";
		} catch (Exception e) {
			return "Error While sending mail";
		}
	}

}
