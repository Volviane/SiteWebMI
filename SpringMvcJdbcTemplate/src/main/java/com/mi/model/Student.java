package com.mi.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="STUDENTS")
public class Student extends InternetSufer implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_STUDENT")
	private Long idStudent;
	
	private Option studentOption;
	private Level studentLevel;
	private Cycle studentCycle;
	
//	@OneToMany(mappedBy="author")
//	private List<Article> documents;
	

	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	


	public Student(Level studentLevel) {
		this.studentLevel = studentLevel;
	}


	public Level getStudentLevel() {
		return studentLevel;
	}


	public void setStudentLevel(Level studentLevel) {
		this.studentLevel = studentLevel;
	}


	
	
	
	

}
