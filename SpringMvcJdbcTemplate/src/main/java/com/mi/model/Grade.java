package com.mi.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="GRADES")
public class Grade {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_GRADE")
	private Integer idGrade;
	
	@Column(name="NOM_GRADE")
	private String gradeName;
	
	@OneToMany(mappedBy="grade")
	private Set<Teacher> teachers;
	
	public Grade() {
		
	}

	/**
	 * @param gradeName
	 */
	public Grade(String gradeName) {
		super();
		this.gradeName = gradeName;
	}

	/**
	 * @return the idGrade
	 */
	public Integer getIdGrade() {
		return idGrade;
	}

	/**
	 * @param idGrade the idGrade to set
	 */
	public void setIdGrade(Integer idGrade) {
		this.idGrade = idGrade;
	}

	/**
	 * @return the gradeName
	 */
	public String getGradeName() {
		return gradeName;
	}

	/**
	 * @param gradeName the gradeName to set
	 */
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	/**
	 * @return the teachers
	 */
	public Set<Teacher> getTeachers() {
		return teachers;
	}

	/**
	 * @param teachers the teachers to set
	 */
	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	
}
