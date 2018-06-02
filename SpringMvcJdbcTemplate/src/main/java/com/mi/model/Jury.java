package com.mi.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="JURY")
public class Jury implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="JURY_ID")
	private Integer idJury;
	
	@Column(name="ANNEE_ACADEMIQUE")
	private String academicYear;
	
	@Column(name="PRESIDENT_JURY")
	private Integer juryPresident;
	
	//@ManyToOne
	//@JoinColumn(name="NIVEAU_ID")
	private Integer juryLevel;
	
	//@ManyToMany
	//@JoinTable(name="MEMBRES_JURY")
	//private List<Teacher> members;
	
	public Jury() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param academicYear
	 * @param juryPresident
	 * @param juryLevel
	 */
	public Jury(String academicYear, Integer juryPresident, Integer juryLevel) {
		super();
		this.academicYear = academicYear;
		this.juryPresident = juryPresident;
		this.juryLevel = juryLevel;
	}

	/**
	 * @return the idJury
	 */
	public Integer getIdJury() {
		return idJury;
	}

	/**
	 * @param idJury the idJury to set
	 */
	public void setIdJury(Integer idJury) {
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
	public int getJuryPresident() {
		return juryPresident;
	}

	/**
	 * @param juryPresident the juryPresident to set
	 */
	public void setJuryPresident(Integer juryPresident) {
		this.juryPresident = juryPresident;
	}

	/**
	 * @return the juryLevel
	 */
	public int getJuryLevel() {
		return juryLevel;
	}

	/**
	 * @param juryLevel the juryLevel to set
	 */
	public void setJuryLevel(Integer juryLevel) {
		this.juryLevel = juryLevel;
	}

	/**
	 * @return the members
	 */
	
	
}
