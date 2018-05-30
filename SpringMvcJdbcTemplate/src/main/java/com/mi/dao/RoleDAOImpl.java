package com.mi.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mi.model.Role;

@Repository("roleDao")
public class RoleDAOImpl  extends AbstractDao<Integer, Role> implements RoleDAO{

	@Override
	public void save(Role role) {
		persist(role);
		
	}

	@Override
	public void delete(int roleId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Role findByRoleName(String RoleName) {
		// TODO Auto-generated method stub
		return findByName(RoleName);
	}

	@Override
	public Role findOne(int roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Role> findAll() {
		List<Role> role = getEntityManager()
				.createQuery("SELECT u FROM ROLES u ORDER BY u.roleName ASC")
				.getResultList();
		return role;
	}

}
