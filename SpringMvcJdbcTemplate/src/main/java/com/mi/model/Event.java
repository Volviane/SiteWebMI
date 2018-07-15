package com.mi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="EVENEMENTS")
public class Event implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_EVENEMENT")
	private Long idEvent;
	
	@Column(name="TITRE_EVENEMENT")
	private String eventTitle;
	
	@Column(name="DESCRIPTION_EVENEMENT")
	private String eventDescription;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATE_DEBUT_EVENEMENT")
	private Date eventBeginDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATE_FIN_EVENEMENT")
	private Date eventEndDate;
	
	@Temporal(TemporalType.TIME)
	@Column(name="DATE_DEBUT_INSCRIPTION")
	private Date inscriptionBeginDate;
	
	@Temporal(TemporalType.TIME)
	@Column(name="DATE_FIN_INSCRIPTION")
	private Date inscriptionEndDate;
	
	@Column(name="STATUT_PUBLICATION")
	private boolean isPublish = false;
	
	@Column(name="STATUT_EVENT")
	private String eventStatus;
	
	@OneToMany(mappedBy="event")
	private Set<Participation> participations = new HashSet<Participation>();

	public Event() {
	}

	public void publish(){
		isPublish = true;
	}

	/**
	 * @param eventTitle
	 * @param eventDescription
	 * @param eventBeginDate
	 * @param eventEndDate
	 */
	public Event(String eventTitle, String eventDescription, Date eventBeginDate, Date eventEndDate) {
		super();
		this.eventTitle = eventTitle;
		this.eventDescription = eventDescription;
		this.eventBeginDate = eventBeginDate;
		this.eventEndDate = eventEndDate;
	}


	/**
	 * @return the idEvent
	 */
	public Long getIdEvent() {
		return idEvent;
	}


	/**
	 * @param idEvent the idEvent to set
	 */
	public void setIdEvent(Long idEvent) {
		this.idEvent = idEvent;
	}


	/**
	 * @return the eventTitle
	 */
	public String getEventTitle() {
		return eventTitle;
	}


	/**
	 * @param eventTitle the eventTitle to set
	 */
	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}


	/**
	 * @return the eventDescription
	 */
	public String getEventDescription() {
		return eventDescription;
	}


	/**
	 * @param eventDescription the eventDescription to set
	 */
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}


	/**
	 * @return the eventBeginDate
	 */
	public Date getEventBeginDate() {
		return eventBeginDate;
	}


	/**
	 * @param eventBeginDate the eventBeginDate to set
	 */
	public void setEventBeginDate(Date eventBeginDate) {
		this.eventBeginDate = eventBeginDate;
	}


	/**
	 * @return the eventEndDate
	 */
	public Date getEventEndDate() {
		return eventEndDate;
	}


	/**
	 * @param eventEndDate the eventEndDate to set
	 */
	public void setEventEndDate(Date eventEndDate) {
		this.eventEndDate = eventEndDate;
	}


	/**
	 * @return the inscriptionBeginDate
	 */
	public Date getInscriptionBeginDate() {
		return inscriptionBeginDate;
	}


	/**
	 * @param inscriptionBeginDate the inscriptionBeginDate to set
	 */
	public void setInscriptionBeginDate(Date inscriptionBeginDate) {
		this.inscriptionBeginDate = inscriptionBeginDate;
	}


	/**
	 * @return the inscriptionEndDate
	 */
	public Date getInscriptionEndDate() {
		return inscriptionEndDate;
	}


	/**
	 * @param inscriptionEndDate the inscriptionEndDate to set
	 */
	public void setInscriptionEndDate(Date inscriptionEndDate) {
		this.inscriptionEndDate = inscriptionEndDate;
	}


	/**
	 * @return the participations
	 */
	public Set<Participation> getParticipations() {
		return participations;
	}


	/**
	 * @param participations the participations to set
	 */
	public void setParticipations(Set<Participation> participations) {
		this.participations = participations;
	}


	/**
	 * @return the isPublish
	 */
	public boolean isPublish() {
		return isPublish;
	}


	/**
	 * @param isPublish the isPublish to set
	 */
	public void setPublish(boolean isPublish) {
		this.isPublish = isPublish;
	}

	/**
	 * @return the eventStatus
	 */
	public String getEventStatus() {
		return eventStatus;
	}

	/**
	 * @param eventStatus the eventStatus to set
	 */
	public void setEventStatus(String eventStatus) {
		Date currentDate = new Date();
		if(this.eventStatus != null) 
			this.eventStatus = eventStatus;
		else{
			if(currentDate.after(eventBeginDate)){
				eventStatus = "EN COURS";
			}
			else if(currentDate.before(eventBeginDate)){
				eventStatus = "EN APPROCHE";
			}			
		}
		
	}

}
