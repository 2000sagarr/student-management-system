package com.sagar.studentmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sagar.studentmanagementsystem.entity.Department;
import com.sagar.studentmanagementsystem.entity.Student;
import com.sagar.studentmanagementsystem.service.DepartmentService;
import com.sagar.studentmanagementsystem.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private DepartmentService departmentService;

	@GetMapping("/showStudentForm")
	public String showStudentForm(Model model) {
		List<Department> departments = departmentService.findAll();
		Student s = new Student();
		s.setId(0);
		model.addAttribute("student", s);
		model.addAttribute("departments", departments);
		return "student-form";
	}

	@PostMapping("/processStudentForm")
	public String processStudentForm(@ModelAttribute Student student) {

		studentService.save(student);
		return "redirect:/students/";
	}

	@GetMapping("/")
	public String showStudents(Model model) {
		List<Student> students = studentService.findAll();
		for (Student s : students) {
			System.out.println(s.getStudentDetail().getFirstName());
		}
		model.addAttribute("students", students);
		return "show-students";
	}

	@GetMapping("/delete")
	public String deleteDepartment(@RequestParam("studentId") int theId) {
		studentService.deleteById(theId);
		return "redirect:/students/";
	}

	@GetMapping("/update")
	public String updateStudent(@RequestParam("studentId") int theId, Model model) {
		Student student = studentService.findById(theId);
		model.addAttribute("student", student);
		return "student-form";
	}
}
