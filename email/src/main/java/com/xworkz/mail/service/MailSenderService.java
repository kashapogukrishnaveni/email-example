package com.xworkz.mail.service;

import com.xworkz.mail.exception.ServiceException;

public interface MailSenderService {

	public boolean sendMailToUser(String toEmailId,String subject,String body) throws ServiceException;
}
