package com.mi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mi.dao.RoleDAO;
import com.mi.model.Role;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService{

@Autowired
RoleDAO roleDao;

	public Role findById(int id) {
		// TODO Auto-generated method stub
		return roleDao.findOne(id);
	}

	
	public Role findByRoleName(String roleName) {
		// TODO Auto-generated method stub
		return roleDao.findByRoleName(roleName);
	}

	
	public void saveRole(Role role) {
		// TODO Auto-generated method stub
		roleDao.save(role);
		
	}

	
	public void updateRole(Role role) {
		// TODO Auto-generated method stub
	
		
	}

	
	public void deleteUserBySSO(String sso) {
		// TODO Auto-generated method stub
		
	}


	public List<Role> findAllRoles() {
		// TODO Auto-generated method stub
		return roleDao.findAll();
	}

}
