package com.mi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="DOMAINES_RECHERCHE")
public class ResearchDomain implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_DOMAINE")
	private Long idResearchDomain;
	
	@Column(name="INTITULE_DOMAINE")
	private String domainLabel;
	
	@Column(name="DESCRIPTION_DOMAINE")
	private String domainDescription;
	
	public ResearchDomain() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the idResearchDomain
	 */
	public Long getIdResearchDomain() {
		return idResearchDomain;
	}

	/**
	 * @param idResearchDomain the idResearchDomain to set
	 */
	public void setIdResearchDomain(Long idResearchDomain) {
		this.idResearchDomain = idResearchDomain;
	}

	/**
	 * @return the domainLabel
	 */
	public String getDomainLabel() {
		return domainLabel;
	}

	/**
	 * @param domainLabel the domainLabel to set
	 */
	public void setDomainLabel(String domainLabel) {
		this.domainLabel = domainLabel;
	}

	/**
	 * @return the domainDescription
	 */
	public String getDomainDescription() {
		return domainDescription;
	}

	/**
	 * @param domainDescription the domainDescription to set
	 */
	public void setDomainDescription(String domainDescription) {
		this.domainDescription = domainDescription;
	}

}
