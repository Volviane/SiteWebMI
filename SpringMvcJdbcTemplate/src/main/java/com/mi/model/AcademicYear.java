package com.mi.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ANNEES_ACADEMIQUES")
public class AcademicYear implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ANNEE_ACADEMIQUE")
	private Long idAcademicYear;
	
	@Column(name="ANNEE_ACADEMIQUE")
	private String academicYear;
	
	@OneToMany(mappedBy="academicYear")
	private Set<Jury> juries = new HashSet<Jury>();
	
	@Column(name="STATUT_ANNEE")
	private String status = "EN COURS";
	
	public AcademicYear() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the idAcademicYear
	 */
	public Long getIdAcademicYear() {
		return idAcademicYear;
	}


	/**
	 * @param idAcademicYear the idAcademicYear to set
	 */
	public void setIdAcademicYear(Long idAcademicYear) {
		this.idAcademicYear = idAcademicYear;
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
	 * @return the juries
	 */
	public Set<Jury> getJuries() {
		return juries;
	}


	/**
	 * @param juries the juries to set
	 */
	public void setJuries(Set<Jury> juries) {
		this.juries = juries;
	}


	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}

