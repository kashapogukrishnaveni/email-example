package com.xworkz.mail.util;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.xworkz.mail.exception.UtilException;
import com.xworkz.mail.service.MailSenderService;

@Service
public class MailSenderUtilImpl implements MailSenderUtil {
	private static Logger logger = Logger.getLogger(MailSenderUtilImpl.class);

	@Autowired
	private MailSenderService service;

	@Autowired
	private JavaMailSender mailSender;

	public MailSenderUtilImpl() {
		logger.info("inside getMessage()...Invoked" + this.getClass().getSimpleName() + " obj created!");
	}

	@Override
	public boolean sendMailTo(String toEmailId, String body, String subject) throws UtilException {
		logger.info("---inside sendMail() of class:" + this.getClass().getSimpleName() + "---");
		boolean status = false;

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(toEmailId);
		message.setSubject(subject);
		message.setText(body);
		mailSender.send(message);

		return true;
	}
}
