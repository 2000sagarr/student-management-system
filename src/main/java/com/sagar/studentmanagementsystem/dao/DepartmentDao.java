package com.sagar.studentmanagementsystem.dao;

import java.util.List;

import com.sagar.studentmanagementsystem.entity.Department;

public interface DepartmentDao {
	public List<Department> findAll();

	public Department findById(int theId);

	public void save(Department theDepartment);

	public void deleteById(int theId);
	
	public Department findByName(String name);
}	
