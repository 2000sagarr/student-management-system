package com.sagar.studentmanagementsystem.dao;

import java.util.List;

import com.sagar.studentmanagementsystem.entity.Role;
import com.sagar.studentmanagementsystem.entity.User;

public interface UserDao {

    public User findByUserName(String userName);
    
    public void save(User user);
    
    public List<Role> getRoles();
}
