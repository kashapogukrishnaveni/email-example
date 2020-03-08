package com.xworkz.mail.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.mail.exception.ControllerException;
import com.xworkz.mail.exception.ServiceException;
import com.xworkz.mail.service.MailSenderService;

@Controller
@RequestMapping("/")
public class MailSenderController extends ControllerException {
	private static Logger logger = Logger.getLogger(MailSenderController.class);

	@Autowired
	private MailSenderService mailSenderService;

	public MailSenderController() {
		logger.info("inside getMessage()...Invoked" + this.getClass().getSimpleName() + " obj created!");
	}

	@RequestMapping("/sendMail.do")
	public ModelAndView sendEmail(String emailId, String subject, String body) throws ControllerException {
		try {
			logger.info("---inside sendMail()  of class:" + this.getClass().getSimpleName());
			logger.info("Email: " + emailId);
			logger.info("Subject: " + subject);
			logger.info("Body: " + body);
			ModelAndView mv = new ModelAndView("index");
			try {
				mailSenderService.sendMailToUser(emailId, subject, body);
			} catch (ServiceException e) {
				logger.error(e.getMessage(), e);
			}
			mv.addObject("key", "Mail Sent Succesfully");

			return mv;
		} catch (Exception c) {
			try {
				throw new ControllerException(c.getMessage());
			} catch (ControllerException e) {
				logger.error("Exception:" + e.getMessage(), e);

			}
		}
		return null;

	}
}
