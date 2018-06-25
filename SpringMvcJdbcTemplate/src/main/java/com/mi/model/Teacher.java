package com.mi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="ENSEIGNANTS")
//@AttributeOverride(name="ID",column=@Column(name="ID_ENSEIGNANT"))
public class Teacher extends InternetSufer implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ENSEIGNANT_ID")
	private Long idTeacher;
//	
//	@Column(name="LOGIN")
//	private String login;
//	
//	@Column(name="PASSWORD")
//	private String password;
	
	@Column(name="MATRICULE")
	private String matricule;
	
	@Column(name="DESCRIPTION")
	private String descriptionEnseignant;
	
	@Embedded
	private CV cv;
	
	@ManyToOne
	@JoinColumn(name="GRADE_ID")
	private Grade grade;
	
	@ManyToMany(mappedBy="members")
	private Set<Jury> jury = new HashSet<Jury>();
	
	@OneToMany(mappedBy="juryPresident")
	private Set<Jury> presidedJury = new HashSet<Jury>();
	
	public Teacher() {
		super();
		
	}

	/**
	 * @param lastName
	 * @param firstName
	 * @param emailAdress
	 * @param login
	 * @param password
	 * @param phoneNumber
	 * @param sexe
	 * @param birthDate
	 * @param birthPlace
	 * @param cv
	 * @param grade
<<<<<<< HEAD
	 */
	public Teacher(String lastName, String firstName, String emailAdress, String login, String password,String passwordSec,
			String phoneNumber, String sexe, Date birthDate, String birthPlace, CV cv, Grade grade) {
		super(lastName, firstName, emailAdress, login, password, passwordSec, phoneNumber, sexe, birthDate, birthPlace);
		this.cv = cv;
		this.grade = grade;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * @return the descriptionEnseignant
	 */
	public String getDescriptionEnseignant() {
		return descriptionEnseignant;
	}

	/**
	 * @param descriptionEnseignant the descriptionEnseignant to set
	 */
	public void setDescriptionEnseignant(String descriptionEnseignant) {
		this.descriptionEnseignant = descriptionEnseignant;
	}

	/**
	 * @return the presidedJury
	 */
	public Set<Jury> getPresidedJury() {
		return presidedJury;
	}

	/**
	 * @param presidedJury the presidedJury to set
	 */
	public void setPresidedJury(Set<Jury> presidedJury) {
		this.presidedJury = presidedJury;
	}

	/**
	 * @return the idTeacher
	 */
	public Long getIdTeacher() {
		return idTeacher;
	}

	/**
	 * @param idTeacher the idTeacher to set
	 */
	public void setIdTeacher(Long idTeacher) {
		this.idTeacher = idTeacher;
	}

	/**
	 * @return the cv
	 */
	public CV getCv() {
		return cv;
	}

	/**
	 * @param cv the cv to set
	 */
	public void setCv(CV cv) {
		this.cv = cv;
	}

	/**
	 * @return the grade
	 */
	public Grade getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	/**
	 * @return the jury
	 */
	public Set<Jury> getJury() {
		return jury;
	}

	/**
	 * @param jury the jury to set
	 */
	public void setJury(Set<Jury> jury) {
		this.jury = jury;
	}
	
	

}
