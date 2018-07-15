package com.mi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="Dissertation")
@Table(name="MEMOIRES")
public class Dissertation implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_MEMOIRE")
	private int idDissertation;
	
	@Column(name="RESUME_MEMOIRE")
	private String dissertationAbstract;
	
	@Column(name="THEME_MEMOIRE")
	private String dissertationTheme;
	
	/*@Column(name="RAPPORTEUR")
	private String reporter;
	
	@Column(name="EXAMINATEUR")
	private String examiner;
	
	@Column(name="PRESIDENT_JURY")
	private String juryPresident;
	
	@Column(name="MENTION_OBTENUE")
	private String grade;
	
	@Column(name="ANNEE_SOUTENANCE")
	private Date defenceYear;*/
	
	@Column(name="ID_OPTION")
	private Option option;
	
	@OneToOne(optional=false)
	@JoinColumn(name="ID_CANDIDAT", unique=true)
	private Student candidate;
	
	/*@Column(name="STATUT_MEMOIRE")
	private String status = "NON TRAITE";
	*/
	
	public Dissertation() {
		
	}

	/**
	 * @return the idDissertation
	 */
	public int getIdDissertation() {
		return idDissertation;
	}

	/**
	 * @param idDissertation the idDissertation to set
	 */
	public void setIdDissertation(int idDissertation) {
		this.idDissertation = idDissertation;
	}

	/**
	 * @return the dissertationAbstract
	 */
	public String getDissertationAbstract() {
		return dissertationAbstract;
	}

	/**
	 * @param dissertationAbstract the dissertationAbstract to set
	 */
	public void setDissertationAbstract(String dissertationAbstract) {
		this.dissertationAbstract = dissertationAbstract;
	}

	/**
	 * @return the dissertationTheme
	 */
	public String getDissertationTheme() {
		return dissertationTheme;
	}

	/**
	 * @param dissertationTheme the dissertationTheme to set
	 */
	public void setDissertationTheme(String dissertationTheme) {
		this.dissertationTheme = dissertationTheme;
	}

	
	public Option getOption() {
		return option;
	}

	public void setOption(Option option) {
		this.option = option;
	}

	/**
	 * @return the candidate
	 */
	public Student getCandidate() {
		return candidate;
	}

	/**
	 * @param candidate the candidate to set
	 */
	public void setCandidate(Student candidate) {
		this.candidate = candidate;
	}

}
