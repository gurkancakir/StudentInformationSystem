package com.gurkan.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gurkan.domain.User;
import com.gurkan.response.BaseError;
import com.gurkan.response.BaseSuccess;
import com.gurkan.service.UserServiceImpl;

import org.springframework.ui.Model;


@Controller
public class LoginController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView login() {

		ModelAndView model = new ModelAndView();
		model.setViewName("view/error/403");

		return model;

	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
		}

		if (logout != null) {
			model.addObject("msg", new BaseError("L03","logout.success"));
		}
		model.setViewName("view/login");

		return model;

	}
	
	// customize the error message
	private BaseError getErrorMessage(HttpServletRequest request, String key) {

		Exception exception = (Exception) request.getSession().getAttribute(key);
		BaseError error = null;
		if (exception instanceof BadCredentialsException) {
			error = new BaseError("L01","login.wrong");
		} /*else if (exception instanceof LockedException) {
			error = exception.getMessage();
		} else {
			error = "Invalid username and password!\n"+exception.getMessage();
		}*/
		return error;
	}

		
	
	/*	
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
			return "view/instructor/home";
		}
	}*/
	
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
