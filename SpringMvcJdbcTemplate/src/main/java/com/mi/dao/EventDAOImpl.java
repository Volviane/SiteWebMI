package com.mi.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mi.model.Cycle;
import com.mi.model.Event;

@Repository("eventDao")
public class EventDAOImpl  extends AbstractDao<Integer, Event> implements EventDAO {

	@Override
	public void save(Event event) {
		persist(event);
		
	}

	@Override
	public void delete(int eventId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Event findByEventName(String eventName) {
		// TODO Auto-generated method stub
		return findByName(eventName);
	}

	@Override
	public Event findOne(int eventId) {
		// TODO Auto-generated method stub
		return getByKey(eventId);
	}

	@Override
	public List<Event> findAll() {
		@SuppressWarnings("unchecked")
		List<Event> event = getEntityManager()
				.createQuery("SELECT u FROM EVENNEMENT u ORDER BY u.titreEvennement ASC")
				.getResultList();
		return event;
	}

}
