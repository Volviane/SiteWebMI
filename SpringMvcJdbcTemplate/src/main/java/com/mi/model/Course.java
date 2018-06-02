package com.mi.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="UVs")
public class Course implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_UV")
	private Integer idUV;
	
	@Column(name="INTITULE_UV")
	private String courseName;
	
	@Column(name="CODE_UV")
	private String courseCode;
	
	@Column(name="SEMESTRE_UV")
	private String semester;
	
	//@ManyToOne(optional=false)
	//@JoinColumn(name="LEVEL_ID")
	private Integer level;
	
	
	public Course() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param gradeName
	 * @param courseCode
	 * @param semester
	 */
	public Course(String courseName, String courseCode, String semester) {
		super();
		this.courseName = courseName;
		this.courseCode = courseCode;
		this.semester = semester;
	}


	/**
	 * @return the idUV
	 */
	public Integer getIdUV() {
		return idUV;
	}


	/**
	 * @param idUV the idUV to set
	 */
	public void setIdUV(Integer idUV) {
		this.idUV = idUV;
	}


	/**
	 * @return the gradeName
	 */
	


	/**
	 * @return the courseCode
	 */
	public String getCourseCode() {
		return courseCode;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	/**
	 * @param courseCode the courseCode to set
	 */
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}


	/**
	 * @return the semester
	 */
	public String getSemester() {
		return semester;
	}


	/**
	 * @param semester the semester to set
	 */
	public void setSemester(String semester) {
		this.semester = semester;
	}


	/**
	 * @return the level
	 */
	public Integer getLevel() {
		return level;
	}


	/**
	 * @param level the level to set
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
	
}
