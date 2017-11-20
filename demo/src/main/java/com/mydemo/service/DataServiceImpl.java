package com.mydemo.service;

//import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.mydemo.dao.DepartmentDao;
import com.mydemo.dao.RoleDao;
import com.mydemo.dao.UserDao;
import com.mydemo.entity.Department;
import com.mydemo.entity.Role;
import com.mydemo.entity.User;

@Service
public class DataServiceImpl implements DataService{
    
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private DepartmentDao departmentDao;
    
    public void initData(){
//        userDao.deleteAll();
//        departmentDao.deleteAll();
//        roleDao.deleteAll();
        
        Department department = new Department();
        department.setName("财务部");
        //department.setCreatedate(new Date());
        
        departmentDao.save(department);
        Assert.notNull(department.getId(),"部门ID不能为空！");
        
        Role role = new Role();
        role.setName("管理员");
        //role.setCreatedate(new Date());
        
        roleDao.save(role);
        Assert.notNull(role.getId(),"角色ID不能为空");
        
        User user = new User();
        user.setName("管理员");
        user.setLoginName("admin");
        user.setDepartment(department);
        List<Role> roleList = roleDao.findAll();
        Assert.notNull(roleList,"角色列表不能为空！");
        user.setRoleList(roleList);
        user.setPassword("admin");
        
        userDao.save(user);
        Assert.notNull(user.getId(),"用户ID不能为空！");
    }
    

    public void initData1(){
     
      Department department = new Department();
      department.setName("department1");
      //department.setCreatedate(new Date());
      
      departmentDao.save(department);
      Assert.notNull(department.getId(),"部门ID不能为空！");
      
      Role role = new Role();
      role.setName("role1");
      //role.setCreatedate(new Date());
      
      roleDao.save(role);
      Assert.notNull(role.getId(),"角色ID不能为空");
      
      User user = new User();
      user.setName("test1");
      user.setLoginName("test1");
      user.setDepartment(department);
      List<Role> roleList = roleDao.findAll();
      Assert.notNull(roleList,"角色列表不能为空！");
      user.setRoleList(roleList);
      user.setPassword("test1");
      
      userDao.save(user);
      Assert.notNull(user.getId(),"用户ID不能为空！");
  }
    
    public Department getDepartmentById(long Id){
    	return departmentDao.getOne(Id);
    }
    
    public List<Role> getAllRoles(){
    	return roleDao.findAll();
    }
    
}