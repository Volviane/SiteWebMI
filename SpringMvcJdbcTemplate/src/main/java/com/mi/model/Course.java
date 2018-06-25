package com.mi.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="UVs")
public class Course implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_UV")
	private int idUV;
	
	@Column(name="CODE_UV")
	private String courseCode;
	
	@Column(name="INTITULE_UV", length=30)
	private String courseTitle;
	
	@Column(name="NOMBRE_CREDITS")
	private int creditNumber;
	
	@Column(name="DESCRIPTION_UV")
	private String courseDescription;
	
	@Column(name="SEMESTRE_UV")
	private String semester;
	
	@ManyToOne
	private Level level;
	
	
	public Course() {
		// TODO Auto-generated constructor stub
	}


	

	/**
	 * @param courseCode
	 * @param courseTitle
	 * @param semester
	 * @param level
	 */
	public Course(String courseCode, String courseTitle, String semester, Level level) {
		super();
		this.courseCode = courseCode;
		this.courseTitle = courseTitle;
		this.semester = semester;
		this.level = level;
	}




	/**
	 * @return the idUV
	 */
	public int getIdUV() {
		return idUV;
	}




	/**
	 * @param idUV the idUV to set
	 */
	public void setIdUV(int idUV) {
		this.idUV = idUV;
	}




	/**
	 * @return the courseTitle
	 */
	public String getCourseTitle() {
		return courseTitle;
	}




	/**
	 * @param courseTitle the courseTitle to set
	 */
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}




	/**
	 * @return the courseCode
	 */
	public String getCourseCode() {
		return courseCode;
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
	public Level getLevel() {
		return level;
	}


	/**
	 * @param level the level to set
	 */
	public void setLevel(Level level) {
		this.level = level;
	}




	/**
	 * @return the creditNumber
	 */
	public int getCreditNumber() {
		return creditNumber;
	}




	/**
	 * @param creditNumber the creditNumber to set
	 */
	public void setCreditNumber(int creditNumber) {
		this.creditNumber = creditNumber;
	}




	/**
	 * @return the courseDescription
	 */
	public String getCourseDescription() {
		return courseDescription;
	}




	/**
	 * @param courseDescription the courseDescription to set
	 */
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	
}
