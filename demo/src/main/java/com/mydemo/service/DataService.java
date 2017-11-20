package com.mydemo.service;

import java.util.List;

import com.mydemo.entity.Department;
import com.mydemo.entity.Role;

public interface DataService {
	public void initData();
	public void initData1();
	public Department getDepartmentById(long Id);
	public List<Role> getAllRoles();
}
