package com.mi.model;

import java.io.Serializable;
import java.util.HashSet;
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
	
	@ManyToOne //Plusieurs niveaux appartiennent à une option
	@JoinColumn(name="ID_OPTION")
	private Option option;
	
	@OneToMany(mappedBy="level")
	//@JoinColumn(name="ID_NIVEAU")
	private Set<Course> courses= new HashSet<Course>();
	
	@OneToMany(mappedBy="juryLevel")
	private Set<Jury> juries = new HashSet<Jury>();
	
	
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
	public Option getOption() {
		return option;
	}


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

	/**
	 * @return the courses
	 */
	public Set<Course> getCourses() {
		return courses;
	}

	/**
	 * @param courses the courses to set
	 */
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	/**
	 * @param option the option to set
	 */
	public void setOption(Option option) {
		this.option = option;
	}
	
}
