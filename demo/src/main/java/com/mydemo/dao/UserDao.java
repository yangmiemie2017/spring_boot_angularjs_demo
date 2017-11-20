package com.mydemo.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mydemo.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    
    User findByLoginNameLike(String name);

    User readByLoginName(String name);

    List<User> getByCreatedateLessThan(Date start);
    
    User findById(Long id) ;
}