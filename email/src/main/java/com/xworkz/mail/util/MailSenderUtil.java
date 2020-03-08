package com.xworkz.mail.util;

import com.xworkz.mail.exception.UtilException;

public interface MailSenderUtil {

	public boolean sendMailTo(String toEmailId, String body, String subject) throws UtilException;

}
