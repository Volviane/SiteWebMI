package com.mi.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="CYCLES")
public class Cycle implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CYCLE")
	private Integer idLevel;
	
	@Column(name="NOM_CYCLE")
	private String cycleName;
	
	//@OneToMany(mappedBy="cycle")
	//private Set<Option> options;
	
	
	/**
	 * @return the options
	 */
	/*public Set<Option> getOptions() {
		return options;
	}

	*//**
	 * @param options the options to set
	 *//*
	public void setOptions(Set<Option> options) {
		this.options = options;
	}
*/
	public Cycle() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cycleName
	 */
	public Cycle(String cycleName) {
		super();
		this.cycleName = cycleName;
	}

	/**
	 * @return the idLevel
	 */
	public Integer getIdLevel() {
		return idLevel;
	}

	/**
	 * @param idLevel the idLevel to set
	 */
	public void setIdLevel(Integer idLevel) {
		this.idLevel = idLevel;
	}

	/**
	 * @return the cycleName
	 */
	public String getCycleName() {
		return cycleName;
	}

	/**
	 * @param cycleName the cycleName to set
	 */
	public void setCycleName(String cycleName) {
		this.cycleName = cycleName;
	}
	
}
