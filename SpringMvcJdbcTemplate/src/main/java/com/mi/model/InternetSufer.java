package com.mi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@MappedSuperclass
public abstract class InternetSufer implements Serializable{
	
	/*@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;*/
	
	@Column(name="NOM")
	protected String lastName;
	
	@Column(name="PRENOM")
	protected String firstName;
	
	@Column(name="EMAIL")
	protected String emailAdress;
	
	@Column(name="LOGIN", unique=true, length=50)
	protected String login;
	
	@Column(name="PASSWORD")
	protected String password;
	
	@Column(name="TELEPHONE")
	protected String phoneNumber;
	
	@Column(name="SEXE")
	protected String sexe;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATE_NAISSANCE")
	protected Date birthDate;
	
	@Column(name="LIEU_NAISSANCE")
	protected String birthPlace;

//	@ManyToMany(mappedBy="subscribers")
	//protected Set<Event> events = new HashSet<Event>();

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the emailAdress
	 */
	public String getEmailAdress() {
		return emailAdress;
	}

	/**
	 * @param emailAdress the emailAdress to set
	 */
	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the sexe
	 */
	public String getSexe() {
		return sexe;
	}

	/**
	 * @param sexe the sexe to set
	 */
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the birthPlace
	 */
	public String getBirthPlace() {
		return birthPlace;
	}

	/**
	 * @param birthPlace the birthPlace to set
	 */
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	/**
	 * @param lastName
	 * @param firstName
	 * @param emailAdress
	 * @param login
	 * @param password
	 * @param phoneNumber
	 * @param sexe
	 * @param birthDate
	 * @param birthPlace
	 */
	public InternetSufer(String lastName, String firstName,String emailAdress, String login, String password,
			String phoneNumber, String sexe, Date birthDate, String birthPlace) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.emailAdress = emailAdress;
		this.login = login;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.sexe = sexe;
		this.birthDate = birthDate;
		this.birthPlace = birthPlace;
	}

	/**
	 * 
	 */
	public InternetSufer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
