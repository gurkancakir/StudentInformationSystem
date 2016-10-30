package com.gurkan.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gurkan.domain.User;
import com.gurkan.response.BaseError;
import com.gurkan.response.BaseSuccess;
import com.gurkan.service.UserServiceImpl;

import org.springframework.ui.Model;


@Controller
public class LoginController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model) {
		
		System.out.println("login");
		
		return "view/login";
	}
		
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
		
		System.out.println("...login...");
		System.out.println(email+" "+password);
		User user = null;

		int userId = userServiceImpl.login(email, password);
		if ( userId == 0){
			model.addAttribute("error", new BaseError("L01", "login.wrong"));
			return "view/login";
		}else{
			model.addAttribute("user", userServiceImpl.getById(userId));
			return "view/home";
		}
	}
	
	@RequestMapping(value = "/forgot-password", method = RequestMethod.GET)
	public String forgotPasswordPage(Model model) {
		
		System.out.println("forgot-password");
		
		return "view/forgot";
	}
	
	@RequestMapping(value = "/forgot-password", method = RequestMethod.POST)
	public String forgotPassword(@RequestParam("email") String email, Model model) {
		
		System.out.println("forgot-password");
		System.out.println(email);
		
		User user = userServiceImpl.forgot(email);
		if (user == null) {
			model.addAttribute("error", new BaseError("F01", "forgot.wrong"));
		}else {
			model.addAttribute("success", new BaseSuccess("forgot.success.title", "forgot.success.body"));
		}
		
		return "view/forgot";
	}

}
