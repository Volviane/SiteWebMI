package com.mi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mi.model.Participation;
import com.mi.model.Student;
import com.mi.model.Event;

public interface ParticipationRepository extends JpaRepository<Participation, String>{
	
	public Participation findByParticipantAndEvent(Student participant,Event event);

}
