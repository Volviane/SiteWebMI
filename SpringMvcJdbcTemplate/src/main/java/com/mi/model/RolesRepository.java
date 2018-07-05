package com.mi.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface RolesRepository extends JpaRepository<Role, Integer> {

}
