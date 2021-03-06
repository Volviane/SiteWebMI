package com.mi.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "OPTIONS")
public class Option implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_OPTION")
	private Long idOption;

	@Column(name = "NOM_OPTION")
	private String optionName;
	

	@Column(name="DESCRIPTION_OPTION")
	private String optionDescription;
	
	@ManyToOne
	private Cycle cycle;

	@OneToMany(mappedBy="option")
	private Set<Level> levels = new HashSet<Level>();
	

	@OneToMany(mappedBy="option")
	private Set<ResearchDomain> researchDomain = new HashSet<ResearchDomain>();
	

	/**
	 * @return the levels
	 */
	public Set<Level> getLevels() {
		return levels;
	}

	/**
	 * @param levels the levels to set
	 */
	public void setLevels(Set<Level> levels) {
		this.levels = levels;
	}

	
	public Option() {
		
	}

	/**
	 * @param optionName
	 */
	public Option(String optionName) {
		super();
		this.optionName = optionName;
	}

	/**
	 * @return the idOption
	 */
	public Long getIdOption() {
		return idOption;
	}

	/**
	 * @param idOption
	 *            the idOption to set
	 */
	public void setIdOption(Long idOption) {
		this.idOption = idOption;
	}

	/**
	 * @return the optionName
	 */
	public String getOptionName() {
		return optionName;
	}

	/**
	 * @param optionName
	 *            the optionName to set
	 */
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	/**
	 * @return the cycle
	 */
	public Cycle getCycle() {
		return cycle;
	}

	/**
	 * @param cycle the cycle to set
	 */
	public void setCycle(Cycle cycle) {
		this.cycle = cycle;
	}

	/**
	 * @return the optionDescription
	 */
	public String getOptionDescription() {
		return optionDescription;
	}

	/**
	 * @param optionDescription the optionDescription to set
	 */
	public void setOptionDescription(String optionDescription) {
		this.optionDescription = optionDescription;
	}

	/**
	 * @return the researchDomain
	 */
	public Set<ResearchDomain> getResearchDomain() {
		return researchDomain;
	}

	/**
	 * @param researchDomain the researchDomain to set
	 */
	public void setResearchDomain(Set<ResearchDomain> researchDomain) {
		this.researchDomain = researchDomain;
	}

}
