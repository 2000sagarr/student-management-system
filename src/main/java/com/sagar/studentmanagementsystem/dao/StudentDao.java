package com.sagar.studentmanagementsystem.dao;

import java.util.List;

import com.sagar.studentmanagementsystem.entity.Student;

public interface StudentDao {
	public void save(Student student);
	
	public List<Student> findAll();
	
	public void deleteById(int id);

	public Student findById(int theId);
}
