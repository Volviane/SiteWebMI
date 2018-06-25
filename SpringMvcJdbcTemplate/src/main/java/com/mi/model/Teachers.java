package com.mi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;
//import javax.validation.constraints.Email;

@Entity
@Table(name="ENSEIGNANT")
public class Teachers extends InternetSufer implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ENSEIGNANT_ID")
	private Integer idTeacher;
	
	@Embedded
	private CV cv;
	
	/*@ManyToOne
	@JoinColumn(name="teachers")*/
	private Integer grade;
	
	//@ManyToMany(mappedBy="members")
	//private Set<Jury> jury;
	
	public Teachers() {
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
	public Teachers(String lastName, String firstName,  String emailAdress, String login, String password,String passwordSec,
			String phoneNumber, String sexe, Date birthDate, String birthPlace,  Integer grade) {
		super(lastName, firstName, emailAdress, login, password,passwordSec, phoneNumber, sexe, birthDate, birthPlace);
		
		this.grade = grade;
	}

	/**
	 * @return the idTeacher
	 */
	public Integer getIdTeacher() {
		return idTeacher;
	}

	/**
	 * @param idTeacher the idTeacher to set
	 */
	public void setIdTeacher(Integer idTeacher) {
		this.idTeacher = idTeacher;
	}

	/**
	

	/**
	 * @return the grade
	 */
	public Integer getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	
	
	

}
