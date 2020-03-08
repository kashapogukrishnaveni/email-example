package com.xworkz.mail.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.cj.util.Util;
import com.xworkz.mail.dao.MailSenderDAO;
import com.xworkz.mail.entity.MailSenderEntity;
import com.xworkz.mail.exception.ServiceException;
import com.xworkz.mail.exception.UtilException;
import com.xworkz.mail.util.MailSenderUtil;

@Service
public class MailSenderServiceImpl implements MailSenderService {
	private static Logger logger = Logger.getLogger(MailSenderServiceImpl.class);

	@Autowired
	private MailSenderUtil mailSenderUtil;
	
	@Autowired
	private MailSenderDAO dao;

	public MailSenderServiceImpl() {
		logger.info("inside getMessage()...Invoked" + this.getClass().getSimpleName() + " obj created!");
	}

	@Override
	public boolean sendMailToUser(String toEmailId,String subject,String body) throws ServiceException {
		logger.info("---inside sendMailToUser() of class:" + this.getClass().getSimpleName() + "---");
		boolean valid = false;

		if (toEmailId != null && toEmailId.length() > 10 && toEmailId.contains("@")) {
			logger.info("Entered Email Id length is valid");
			valid = true;
			if (valid && subject != null && subject.length() >= 4) {
				logger.info("Entered subject length is valid");
				valid = true;
				if (valid && body != null && body.length() >= 5) {
					logger.info("Entered body length is valid");
					valid = true;
				} else {
					if (body == null && body.length() < 4) {
						logger.info("Not Valid:Body length is less than 4");
					}
				}
			} else {
				if (subject == null && subject.length() < 4) {
					logger.info("Not Valid:Subject length is less than 4");
				}
			}
		} else {
			if (toEmailId == null && toEmailId.length() < 10) {
				logger.info("Not Valid:Email Id length is less than 4");
			}
		}

		if (valid) {
			logger.info("inside getMessage()...Data is valid,Can Save in Database");

			MailSenderEntity mailSenderEntity = new MailSenderEntity();
			mailSenderEntity.setEmailId(toEmailId);
			mailSenderEntity.setSubject(subject);
			mailSenderEntity.setBody(body);
			dao.save(mailSenderEntity);

			try {
				valid = mailSenderUtil.sendMailTo(toEmailId, body, subject);
			} catch (UtilException e) {
				logger.info("Exception: " + e.getMessage());
			}
		
		} else {
			logger.info("inside getMessage()...Data is not saved in Database");
			valid=false;
		}

		return valid;

	}

}
