package com.mi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="EVENEMENTS")
public class Event implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EVENEMENT_ID")
	private Integer idEvent;
	
	@Column(name="TITRE_EVENEMENT")
	private String eventTitle;
	
	@Column(name="DESCRIPTION_EVENEMENT")
	private String eventDescription;
	
	@Column(name="DATE_DEBUT_EVENEMENT")
	private Date eventBeginDate;
	
	@Column(name="DATE_FIN_EVENEMENT")
	private Date eventEndDate;
	
	/*//@ManyToMany
	@JoinTable(name="INSCRIPTIONS_EVENEMENTS")
	private Set<InternetSufer> subscribers;
*/
	public Event() {
		// TODO Auto-generated constructor stub
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
	public Integer getIdEvent() {
		return idEvent;
	}


	/**
	 * @param idEvent the idEvent to set
	 */
	public void setIdEvent(Integer idEvent) {
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
	 * @return the subscribers
	 */
	/*public Set<InternetSufer> getSubscribers() {
		return subscribers;
	}


	*//**
	 * @param subscribers the subscribers to set
	 *//*
	public void setSubscribers(Set<InternetSufer> subscribers) {
		this.subscribers = subscribers;
	}*/
	
}
