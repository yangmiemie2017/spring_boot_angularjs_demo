package com.mydemo.dao;

//import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mydemo.entity.Department;

@Repository
public interface DepartmentDao extends JpaRepository<Department, Long> {
    
	Department findByNameLike(String name);

	Department readByName(String name);

    List<Department> findAll();
}