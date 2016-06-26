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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.higginbottom.mark.spring.mvc.model.EventLog;
import com.higginbottom.mark.spring.mvc.service.EventLogService;
import com.higginbottom.mark.spring.mvc.service.EventLogServiceImpl;
import com.higginbottom.mark.spring.mvc.model.Person;
import com.higginbottom.mark.spring.mvc.service.PersonService;

@Controller
public class PersonController {
	
	private PersonService personService;
	private EventLogService EventLogService;
	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSSS");
	private EventLog el = new EventLog();

	@Autowired(required=true)
	@Qualifier(value="personService")
	public void setPersonService(PersonService ps){
		this.personService = ps;
	}
	
	@Autowired(required=true)
	@Qualifier(value="eventLogService")
	public void setEventLogService(EventLogService es){
		this.EventLogService = es;
	}
	@RequestMapping(value = "/person", method = RequestMethod.GET)
	public String listPeople(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listPeople", this.personService.listPeople());
		el.setId(dateFormat.format(new Date()));
		el.setEvent("list people");
		logger.info(el.toString());
		logger.info(this.EventLogService.toString());
		this.EventLogService.addEvent(el);
		return "person";
	}
	
	//For add and update person both
	@RequestMapping(value= "/person/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Person p){
		el.setId(dateFormat.format(new Date()));
		
		if(p.getId() == 0){
			//new person, add it
			this.personService.addPerson(p);
			el.setEvent("add person - " +p.toString());
		}else{
			//existing person, call update
			this.personService.updatePerson(p);
			el.setEvent("update person - " + p.toString());
		}
		logger.info(el.toString());
		this.EventLogService.addEvent(el);
		
		return "redirect:/person";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
		
        this.personService.removePerson(id);
		el.setId(dateFormat.format(new Date()));
		el.setEvent("remove person - " + id);
		logger.info(el.toString());
		this.EventLogService.addEvent(el);
        return "redirect:/person";
    }
 
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.personService.getPersonById(id));
        model.addAttribute("listPeople", this.personService.listPeople());
		el.setId(dateFormat.format(new Date()));
		el.setEvent("edit person - " + id);
		logger.info(el.toString());
		this.EventLogService.addEvent(el);
        return "person";
    }
	
}
