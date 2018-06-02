package com.mi.services;

import java.util.List;

import com.mi.model.Event;

public interface EventService {

	
	Event findById(int id);
	
	Event findByEventName(String eventName);
	
	void saveEvent(Event event);
	
	void updateEvent(Event event);
	
	void deleteUserBySSO(String sso);

	List<Event> findAllEvents(); 
}
