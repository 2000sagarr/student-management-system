package com.sagar.studentmanagementsystem.service;

import java.util.List;

import com.sagar.studentmanagementsystem.entity.Student;

public interface StudentService {
	public void save(Student student);

	public List<Student> findAll();
	
	public void deleteById(int theId);
	
	public Student findById(int theId);
}
