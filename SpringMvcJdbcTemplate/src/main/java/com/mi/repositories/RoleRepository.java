package com.mi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.mi.model.Role;

public interface RoleRepository extends JpaRepository<Role, String> {
	
	public Role findByRoleName(String nameRole);

}
