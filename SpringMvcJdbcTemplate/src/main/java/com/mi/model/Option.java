package com.mi.model;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "OPTIONS")
public class Option implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_OPTION")
	private Integer idOption;

	@Column(name = "NOM_OPTION")
	private String optionName;
	
	//@ManyToOne
	//@JoinColumn(name="CYCLE_ID")
	private Cycle cycle;

	@OneToMany(mappedBy="option")
	//@JoinTable( name = "OPTION_NIVEAU", joinColumns = @JoinColumn(name = "ID_OPTION", referencedColumnName = "ID_OPTION"), inverseJoinColumns = @JoinColumn(name = "ID_LEVEL", referencedColumnName = "ID_NIVEAU"))
	private Set<Level> levels;
	

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
		// TODO Auto-generated constructor stub
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
	public Integer getIdOption() {
		return idOption;
	}

	/**
	 * @param idOption
	 *            the idOption to set
	 */
	public void setIdOption(Integer idOption) {
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

	public Cycle getCycle() {
		return cycle;
	}

	public void setCycle(Cycle cycle) {
		this.cycle = cycle;
	}
	

}
