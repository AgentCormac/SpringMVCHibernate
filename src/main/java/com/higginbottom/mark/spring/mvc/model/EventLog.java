package com.higginbottom.mark.spring.mvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author higginbottomm
 *
 */
@Entity
@Table(name="eventLog")
public class EventLog {

	@Id
	@Column(name="id")
	private String id;
	
	private String event;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}
	
	@Override
	public String toString(){
		return "id="+id+", event="+event;
	}
}
