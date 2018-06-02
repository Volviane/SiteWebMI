package com.mi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mi.dao.EventDAO;
import com.mi.model.Event;

@Service("eventService")
@Transactional
public class EventServiceImpl implements EventService {

	@Autowired
	EventDAO eventDao;
	
	@Override
	public Event findById(int id) {
		// TODO Auto-generated method stub
		return eventDao.findOne(id);
	}

	@Override
	public Event findByEventName(String eventName) {
		// TODO Auto-generated method stub
		return eventDao.findByEventName(eventName);
	}

	@Override
	public void saveEvent(Event event) {
		// TODO Auto-generated method stub
		eventDao.save(event);
		
	}

	@Override
	public void updateEvent(Event event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserBySSO(String sso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Event> findAllEvents() {
		// TODO Auto-generated method stub
		return eventDao.findAll();
	}

}
