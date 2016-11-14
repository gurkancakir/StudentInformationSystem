package com.gurkan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gurkan.domain.Faculty;
import com.gurkan.service.FacultyServiceImpl;
import com.gurkan.service.UserServiceImpl;

@Controller
public class AdminController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private FacultyServiceImpl facultyServiceImpl;
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminHome() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("view/admin/home");
		
		return model;
	}
	
	@RequestMapping(value = "/admin/faculty", method = RequestMethod.GET)
	public ModelAndView facultyList(@RequestParam(value="page", required=false) Integer page) {
		System.out.println(page);
		page = (page != null) ? page : 1;
	    int recordsPerPage = 10;
	    int totalSize = facultyServiceImpl.getAll().size();
	    int totalPage =  0;
	    if (totalSize % recordsPerPage == 0)
	    	totalPage = totalSize / recordsPerPage;
	    else
	    	totalPage = totalSize / recordsPerPage +1;
	    List<Faculty> list = facultyServiceImpl.getAllWithPagination((page-1)*recordsPerPage, recordsPerPage);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("view/admin/facultyList");
		model.addObject("facultyList", list);
		model.addObject("totalPage", totalPage);
		model.addObject("currentPage", page);
		
		return model;
	}
	
	@RequestMapping(value = "/admin/faculty/add", method = RequestMethod.GET)
	public ModelAndView facultyAdd() {
		ModelAndView model = new ModelAndView();
		model.setViewName("view/admin/facultyAdd");
		
		return model;
	}
	
	@RequestMapping(value = "/admin/faculty/add", method = RequestMethod.POST)
	public ModelAndView facultyAddSubmit(@ModelAttribute("newFaculty") Faculty faculty) {
		//faculteyi ekle
		facultyServiceImpl.insert(faculty);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/admin/faculty");
		
		return model;
	}
}
