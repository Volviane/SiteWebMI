package com.mi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mi.model.Participation;
import com.mi.model.Student;
import com.mi.model.Event;

public interface ParticipationRepository extends JpaRepository<Participation, String>{
	
	public Participation findByParticipantAndEvent(Student participant,Event event);

	//Retourne la liste de toutes les participations � un �v�nements
	public List<Participation> findByEvent(Event event);
	
	//Retourne la liste de toutes les participations d'un �tudiant aux �v�nements
	public List<Participation> findByParticipant(Student participant);
	
	
	//Compte le nombre d'inscrits � un �v�nement, soit le nombre de participations � l'�v�nement
	public Long countByEvent(Event event);
	
	//Compte le nombre d'�v�nements auxquels a particip� un �tudiant, soit le nombre de participations d'un �tudiant aux �v�nements
	public Long countByParticipant(Student participant);
	
}
