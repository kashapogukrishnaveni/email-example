package com.xworkz.mail.exception;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class ServiceException extends Exception {
	static Logger logger = Logger.getLogger(ServiceException.class);

	private String message = ("Exception has occured" + this.getClass().getSimpleName());

	public ServiceException() {
		logger.info("inside getMessage()...Invoked" + this.getClass().getSimpleName() + " obj created!");
	}

	public ServiceException(String message) {
		this.message = message;
		logger.info("inside getMessage()...Created" + this.getClass().getSimpleName());
	}

	public String getMessage() {
		logger.info("inside getMessage()..." + message);
		return message;
	}

}
