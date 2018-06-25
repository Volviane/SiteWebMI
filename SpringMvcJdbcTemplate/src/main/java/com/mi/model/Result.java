package com.mi.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="RESULTATS")
public class Result implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="RESULTAT_ID")
	private Long idResult;
	@Column(name="SESSION")
	private String session;
	@Column(name="ANNEE")
	private String academicYear;
	@Column(name="TITRE")
	private String resultTitle;
	@Column(name="NOM_FICHIER")
	private String resultFileName;
	
	@ManyToOne
	@JoinColumn(name="JURY_ID")
	private Jury jury;
	
	
	public Result() {
		
	}


	/**
	 * @param session
	 * @param academicYear
	 * @param resultTitle
	 * @param resultFileName
	 */
	public Result(String session, String annee, String resultTitle, String resultFileName) {
		super();
		this.session = session;
		this.academicYear = annee;
		this.resultTitle = resultTitle;
		this.resultFileName = resultFileName;
	}


	/**
	 * @param session
	 * @param academicYear
	 * @param resultTitle
	 * @param resultFileName
	 * @param jury
	 */
	public Result(String session, String annee, String resultTitle, String resultFileName, Jury jury) {
		super();
		this.session = session;
		this.academicYear = annee;
		this.resultTitle = resultTitle;
		this.resultFileName = resultFileName;
		this.jury = jury;
	}


	/**
	 * @return the idResult
	 */
	public Long getIdResult() {
		return idResult;
	}


	/**
	 * @param idResult the idResult to set
	 */
	public void setIdResult(Long idResult) {
		this.idResult = idResult;
	}


	/**
	 * @return the session
	 */
	public String getSession() {
		return session;
	}


	/**
	 * @param session the session to set
	 */
	public void setSession(String session) {
		this.session = session;
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
	public void setAcademicYear(String annee) {
		this.academicYear = annee;
	}


	/**
	 * @return the resultTitle
	 */
	public String getResultTitle() {
		return resultTitle;
	}


	/**
	 * @param resultTitle the resultTitle to set
	 */
	public void setResultTitle(String resultTitle) {
		this.resultTitle = resultTitle;
	}


	/**
	 * @return the resultFileName
	 */
	public String getResultFileName() {
		return resultFileName;
	}


	/**
	 * @param resultFileName the resultFileName to set
	 */
	public void setResultFileName(String resultFileName) {
		this.resultFileName = resultFileName;
	}


	/**
	 * @return the jury
	 */
	public Jury getJury() {
		return jury;
	}


	/**
	 * @param jury the jury to set
	 */
	public void setJury(Jury jury) {
		this.jury = jury;
	}
	
}
