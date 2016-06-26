package com.higginbottom.mark.spring.mvc.service;

import java.util.List;

import com.higginbottom.mark.spring.mvc.model.EventLog;

public interface EventLogService {

	public void addEvent(EventLog e);
	public List<EventLog> listEvents();
	
}
