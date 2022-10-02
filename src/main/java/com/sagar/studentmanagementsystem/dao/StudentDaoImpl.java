package com.sagar.studentmanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sagar.studentmanagementsystem.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void save(Student student) {
		Session session = entityManager.unwrap(Session.class);
		System.out.println(student);
		session.saveOrUpdate(student);
	}

	@Override
	public List<Student> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Student> query = currentSession.createQuery("from Student", Student.class);
		List<Student> students = query.getResultList();
		return students;
	}

	@Override
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<?> query = currentSession.createQuery("delete from Student where id=:StudentId");
		query.setParameter("StudentId", id);
		query.executeUpdate();
	}

	@Override
	public Student findById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Student student = currentSession.get(Student.class, theId);
		return student;
	}

}
