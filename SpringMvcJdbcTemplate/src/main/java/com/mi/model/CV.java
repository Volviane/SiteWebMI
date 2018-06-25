package com.mi.model;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class CV implements Serializable {

	@Column(name="DOMAINE_COMPETENCE")
	private String competenceDomain;
	
	public CV() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the competenceDomain
	 */
	public String getCompetenceDomain() {
		return competenceDomain;
	}

	/**
	 * @param competenceDomain the competenceDomain to set
	 */
	public void setCompetenceDomain(String competenceDomain) {
		this.competenceDomain = competenceDomain;
	}
	
}
