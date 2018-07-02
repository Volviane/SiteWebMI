package com.mi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mi.model.Participation;
import com.mi.model.Student;
import com.mi.model.Event;

public interface ParticipationRepository extends JpaRepository<Participation, String>{
	
	public Participation findByParticipantAndEvent(Student participant,Event event);

	public List<Participation> findByEvent(Event event);
}
