package com.mi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="COMMUNIQUES")
public class Communique implements Serializable{
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="ID_COMMUNIQUE")
	private Long idCommunique;
	
/*	@Column(name="ROLE_NAME")
	private String communiqueName;*/
	
	@Column(name="TITRE_COMMUNIQUE")
	private String communiqueTitle;
	
	@Column(name="CONTENU_COMMUNIQUE")
	private String communiqueContent;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATE_PUBLICATION")
	private Date publicationDate;
	
	@Column(name="STATUT_PUBLICATION")
	private boolean isPublish = false;
	
	@ManyToOne
	private Administrator admin;

	public Communique() {
		
	}
	
	public void publish(){
		isPublish = true;
		publicationDate = new Date();
	}

	/**
	 * @param communiqueName
	 * @param communiqueTitle
	 * @param communiqueContent
	 * @param publicationDate
	 */
	public Communique(String communiqueName, String communiqueTitle, String communiqueContent, Date publicationDate) {
		super();
		//this.communiqueName = communiqueName;
		this.communiqueTitle = communiqueTitle;
		this.communiqueContent = communiqueContent;
		this.publicationDate = publicationDate;
	}

	/**
	 * @return the idCommunique
	 */
	public Long getIdCommunique() {
		return idCommunique;
	}

	/**
	 * @param idCommunique the idCommunique to set
	 */
	public void setIdCommunique(Long idCommunique) {
		this.idCommunique = idCommunique;
	}

	/**
	 * @return the communiqueName
	 *//*
	public String getCommuniqueName() {
		return communiqueName;
	}

	*//**
	 * @param communiqueName the communiqueName to set
	 *//*
	public void setCommuniqueName(String communiqueName) {
		this.communiqueName = communiqueName;
	}
*/
	/**
	 * @return the communiqueTitle
	 */
	public String getCommuniqueTitle() {
		return communiqueTitle;
	}

	/**
	 * @param communiqueTitle the communiqueTitle to set
	 */
	public void setCommuniqueTitle(String communiqueTitle) {
		this.communiqueTitle = communiqueTitle;
	}

	/**
	 * @return the communiqueContent
	 */
	public String getCommuniqueContent() {
		return communiqueContent;
	}

	/**
	 * @param communiqueContent the communiqueContent to set
	 */
	public void setCommuniqueContent(String communiqueContent) {
		this.communiqueContent = communiqueContent;
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

	/**
	 * @return the admin
	 */
	public Administrator getAdmin() {
		return admin;
	}

	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}

	/**
	 * @return the isPublish
	 */
	public boolean isPublish() {
		return isPublish;
	}

	/**
	 * @param isPublish the isPublish to set
	 */
	public void setPublish(boolean isPublish) {
		this.isPublish = isPublish;
	}
	
}
