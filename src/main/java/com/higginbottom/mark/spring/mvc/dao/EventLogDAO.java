package com.higginbottom.mark.spring.mvc.dao;

import java.util.List;

import com.higginbottom.mark.spring.mvc.model.EventLog;

public interface EventLogDAO {

	public void addEvent(EventLog e);
	public List<EventLog> listEvents();
}
