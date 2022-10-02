package com.sagar.studentmanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sagar.studentmanagementsystem.entity.Department;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Department> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Department> query = currentSession.createQuery("from Department", Department.class);
		List<Department> departments = query.getResultList();
		return departments;
	}

	@Override
	public Department findById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		return currentSession.get(Department.class, theId);
	}

	@Override
	public void save(Department theDepartment) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(theDepartment);
	}

	@Override
	public void deleteById(int theId) {
		Session session = entityManager.unwrap(Session.class);

		Query<?> theQuery = 
				session.createQuery(
						"delete from Department where id=:ID");
		theQuery.setParameter("ID", theId);
		
		theQuery.executeUpdate();
	}

	@Override
	public Department findByName(String theName) {
		Session currentSession = entityManager.unwrap(Session.class);

		// now retrieve/read from database using username
		Query<Department> theQuery = currentSession.createQuery("from Department where name=:Name", Department.class);
		theQuery.setParameter("Name", theName);
		System.out.println(theName);
		Department theDepartment = null;
		try {
			theDepartment = theQuery.getSingleResult();
		} catch (Exception e) {
			theDepartment = null;
		}
		return theDepartment;

	}

}
