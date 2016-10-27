package com.gurkan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import com.gurkan.domain.Role;
import com.gurkan.service.RoleServiceImpl;

@Controller
public class TestController {
	
	@Autowired
	private RoleServiceImpl roleServiceImpl;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getPersonList(Model model) {
		
		System.out.println("...getRoleList...");
		
		List<Role> personList = roleServiceImpl.getAll();
		
		System.out.println(personList.get(0));
		
		return "view/login";
	}

}
