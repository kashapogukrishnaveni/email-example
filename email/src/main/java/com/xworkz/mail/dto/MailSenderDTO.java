package com.xworkz.mail.dto;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class MailSenderDTO {

	private static Logger logger = Logger.getLogger(MailSenderDTO.class);

	private String emailId;
	private String subject;
	private String body;

	public MailSenderDTO() {
		logger.info("inside getMessage()...Invoked" + this.getClass().getSimpleName() + " obj created!");
	}
}
