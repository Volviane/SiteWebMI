package com.mi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mi.model.Event;

public interface EventRepository extends JpaRepository<Event, String>{
	public Event findByEventTitle(String eventTitle);

}
