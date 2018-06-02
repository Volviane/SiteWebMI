package com.mi.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="NIVEAUX")
public class Level implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_NIVEAU")
	private Integer idLevel;
	
	@Column(name="NOM_NIVEAU")
	private String levelName;
	
	//@ManyToOne(cascade=CascadeType.ALL)
	//@JoinColumn(name="ID_OPTION")
	private Integer option;
	


	
	//@ManyToMany(mappedBy="levels")
	//private Set<Option> options;
	
	//@OneToMany(mappedBy="level")
	//private Set<Course> courses;
	
	
	
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
	 * @return the levelName
	 */
	public String getLevelName() {
		return levelName;
	}

	/**
	 * @param levelName the levelName to set
	 */
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

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
	}*/

	public Level() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param levelName
	 */
	public Level(String levelName) {
		super();
		this.levelName = levelName;
	}

	public Integer getOption() {
		return option;
	}

	public void setOption(Integer option) {
		this.option = option;
	}

	/*public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}*/
	
	
	
}
