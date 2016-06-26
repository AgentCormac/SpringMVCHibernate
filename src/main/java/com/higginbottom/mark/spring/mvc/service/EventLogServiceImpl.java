package com.higginbottom.mark.spring.mvc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.higginbottom.mark.spring.mvc.dao.EventLogDAO;
import com.higginbottom.mark.spring.mvc.model.EventLog;

@Service
public class EventLogServiceImpl implements EventLogService {
	
	private EventLogDAO eventLogDAO;

	public void setEventLogDAO(EventLogDAO eventLogDAO) {
		this.eventLogDAO = eventLogDAO;
	}

	@Override
	@Transactional
	public void addEvent(EventLog e) {
		this.eventLogDAO.addEvent(e);
	}

	@Override
	@Transactional
	public List<EventLog> listEvents() {
		return this.eventLogDAO.listEvents();
	}

}
