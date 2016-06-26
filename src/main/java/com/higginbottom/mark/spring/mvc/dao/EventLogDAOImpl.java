package com.higginbottom.mark.spring.mvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.higginbottom.mark.spring.mvc.model.EventLog;

@Repository
public class EventLogDAOImpl implements EventLogDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(EventLogDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addEvent(EventLog e) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(e);
		logger.info("Event saved successfully, EventLog Details="+e);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<EventLog> listEvents() {
		Session session = this.sessionFactory.getCurrentSession();
		List<EventLog> eventList = session.createQuery("from EventLog").list();
		for(EventLog e : eventList){
			logger.info("EventLog List::"+e);
		}
		return eventList;
	}


}
