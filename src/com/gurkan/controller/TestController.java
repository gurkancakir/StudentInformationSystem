package com.gurkan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gurkan.domain.User;
import com.gurkan.service.UserServiceImpl;

import org.springframework.ui.Model;


@Controller
public class TestController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model) {
		
		System.out.println("login");
		
		//List<Role> personList = roleServiceImpl.getAll();
		
		//System.out.println(personList.get(0));
		
		return "view/login";
	}
	
	@RequestMapping(value = "/forgot-password", method = RequestMethod.GET)
	public String forgotPasswordPage(Model model) {
		
		System.out.println("forgot-password");
		
		return "view/forgot";
	}
	
	@RequestMapping(value = "/login.check", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password,Model model) {
		
		System.out.println("...login...");
		System.out.println(email+" "+password);
		User user = null;
		
		for (User u: userServiceImpl.getAll())
			if (u.getEmail().equals(email) && u.getPassword().equals(password))
				user = u;
		
		if (user != null){
			return "redirect:/home";
		}else{
			return "redirect:/login";
		}
		
	}

}
