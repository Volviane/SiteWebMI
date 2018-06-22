package com.mi.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="JURY")
public class Jury implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_JURY")
	private Long idJury;
	
	@Column(name="ANNEE_ACADEMIQUE")
	private String academicYear;
	
	@ManyToOne					// Plusieurs Juris peuvent avoir le même président
	@JoinColumn(name="PRESIDENT_JURY")
	private Teacher juryPresident;
	
	@ManyToOne					// Plusieurs juris concernent le même niveau
	@JoinColumn(name="ID_NIVEAU")
	private Level juryLevel;
	
	@ManyToMany					//Un jury est constitué de plusieurs enseignants et un enseignant peut appartenir à plusieurs juris
	@JoinTable(name="MEMBRES_JURY")
	private Set<Teacher> members;
	
	public Jury() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param academicYear
	 * @param juryPresident
	 * @param juryLevel
	 */
	public Jury(String academicYear, Teacher juryPresident, Level juryLevel) {
		super();
		this.academicYear = academicYear;
		this.juryPresident = juryPresident;
		this.juryLevel = juryLevel;
	}

	/**
	 * @return the idJury
	 */
	public Long getIdJury() {
		return idJury;
	}

	/**
	 * @param idJury the idJury to set
	 */
	public void setIdJury(Long idJury) {
		this.idJury = idJury;
	}

	/**
	 * @return the academicYear
	 */
	public String getAcademicYear() {
		return academicYear;
	}

	/**
	 * @param academicYear the academicYear to set
	 */
	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}

	/**
	 * @return the juryPresident
	 */
	public Teacher getJuryPresident() {
		return juryPresident;
	}

	/**
	 * @param juryPresident the juryPresident to set
	 */
	public void setJuryPresident(Teacher juryPresident) {
		this.juryPresident = juryPresident;
	}

	/**
	 * @return the juryLevel
	 */
	public Level getJuryLevel() {
		return juryLevel;
	}

	/**
	 * @param juryLevel the juryLevel to set
	 */
	public void setJuryLevel(Level juryLevel) {
		this.juryLevel = juryLevel;
	}

	/**
	 * @return the members
	 */
	public Set<Teacher> getMembers() {
		return members;
	}

	/**
	 * @param members the members to set
	 */
	public void setMembers(Set<Teacher> members) {
		this.members = members;
	}
	
}
