package com.gurkan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gurkan.service.UserServiceImpl;

@Controller
public class InstructorController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping(value = {"/","/instructor"}, method = RequestMethod.GET)
	public ModelAndView instructorHome() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("view/instructor/home");
		System.out.println("instructor");
		
		return model;
	}

	@RequestMapping(value = "/instructor/messages", method = RequestMethod.GET)
	public ModelAndView messagesPage() {
		
		System.out.println("messages");
		
		ModelAndView model = new ModelAndView();
		model.setViewName("view/instructor/messages");
		
		return model;
	}
}
