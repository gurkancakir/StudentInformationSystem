package com.gurkan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gurkan.service.UserServiceImpl;

@Controller
public class InstructorController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping(value = "/instructor", method = RequestMethod.GET)
	public String loginPage(Model model) {
		
		System.out.println("instructor");
		
		return "view/instructor/home";
	}

	@RequestMapping(value = "/instructor/messages", method = RequestMethod.GET)
	public String messagesPage(Model model) {
		
		System.out.println("messages");
		
		return "view/instructor/messages";
	}
}
