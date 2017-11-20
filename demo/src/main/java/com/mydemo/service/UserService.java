package com.mydemo.service;

import java.util.List;
import java.util.Optional;

import com.mydemo.entity.User;


public interface UserService {
	public User readByLoginName(String name);
	public User findById(Long id);
	public User save(User user);
	public User update(User user);
	public List<User> findAll();
}
