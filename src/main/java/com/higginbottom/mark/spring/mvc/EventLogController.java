package com.higginbottom.mark.spring.mvc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.higginbottom.mark.spring.mvc.model.EventLog;
import com.higginbottom.mark.spring.mvc.service.EventLogService;

@Controller
public class EventLogController {
	
	private EventLogService EventLogService;
	private static final Logger logger = LoggerFactory.getLogger(EventLogController.class);
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSSS");

	@Autowired(required=true)
	@Qualifier(value="eventLogService")
	public void setEventLogService(EventLogService es){
		this.EventLogService = es;
	}
	
	@RequestMapping(value = "/eventLog", method = RequestMethod.GET)
	public String listPeople(Model model) {
		model.addAttribute("eventLog", new EventLog());
		model.addAttribute("listEvents", this.EventLogService.listEvents());
		//Log that we are listing the event log!!!
		EventLog el = new EventLog();
		el.setId(dateFormat.format(new Date()));
		el.setEvent("listEvents");
		logger.info(el.toString());
		this.EventLogService.addEvent(el);
		return "eventLog";
	}
	

}
