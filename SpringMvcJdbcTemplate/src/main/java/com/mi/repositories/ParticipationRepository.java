package com.mi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mi.model.Participation;
import com.mi.model.Student;
import com.mi.model.Event;

public interface ParticipationRepository extends JpaRepository<Participation, String>{
	
	public Participation findByParticipantAndEvent(Student participant,Event event);

	//Retourne la liste de toutes les participations à un évènements
	public List<Participation> findByEvent(Event event);
	
	//Retourne la liste de toutes les participations d'un étudiant aux évènements
	public List<Participation> findByParticipant(Student participant);
	
	
	//Compte le nombre d'inscrits à un évènement, soit le nombre de participations à l'évènement
	public Long countByEvent(Event event);
	
	//Compte le nombre d'évènements auxquels a participé un étudiant, soit le nombre de participations d'un étudiant aux évènements
	public Long countByParticipant(Student participant);
	
}
