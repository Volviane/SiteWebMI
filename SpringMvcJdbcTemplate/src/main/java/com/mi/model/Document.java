package com.mi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name="DOCUMENT")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)//choix de la stratégie d'héritage une table pour la hierarchie
@DiscriminatorColumn(name="TYPE_DOCUMENT",discriminatorType=DiscriminatorType.STRING)//Définit une colone discriminatoire dans la table pour différence les types des entités
@DiscriminatorValue("DOCUMENT")
public class Document implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DOCUMENT_ID")
	private Long idDocument;
	
	@Column(name="TITRE_DOCUMENT")
	private String documentTitle;
	
	@Column(name="RESUME_DOCUMENT")
	private String documentAbstract;
	
	@Transient
	private List<String> keywords = new ArrayList<String>();
	
	@Column(name="EMPLACEMENT_DOCUMENT")
	private String locationFile;

	//@CreatedBy
	//private User author;
	
	//@CreatedDate
	@Temporal(TemporalType.DATE)
	private Date createDate;
	
	
	public Document() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param documentTitle
	 * @param documentAbstract
	 * @param keywords
	 * @param documentType
	 * @param locationFile
	 */
	public Document(String documentTitle, String documentAbstract, List<String> keywords, String documentType,
			String locationFile) {
		super();
		this.documentTitle = documentTitle;
		this.documentAbstract = documentAbstract;
		this.keywords = keywords;
		this.locationFile = locationFile;
	}

	/**
	 * @return the idDocument
	 */
	public Long getIdDocument() {
		return idDocument;
	}

	/**
	 * @param idDocument the idDocument to set
	 */
	public void setIdDocument(Long idDocument) {
		this.idDocument = idDocument;
	}

	/**
	 * @return the documentTitle
	 */
	public String getDocumentTitle() {
		return documentTitle;
	}

	/**
	 * @param documentTitle the documentTitle to set
	 */
	public void setDocumentTitle(String documentTitle) {
		this.documentTitle = documentTitle;
	}

	/**
	 * @return the documentAbstract
	 */
	public String getDocumentAbstract() {
		return documentAbstract;
	}

	/**
	 * @param documentAbstract the documentAbstract to set
	 */
	public void setDocumentAbstract(String documentAbstract) {
		this.documentAbstract = documentAbstract;
	}

	/**
	 * @return the keywords
	 */
	public List<String> getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}


	/**
	 * @return the locationFile
	 */
	public String getLocationFile() {
		return locationFile;
	}

	/**
	 * @param locationFile the locationFile to set
	 */
	public void setLocationFile(String locationFile) {
		this.locationFile = locationFile;
	}

	
}
