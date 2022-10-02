package com.sagar.studentmanagementsystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagar.studentmanagementsystem.dao.StudentDao;
import com.sagar.studentmanagementsystem.entity.Student;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao studentDao;
	
	@Override
	@Transactional
	public void save(Student student) {
		studentDao.save(student);
	}

	@Override
	@Transactional
	public List<Student> findAll() {
		
		return studentDao.findAll();
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		studentDao.deleteById(theId);
	}

	@Override
	public Student findById(int theId) {
		return studentDao.findById(theId);
	}

}
