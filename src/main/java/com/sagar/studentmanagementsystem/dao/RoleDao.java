package com.sagar.studentmanagementsystem.dao;

import java.util.List;

import com.sagar.studentmanagementsystem.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
	public List<Role> findAll();
}
