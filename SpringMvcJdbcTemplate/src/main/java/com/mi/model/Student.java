package com.mi.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
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
@Table(name="ETUDIANTS")
//@AttributeOverride(name="ID",column=@Column(name="ID_ETUDIANT"))
public class Student extends InternetSufer implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ETUDIANT_ID")
	private Long idStudent;
	
	@Column(name="MATRICULE", unique=true)
	private String matricule;
	
	@ManyToOne
	@JoinColumn(name="NIVEAU")
	private Level studentLevel;
		
	@OneToMany(mappedBy="author")
	private Set<Article> articles = new HashSet<Article>();
	
	@OneToOne(mappedBy="candidate")
	private Dissertation dissertation;
	
	@OneToMany(mappedBy="participant")
	private Set<Participation> participations = new HashSet<Participation>();
	
	public Student() {
		super();
		
	}
	

	
	


	public Student(Level studentLevel) {
		this.studentLevel = studentLevel;
	}


	public Level getStudentLevel() {
		return studentLevel;
	}


	public void setStudentLevel(Level studentLevel) {
		this.studentLevel = studentLevel;
	}






	/**
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}






	/**
	 * @param matricule the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}






	/**
	 * @return the articles
	 */
	public Set<Article> getArticles() {
		return articles;
	}






	/**
	 * @param articles the articles to set
	 */
	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}






	/**
	 * @return the dissertations
	 */
	public Dissertation getDissertation() {
		return dissertation;
	}






	/**
	 * @param dissertations the dissertations to set
	 */
	public void setDissertation(Dissertation dissertation) {
		this.dissertation = dissertation;
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


	
	
	
	

}
