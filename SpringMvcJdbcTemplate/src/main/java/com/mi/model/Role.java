package com.mi.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="ROLES")
public class Role implements Serializable{
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="ID_ROLE")
	private Long idRole;
	
	@Column(name="ROLE_NAME")
	private String roleName;
	
	@ManyToMany(mappedBy = "roles")
	private Set<Administrator> admins = new HashSet<Administrator>();
	
	@ManyToMany(mappedBy = "roles")
	private Set<Teacher> teacher = new HashSet<Teacher>();
	
	public Role() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the idRole
	 */
	public Long getIdRole() {
		return idRole;
	}

	/**
	 * @param idRole the idRole to set
	 */
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the admins
	 */
	public Set<Administrator> getAdmins() {
		return admins;
	}

	/**
	 * @param admins the admins to set
	 */
	public void setAdmins(Set<Administrator> admins) {
		this.admins = admins;
	}

	public Set<Teacher> getTeacher() {
		return teacher;
	}

	public void setTeacher(Set<Teacher> teacher) {
		this.teacher = teacher;
	}
	
}
