package com.smtp.Enity;

public interface EmailService {
	String sendSimpleMail(EmailDetails details);
	String sendMailWithAttachment(EmailDetails details);
	

}
