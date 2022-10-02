package com.sagar.studentmanagementsystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagar.studentmanagementsystem.dao.DepartmentDao;
import com.sagar.studentmanagementsystem.entity.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentDao departmentDao;
	
	@Override
	@Transactional
	public void save(Department department) {
		departmentDao.save(department);
	}

	@Override
	@Transactional
	public List<Department> findAll() {
		return departmentDao.findAll();
	}

	@Override
	@Transactional
	public Department findById(int theId) {
		return departmentDao.findById(theId);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		departmentDao.deleteById(theId);
	}

	@Override
	public Department findByName(String name) {
		return departmentDao.findByName(name);
	}

}
