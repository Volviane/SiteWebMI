package com.mi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="DOCUMENT")
public class Document {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDocument;
	
	private String documentTitle;
	private String documentAbstract;
	@Transient
	private List<String> keywords = new ArrayList<String>();
	private String documentType;
	private String locationFile;

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
		this.documentType = documentType;
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
	 * @return the documentType
	 */
	public String getDocumentType() {
		return documentType;
	}

	/**
	 * @param documentType the documentType to set
	 */
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
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
