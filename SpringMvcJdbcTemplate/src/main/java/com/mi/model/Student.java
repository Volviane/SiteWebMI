package com.mi.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="STUDENTS")
@AttributeOverride(name="ID",column=@Column(name="ID_STUDENT"))
public class Student extends InternetSufer implements Serializable{
		
	@ManyToOne
	private Level studentLevel;
		
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
