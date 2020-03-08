package com.xworkz.mail.exception;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class UtilException extends Exception {

	private static Logger logger = Logger.getLogger(UtilException.class);

	private String message = ("Exception has occured" + this.getClass().getSimpleName());

	public UtilException() {
		logger.info("inside getMessage()...Invoked" + this.getClass().getSimpleName() + " obj created!");
	}

	public UtilException(String message) {
		this.message = message;
		logger.info("inside getMessage()...Created" + this.getClass().getSimpleName());
	}

	public String getMessage() {
		logger.info("inside getMessage()..." + message);
		return message;
	}
}
