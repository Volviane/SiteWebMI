package com.mi.services;

import java.util.List;

import com.mi.model.Role;


public interface RoleService {
	
	Role findById(int id);
	
	Role findByRoleName(String roleName);
	
	void saveRole(Role user);
	
	void updateRole(Role role);
	
	void deleteUserBySSO(String sso);

	List<Role> findAllRoles(); 

}
