package com.sagar.studentmanagementsystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagar.studentmanagementsystem.dao.RoleDao;
import com.sagar.studentmanagementsystem.entity.Role;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleDao roleDao;
	
	@Override
	@Transactional
	public List<Role> findAll() {
		return roleDao.findAll();
	}

	@Override
	@Transactional
	public Role findRoleByName(String theRoleName) {
		
		return roleDao.findRoleByName(theRoleName);
	}

}
