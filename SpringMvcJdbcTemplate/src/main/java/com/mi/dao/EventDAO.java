package com.mi.dao;

import java.util.List;

import com.mi.model.Event;

public interface EventDAO {
	
	public void save(Event event);
	public void delete(int eventId);
	public Event findByEventName(String eventName);
	public Event findOne(int eventId);
	public List<Event> findAll();

}
