package com.mi.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "ADMIN")
public class Administrator implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ADMIN")
	private Integer idAdmin;

	@Column(name = "LOGIN", length = 30, unique = true)
	private String login;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "PASSWORDSEC")
	private String passwordSec;

	@OneToMany(mappedBy="admin",fetch = FetchType.LAZY)
	private Set<Communique> communiques = new HashSet<Communique>();

	@ManyToMany(mappedBy = "admins")
	private Set<Role> roles;
	
	/**
	 * @return the passwordSec
	 */
	public String getPasswordSec() {
		return passwordSec;
	}

	/**
	 * @param passwordSec
	 *            the passwordSec to set
	 */
	public void setPasswordSec(String passwordSec) {
		this.passwordSec = passwordSec;
	}

	/**
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles
	 *            the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	public Administrator() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the idAdmin
	 */
	public int getIdAdmin() {
		return idAdmin;
	}

	/**
	 * @param idAdmin
	 *            the idAdmin to set
	 */
	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
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
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param login
	 * @param password
	 * @param passwordSec
	 * @param roles
	 */
	public Administrator(String login, String password, String passwordSec, Set<Role> roles) {
		super();
		this.login = login;
		this.password = password;
		this.passwordSec = passwordSec;
		this.roles = roles;
	}

	/**
	 * @param idAdmin
	 *            the idAdmin to set
	 */
	public void setIdAdmin(Integer idAdmin) {
		this.idAdmin = idAdmin;
	}

	/**
	 * @return the communiques
	 */
	public Set<Communique> getCommuniques() {
		return communiques;
	}

	/**
	 * @param communiques
	 *            the communiques to set
	 */
	public void setCommuniques(Set<Communique> communiques) {
		this.communiques = communiques;
	}

}
