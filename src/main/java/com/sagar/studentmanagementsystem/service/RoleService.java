package com.sagar.studentmanagementsystem.service;

import java.util.List;

import com.sagar.studentmanagementsystem.entity.Role;

public interface RoleService {
	public List<Role> findAll();
	
	public Role findRoleByName(String theRoleName);

}
