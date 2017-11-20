package com.mydemo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mydemo.dao.UserDao;
import com.mydemo.entity.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public User readByLoginName(String name) {
        return userDao.readByLoginName(name);
    }
    public User findById(Long id) {
        return userDao.findById(id);
    }    
	public User save(User user) {
		return userDao.save(user);
	}

	public User update(User user) {
		return userDao.saveAndFlush(user);
	}
	
	public List<User> findAll(){
		return userDao.findAll();
	}
}