package com.mi.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="CYCLES")
public class Cycle implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CYCLE")
	private Integer idCycle;
	
	@Column(name="NOM_CYCLE")
	private String cycleName;
	
	@Column(name="DESCRIPTION_CYCLE")
	private String cycleDescription;
	
	@OneToMany(mappedBy="cycle",fetch=FetchType.EAGER)
	private Set<Option> options = new HashSet<Option>();
	
	
	/**
	 * @return the options
	 */
	public Set<Option> getOptions() {
		return options;
	}

	/**
	 * @param options the options to set
	 */
	public void setOptions(Set<Option> options) {
		this.options = options;
	}

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
	 * @return the idCycle
	 */
	public Integer getIdCycle() {
		return idCycle;
	}

	/**
	 * @param idCycle the idCycle to set
	 */
	public void setIdCycle(Integer idLevel) {
		this.idCycle = idLevel;
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

	/**
	 * @return the cycleDescription
	 */
	public String getCycleDescription() {
		return cycleDescription;
	}

	/**
	 * @param cycleDescription the cycleDescription to set
	 */
	public void setCycleDescription(String cycleDescription) {
		this.cycleDescription = cycleDescription;
	}
	
}
