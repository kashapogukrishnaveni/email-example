package com.xworkz.mail.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Table(name = "email")
@Data
public class MailSenderEntity implements Serializable {
	static Logger logger = Logger.getLogger(MailSenderEntity.class);

	@Id
	@GenericGenerator(name = "madhu", strategy = "increment")
	@GeneratedValue(generator = "madhu")
	@Column(name = "id")
	private int id;
	@Column(name = "emailId")
	private String emailId;
	@Column(name = "subject")
	private String subject = "Greetings";
	@Column(name = "body")
	private String body = "Welcome user!";

	public MailSenderEntity() {
		logger.info("inside getMessage()...Invoked" + this.getClass().getSimpleName() + " obj created!");
	}

}