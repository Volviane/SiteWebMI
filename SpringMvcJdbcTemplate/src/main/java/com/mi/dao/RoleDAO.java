package com.mi.dao;

import java.util.List;

import com.mi.model.Role;



public interface RoleDAO {
	
	public void save(Role role);
	public void delete(int roleId);
	public Role findByRoleName(String RoleName);
	public Role findOne(int roleId);
	public List<Role> findAll();

}
