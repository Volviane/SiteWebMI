package com.mi.model;

import java.io.Serializable;

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
	
	@Column(name="RAPPORTEUR")
	private String reporter;
	
	@Column(name="EXAMINATEUR")
	private String examiner;
	
	@Column(name="PRESIDENT_JURY")
	private String juryPresident;
	
	@Column(name="MENTION_OBTENUE")
	private String grade;
	
	@Column(name="ANNEE_SOUTENANCE")
	private String defenceYear;
	
	@Column(name="OPTION")
	private String option;
	
	@OneToOne(optional=false)
	@JoinColumn(name="CANDIDAT", unique=true)
	private Student candidate;
	
	public Dissertation() {
		// TODO Auto-generated constructor stub
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

	/**
	 * @return the reporter
	 */
	public String getReporter() {
		return reporter;
	}

	/**
	 * @param reporter the reporter to set
	 */
	public void setReporter(String reporter) {
		this.reporter = reporter;
	}

	/**
	 * @return the examiner
	 */
	public String getExaminer() {
		return examiner;
	}

	/**
	 * @param examiner the examiner to set
	 */
	public void setExaminer(String examiner) {
		this.examiner = examiner;
	}

	/**
	 * @return the juryPresident
	 */
	public String getJuryPresident() {
		return juryPresident;
	}

	/**
	 * @param juryPresident the juryPresident to set
	 */
	public void setJuryPresident(String juryPresident) {
		this.juryPresident = juryPresident;
	}

	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * @return the defenceYear
	 */
	public String getDefenceYear() {
		return defenceYear;
	}

	/**
	 * @param defenceYear the defenceYear to set
	 */
	public void setDefenceYear(String defenceYear) {
		this.defenceYear = defenceYear;
	}

	/**
	 * @return the option
	 */
	public String getOption() {
		return option;
	}

	/**
	 * @param option the option to set
	 */
	public void setOption(String option) {
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
