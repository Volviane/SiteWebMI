package com.mi.model;

public class Student extends User{
	private String studentLevel;

	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	public Student(int inscriptionCode, String userLastName, String userFirstName, String universityName,
			String userEmail, String option, String userFunction, String userPassword, String laboratoire,
			String sexe) {
		super(inscriptionCode, userLastName, userFirstName, universityName, userEmail, option, userFunction, userPassword,
				laboratoire, sexe);
		// TODO Auto-generated constructor stub
	}



	public Student(String studentLevel) {
		this.studentLevel = studentLevel;
	}


	public String getStudentLevel() {
		return studentLevel;
	}


	public void setStudentLevel(String studentLevel) {
		this.studentLevel = studentLevel;
	}


	@Override
	public String toString() {
		return "Niveau d'�tude:=" + studentLevel + "\n Nom:"
				+ userLastName + "\n Pr�nom:" + userFirstName + "\n Universit�:" + universityName
				+ "\n Sp�cialit�=" + option + "\n Qualit�:" + userFunction
				+ "\n userPassword=" + userPassword + "\n Laboratoire: "+laboratoire+"\n Sexe: "+sexe;
	}
	
	
	

}
