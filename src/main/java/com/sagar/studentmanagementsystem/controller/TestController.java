package com.sagar.studentmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sagar.studentmanagementsystem.entity.Role;
import com.sagar.studentmanagementsystem.service.RoleService;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/roles")
	public List<Role> getRole(){
		return roleService.findAll();
	}
}
