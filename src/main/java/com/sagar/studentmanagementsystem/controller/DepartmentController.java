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
import com.sagar.studentmanagementsystem.service.DepartmentService;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/showDepartmentForm")
	public String showDepartmentForm(Model modole) {
		Department department = new Department();
		modole.addAttribute("department", department);
		return "department-form";
	}
	
	@PostMapping("/processDepartmentForm")
	public String processDepartmentForm(@ModelAttribute Department department, Model model) {
		String deptName = department.getName();
		Department deptExist = departmentService.findByName(deptName);
		System.out.println(deptExist);
		if(deptExist != null) {
			model.addAttribute("department",deptExist);
			model.addAttribute("departmentError", "Department already exists.");
			return "department-form";
		}
		departmentService.save(department);
		model.addAttribute("department", new Department(""));
		return "redirect:/departments/";
	}
	
	@GetMapping("/")
	public String showAllDepartment(Model model) {
		List<Department> departments = departmentService.findAll();
		model.addAttribute("departments", departments);
		return "show-departments";
	}
	
	@GetMapping("/delete")
	public String deleteDepartment(@RequestParam("departmentId") int theId) {
		departmentService.deleteById(theId);
		return "redirect:/departments/";
	}
}
