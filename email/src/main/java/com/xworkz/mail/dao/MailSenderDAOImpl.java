package com.xworkz.mail.dao;

import java.io.Serializable;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.mail.entity.MailSenderEntity;

@Repository
public class MailSenderDAOImpl implements MailSenderDAO {

	private static Logger logger = Logger.getLogger(MailSenderDAOImpl.class);

	@Autowired
	private SessionFactory factory;

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public MailSenderDAOImpl() {
		logger.info("inside getMessage()...Invoked :" + this.getClass().getSimpleName());
	}

	@Override
	public Serializable save(MailSenderEntity entity) {
		logger.info("inside getMessage()...Invoking save method");
		Session session = null;
		try {
			logger.info("inside getMessage()...session created");
			session = factory.openSession();
			logger.info("inside getMessage()...Transaction begun");
			session.beginTransaction();
			logger.info("inside getMessage()...Entity saving...");
			session.save(entity);
			logger.info("inside getMessage()...commiting");
			session.getTransaction().commit();
			logger.info("inside getMessage()...Data saved in DB");

		} catch (Exception e) {
			logger.info("INFO:" + e.getMessage());
		} finally {
			if (Objects.nonNull(session)) {
				session.close();
				logger.info("inside getMessage()...Resources closed.");
			}
		}
		return entity;
	}
}