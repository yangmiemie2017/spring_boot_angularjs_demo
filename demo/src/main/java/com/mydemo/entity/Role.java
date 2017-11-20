package com.mydemo.entity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;




@Entity
@Table(name="role")
public class Role implements Serializable {
    
    /** 
    * @Fields serialVersionUID : TODO
    */ 
    private static final long serialVersionUID = -6550777752269466791L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length=50,nullable=false)
    private String name;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Role() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Role(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    
}