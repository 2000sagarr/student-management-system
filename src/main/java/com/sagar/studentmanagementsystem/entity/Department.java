package com.sagar.studentmanagementsystem.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	public Department() {
	}

	public Department(String theName) {
		setName(theName);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public void add(Student tempStudent) {
//
//		if (students == null) {
//			students = new ArrayList<>();
//		}
//
//		students.add(tempStudent);
//
//		tempStudent.setDepartment(this);
//	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

}