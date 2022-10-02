package com.sagar.studentmanagementsystem.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.sagar.studentmanagementsystem.entity.Role;
import com.sagar.studentmanagementsystem.entity.User;
import com.sagar.studentmanagementsystem.user.CrmUser;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

	public void save(CrmUser crmUser);
    public List<Role> getRoles();

}
