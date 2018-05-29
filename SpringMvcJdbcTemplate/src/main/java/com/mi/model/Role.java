package com.mi.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
	//@ManyToMany(cascade=CascadeType.ALL, mappedBy="role")
	//@JoinTable(name="ROLE_ADMIN")
	//private Set<Administrator> admins;
	public Role() {
		// TODO Auto-generated constructor stub
	}
	public Long getIdRole() {
		return idRole;
	}
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/*public Set<Administrator> getAdmins() {
		return admins;
	}
	public void setAdmins(Set<Administrator> admins) {
		this.admins = admins;
	}*/
	

}
