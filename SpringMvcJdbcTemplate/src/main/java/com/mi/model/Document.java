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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name="DOCUMENTS")
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)//choix de la strat�gie d'h�ritage une table pour la hierarchie
//@DiscriminatorColumn(name="TYPE_DOCUMENT",discriminatorType=DiscriminatorType.STRING)//D�finit une colone discriminatoire dans la table pour diff�rence les types des entit�s
//@DiscriminatorValue("DOCUMENT")
public class Document implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DOCUMENT_ID")
	private Long idDocument;
	
	@Column(name="TITRE_DOCUMENT")
	private String documentTitle;
	
	@Column(name="RESUME_DOCUMENT")
	private String documentAbstract;
	
	@Column(name="DESCRIPTION_DOCUMENT")
	private String documentDescription;
	
	@Column(name="TYPE_DOCUMENT")
	private String documentType;
	
	@Column(name="NOM_DOCUMENT")
	private String documentName;

	@OneToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="TEACHER_ID", unique=true)
	private Teacher author;
	
	@Temporal(TemporalType.DATE)
	private Date createDate;
	
	
	public Document() {
		
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



	public String getDocumentDescription() {
		return documentDescription;
	}



	public void setDocumentDescription(String documentDescription) {
		this.documentDescription = documentDescription;
	}



	public String getDocumentType() {
		return documentType;
	}



	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}



	public String getDocumentName() {
		return documentName;
	}



	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}



	public Teacher getAuthor() {
		return author;
	}



	public void setAuthor(Teacher author) {
		this.author = author;
	}



	public Date getCreateDate() {
		return createDate;
	}



	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	

	}
