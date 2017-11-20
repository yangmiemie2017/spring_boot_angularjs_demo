package com.mydemo.dao;

//import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.mydemo.entity.Role;

@Repository
public interface RoleDao extends JpaRepository<Role, Long> {
    
	Role findByNameLike(String name);

	Role readByName(String name);
	
	List<Role> findAll();
}