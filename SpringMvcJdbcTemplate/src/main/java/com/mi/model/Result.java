package com.mi.model;

import java.io.Serializable;
import java.util.Date;

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
	
	/*@Column(name="ANNEES")
	private AcademicYear academicYear;*/
	
	@Column(name="TITRE")
	private String resultTitle;
	
	@Column(name="NOM_FICHIER")
	private String resultFileName;
	
	@Column(name="STATUT_PUBLICATION")
	private boolean isPublish = false;
	
	@Column(name="DATE_PUBLICATION")
	private Date publicationDate;



	public boolean isPublish() {
		return isPublish;
	}

	public void setPublish(boolean isPublish) {
		this.isPublish = isPublish;
	}


	@ManyToOne
	@JoinColumn(name="JURY_ID")
	private Jury jury;
	
	
	public Result() {
		
	}
	
	public void publish(){
		isPublish = true;
	}

	/**
	 * @param session
	 * @param academicYear
	 * @param resultTitle
	 * @param resultFileName
	 */
	public Result(String session,  String resultTitle, String resultFileName) {
		super();
		this.session = session;
	
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
	public Result(String session, String resultTitle, String resultFileName, Jury jury) {
		super();
		this.session = session;
		
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

	/**
	 * @return the publicationDate
	 */
	public Date getPublicationDate() {
		return publicationDate;
	}

	/**
	 * @param publicationDate the publicationDate to set
	 */
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	
}
