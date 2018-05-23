package com.mi.model;

public class User {
	protected int inscriptionCode;
	protected String userLastName;
	protected String userFirstName;
	protected String universityName;
	protected String userEmail;
	protected  String option;
	protected String userFunction;
	protected String userPassword;
	protected String laboratoire;
	protected String sexe;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int inscriptionCode, String userLastName, String userFirstName, String universityName, String userEmail,
			String option, String userFunction, String userPassword, String laboratoire, String sexe) {
		super();
		this.inscriptionCode = inscriptionCode;
		this.userLastName = userLastName;
		this.userFirstName = userFirstName;
		this.universityName = universityName;
		this.userEmail = userEmail;
		this.option = option;
		this.userFunction = userFunction;
		this.userPassword = userPassword;
		this.laboratoire = laboratoire;
		this.sexe = sexe;
	}

	public int getInscriptionCode() {
		return inscriptionCode;
	}
	public void setInscriptionCode(int inscriptionCode) {
		this.inscriptionCode = inscriptionCode;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public String getUserFunction() {
		return userFunction;
	}
	public void setUserFunction(String userFunction) {
		this.userFunction = userFunction;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public String getLaboratoire() {
		return laboratoire;
	}

	public void setLaboratoire(String laboratoire) {
		this.laboratoire = laboratoire;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	@Override
	public String toString() {
		return "User [inscriptionCode=" + inscriptionCode + ", userLastName=" + userLastName + ", userFirstName="
				+ userFirstName + ", universityName=" + universityName + ", userEmail=" + userEmail + ", option="
				+ option + ", userFunction=" + userFunction + ", userPassword=" + userPassword + ", laboratoire="
				+ laboratoire + ", sexe=" + sexe + "]";
	}

	
	
	
	
	
}
