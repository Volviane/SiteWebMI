package com.mi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PARTICIPATION")
public class Participation implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PARTICIPATION")
	private long idParticipation;
	
	@ManyToOne
	@JoinColumn(name="ID_PARTICIPANT")
	private Student participant;
	
	@ManyToOne
	@JoinColumn(name="ID_EVENEMENT")
	private Event event;
	
	@OneToOne
	@JoinColumn(name="ID_ARTICLE")
	private Article studentArticle;
	
	public Participation() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the idParticipation
	 */
	public long getIdParticipation() {
		return idParticipation;
	}

	/**
	 * @param idParticipation the idParticipation to set
	 */
	public void setIdParticipation(long idParticipation) {
		this.idParticipation = idParticipation;
	}

	/**
	 * @return the participant
	 */
	public Student getParticipant() {
		return participant;
	}

	/**
	 * @param participant the participant to set
	 */
	public void setParticipant(Student participant) {
		this.participant = participant;
	}

	/**
	 * @return the event
	 */
	public Event getEvent() {
		return event;
	}

	/**
	 * @param event the event to set
	 */
	public void setEvent(Event event) {
		this.event = event;
	}

	/**
	 * @return the studentArticle
	 */
	public Article getStudentArticle() {
		return studentArticle;
	}

	/**
	 * @param studentArticle the studentArticle to set
	 */
	public void setStudentArticle(Article studentArticle) {
		this.studentArticle = studentArticle;
	}

}
