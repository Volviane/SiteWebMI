package com.mi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="ENSEIGNANT")
public class Teacher extends InternetSufer implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ENSEIGNANT_ID")
	private Long idTeacher;
	
	@Embedded
	private CV cv;
	
	@ManyToOne
	@JoinColumn(name="teachers")
	private Grade grade;
	
	@ManyToMany(mappedBy="members")
	private Set<Jury> jury = new HashSet<Jury>();
	
	@OneToMany(mappedBy="juryPresident")
	private Set<Jury> presidedJury = new HashSet<Jury>();
	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
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
	 */
	public Teacher(String lastName, String firstName, String emailAdress, String login, String password,
			String phoneNumber, String sexe, Date birthDate, String birthPlace, CV cv, Grade grade) {
		super(lastName, firstName, emailAdress, login, password, phoneNumber, sexe, birthDate, birthPlace);
		this.cv = cv;
		this.grade = grade;
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
