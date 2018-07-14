package com.mi.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mi.model.Event;

public interface EventRepository extends JpaRepository<Event, String>{
	public Event findByEventTitle(String eventTitle);
	public Event findByIdEvent(Long idEvent);
	public List<Event> findByEventStatus(String eventStatus);
	
	//Retourne la liste de tous les �v�nements d�j� publi�s
	public List<Event> findByIsPublishTrue();
	
	//Retourne la liste de tous les �v�nements pas encore publi�s
    public List<Event> findByIsPublishFalse();
    
  //Retourne la liste de tous les �v�nements qui n'ont pas encore eu lieu
    public List<Event> findByEventBeginDateBefore(Date now);
    
  //Retourne la liste de tous les �v�nements qui sont encore en cours
    public List<Event> findByEventEndDateAfter(Date now);
    
  //Retourne la liste de tous les �v�nements qui sont d�j� termin�s
    public List<Event> findByEventEndDateBefore(Date now);
    
  //Retourne la liste de tous les �v�nements auxquels on ne peut plus s'incrire ou dont la date d'inscription est pass�
    public List<Event> findByInscriptionEndDateBefore(Date now);
    
  //Retourne la liste de tous les �v�nements auxquels ont peut encore s'inscrire
    public List<Event> findByInscriptionEndDateAfter(Date now);
    
    
    //compte le nombre d'�v�nements en cours
    public long countByEventEndDateAfter(Date now);
    
  //compte le nombre d'�v�nements pas encore publi�s
    public long countByIsPublishFalse();
    
  //compte le nombre d'�v�nements d�j� publi�s
    public long countByIsPublishTrue();
}
