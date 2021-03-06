package com.gurkan.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.gurkan.domain.*;
import com.gurkan.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	
	@Autowired
	private DepartmentServiceImpl departmentServiceImpl;
	
	@Autowired
	private FacultyServiceImpl facultyServiceImpl;
	
	@Autowired
	private RoleServiceImpl roleServiceImpl;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private LessonServiceImpl lessonServiceImpl;

	@Autowired
	private SeasonServiceImpl seasonServiceImpl;
	
    private int recordsPerPage = 10;
	
	/*
	 * Task : Admin Home Page
	 * 
	 */
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminHome() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("view/admin/home");
		
		return model;
	}
	
	/*
	 * Task : Faculty List Page With Pagination
	 * 
	 */
	@RequestMapping(value = "/admin/faculty", method = RequestMethod.GET)
	public ModelAndView facultyList(@RequestParam(value="page", required=false) Integer page) {
		
		page = (page != null) ? page : 1;
	    int totalSize = facultyServiceImpl.getAll().size();
	    int totalPage =  0;
	    if (totalSize % recordsPerPage == 0)
	    	totalPage = totalSize / recordsPerPage;
	    else
	    	totalPage = totalSize / recordsPerPage +1;
	    List<Faculty> list = facultyServiceImpl.getAllWithPagination((page-1)*recordsPerPage, recordsPerPage);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("view/admin/faculty/list");
		model.addObject("facultyList", list);
		model.addObject("totalPage", totalPage);
		model.addObject("currentPage", page);
		
		return model;
	}
	
	/*
	 * Task : Faculty Add Page
	 * 
	 */
	@RequestMapping(value = "/admin/faculty/add", method = RequestMethod.GET)
	public ModelAndView facultyAdd() {
		ModelAndView model = new ModelAndView();
		model.setViewName("view/admin/faculty/add");
		model.addObject("newFaculty", new Faculty());
		
		return model;
	}
	
	/*
	 * Task : Faculty Add Page With Submit
	 * 
	 */
	@RequestMapping(value = "/admin/faculty/add", method = RequestMethod.POST)
	public ModelAndView facultyAddSubmit(@ModelAttribute("newFaculty") Faculty faculty) {
		//faculteyi ekle
		facultyServiceImpl.insert(faculty);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/admin/faculty");
		
		return model;
	}
	
	/*
	 * Task : Delete Faculty
	 * 
	 */
	@RequestMapping(value = "/admin/faculty/delete/{id}", method = RequestMethod.GET)
	public ModelAndView facultyDelete(@PathVariable(value="id") final String id) {
		
		facultyServiceImpl.delete(Integer.parseInt(id));
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/admin/faculty");
		
		return model;
	}
	
	/*
	 * Task : Update Faculty
	 * 
	 */
	@RequestMapping(value = "/admin/faculty/update/{id}", method = RequestMethod.GET)
	public ModelAndView facultyUpdate(@PathVariable(value="id") final String id) {
	    Faculty faculty = facultyServiceImpl.getById(Integer.parseInt(id));
	    System.out.println(faculty.getId() + " : "+ faculty.getName());
		ModelAndView model = new ModelAndView();
		model.setViewName("view/admin/faculty/update");
		model.addObject("updateFaculty", faculty);
		
		return model;
	}
	
	/*
	 * Task : Update Faculty With Submit
	 * 
	 */
	@RequestMapping(value = "/admin/faculty/update/{id}", method = RequestMethod.POST)
	public ModelAndView facultyUpdateSubmit(@ModelAttribute("updateFaculty") Faculty faculty,@PathVariable(value="id") final String id) {
		//faculteyi guncelle
		facultyServiceImpl.update(faculty);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/admin/faculty");
		
		return model;
	}
	
	/*
	 * Task : Department List Page With Pagination
	 * 
	 */
	@RequestMapping(value = "/admin/department", method = RequestMethod.GET)
	public ModelAndView departmentList(@RequestParam(value="page", required=false) Integer page) {
		
		page = (page != null) ? page : 1;
	    int totalSize = departmentServiceImpl.getAll().size();
	    int totalPage =  0;
	    if (totalSize % recordsPerPage == 0)
	    	totalPage = totalSize / recordsPerPage;
	    else
	    	totalPage = totalSize / recordsPerPage +1;
	    List<Department> list = departmentServiceImpl.getAllWithPagination((page-1)*recordsPerPage, recordsPerPage);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("view/admin/department/list");
		model.addObject("departmentList", list);
		model.addObject("totalPage", totalPage);
		model.addObject("currentPage", page);
		
		return model;
	}
	
	/*
	 * Task : Department Add Page
	 * 
	 */
	@RequestMapping(value = "/admin/department/add", method = RequestMethod.GET)
	public ModelAndView departmentAdd() {
		ModelAndView model = new ModelAndView();
		model.setViewName("view/admin/department/add");
		
		//fakulteleri listele
		List<Faculty> faculty = facultyServiceImpl.getAll();
		model.addObject("allFaculty",faculty);
		model.addObject("newDepartment", new Department());
		
		return model;
	}
	
	/*
	 * Task : Faculty Add Page With Submit
	 * 
	 */
	@RequestMapping(value = "/admin/department/add", method = RequestMethod.POST)
	public ModelAndView departmentAddSubmit(@ModelAttribute("newDepartment") Department department, @RequestParam("facultyId") Integer id) {
		
		if(id != -1){
			departmentServiceImpl.insert(department);
			System.out.println(id);
			department.setFaculty(facultyServiceImpl.getById(id));
			departmentServiceImpl.update(department);
		}
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/admin/department");
		
		return model;
	}
	
	/*
	 * Task : Update Department
	 * 
	 */
	@RequestMapping(value = "/admin/department/update/{id}", method = RequestMethod.GET)
	public ModelAndView departmentUpdate(@PathVariable(value="id") final String id) {
	    Department department = departmentServiceImpl.getById(Integer.parseInt(id));
	    System.out.println(department+" "+id+" "+Integer.parseInt(id));
		ModelAndView model = new ModelAndView();
		model.setViewName("view/admin/department/update");
		model.addObject("updateDepartment", department);
		
		//fakulteleri listele
		List<Faculty> faculty = facultyServiceImpl.getAll();
		model.addObject("allFaculty",faculty);
		
		return model;
	}
	
	/*
	 * Task : Update Department With Submit
	 * 
	 */
	@RequestMapping(value = "/admin/department/update/{id}", method = RequestMethod.POST)
	public ModelAndView departmentUpdateSubmit(@ModelAttribute("updateDepartment") Department department, @PathVariable(value="id") final String id, @RequestParam("facultyId") Integer facultyId) {
		
		//departmentServiceImpl.update(department);
		department.setFaculty(facultyServiceImpl.getById(facultyId));
		departmentServiceImpl.update(department);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/admin/department");
		
		return model;
	}
	
	/*
	 * Task : Delete Department
	 * 
	 */
	@RequestMapping(value = "/admin/department/delete/{id}", method = RequestMethod.GET)
	public ModelAndView departmentDelete(@PathVariable(value="id") final String id) {
		departmentServiceImpl.delete(Integer.parseInt(id));
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/admin/department");
		
		return model;
	}
	
	/*
	 * Task : Users List Page With Pagination
	 * 
	 */
	@RequestMapping(value = "/admin/user", method = RequestMethod.GET)
	public ModelAndView usersList(@RequestParam(value="page", required=false) Integer page) {
		
		page = (page != null) ? page : 1;
	    int totalSize = userServiceImpl.getAll().size();
	    int totalPage =  0;
	    if (totalSize % recordsPerPage == 0)
	    	totalPage = totalSize / recordsPerPage;
	    else
	    	totalPage = totalSize / recordsPerPage +1;
	    List<User> list = userServiceImpl.getAllWithPagination((page-1)*recordsPerPage, recordsPerPage);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("view/admin/user/list");
		model.addObject("userList", list);
		model.addObject("totalPage", totalPage);
		model.addObject("currentPage", page);
		
		return model;
	}
	
	/*
	 * Task : User Add Page
	 * 
	 */
	@RequestMapping(value = "/admin/user/add", method = RequestMethod.GET)
	public ModelAndView userAdd() {
		ModelAndView model = new ModelAndView();
		model.setViewName("view/admin/user/add");
		
		//Rolleri listele
		List<Role> role = roleServiceImpl.getAll();
		model.addObject("allRole",role);
		model.addObject("newUser", new User());
		
		return model;
	}
	
	/*
	 * Task : User Add Page With Submit
	 * 
	 */
	@RequestMapping(value = "/admin/user/add", method = RequestMethod.POST)
	public ModelAndView userAddSubmit(@ModelAttribute("newUser") User user, @RequestParam("roleId") Integer id) {

		if(id != -1){
			userServiceImpl.insert(user);
			System.out.println(id);
			user.setRole(roleServiceImpl.getById(id));
			userServiceImpl.update(user);
		}
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/admin/user");
		
		return model;
	}
	
	/*
	 * Task : Update User
	 * 
	 */
	@RequestMapping(value = "/admin/user/update/{id}", method = RequestMethod.GET)
	public ModelAndView userUpdate(@PathVariable(value="id") final String id) {
	    User user = userServiceImpl.getById(Integer.parseInt(id));
	    
		ModelAndView model = new ModelAndView();
		model.setViewName("view/admin/user/update");
		model.addObject("updateUser", user);
		
		//Rolleri listele
		List<Role> role = roleServiceImpl.getAll();
		model.addObject("allRole",role);
		
		return model;
	}
	
	/*
	 * Task : Update Department With Submit
	 * 
	 */
	@RequestMapping(value = "/admin/user/update/{id}", method = RequestMethod.POST)
	public ModelAndView userUpdateSubmit(@ModelAttribute("updateUser") User user, @PathVariable(value="id") final String id, @RequestParam("roleId") Integer roleId,@RequestParam("file") String file) {
		System.out.println(file);//test
		user.setRole(roleServiceImpl.getById(roleId));
		userServiceImpl.update(user);
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/admin/user");
		
		return model;
	}
	
	/*
	 * Task : Delete User
	 * 
	 */
	@RequestMapping(value = "/admin/user/delete/{id}", method = RequestMethod.GET)
	public ModelAndView userDelete(@PathVariable(value="id") final String id) {
		userServiceImpl.delete(Integer.parseInt(id));
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/admin/user");
		
		return model;
	}
	
	/*
	 * Task : Lesson List Page With Pagination
	 * 
	 */
	@RequestMapping(value = "/admin/lesson", method = RequestMethod.GET)
	public ModelAndView lessonList(@RequestParam(value="page", required=false) Integer page) {
		
		page = (page != null) ? page : 1;
	    int totalSize = lessonServiceImpl.getAll().size();
	    int totalPage =  0;
	    if (totalSize % recordsPerPage == 0)
	    	totalPage = totalSize / recordsPerPage;
	    else
	    	totalPage = totalSize / recordsPerPage +1;
	    List<Lesson> list = lessonServiceImpl.getAllWithPagination((page-1)*recordsPerPage, recordsPerPage);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("view/admin/lesson/list");
		model.addObject("lessonList", list);
		model.addObject("totalPage", totalPage);
		model.addObject("currentPage", page);
		
		return model;
	}

	/*
	 * Task : Lesson Add Page
	 *
	 */
	@RequestMapping(value = "/admin/lesson/add", method = RequestMethod.GET)
	public ModelAndView lessonAdd() {
		ModelAndView model = new ModelAndView();
		model.setViewName("view/admin/lesson/add");

		List<Season> seasons = seasonServiceImpl.getAll();
		List<Department> departments = departmentServiceImpl.getAll();
		List<User> instructors = userServiceImpl.getAll();
		
		for(int i=0; i< instructors.size(); i++)
			if (instructors.get(i).getRole() == null || instructors.get(i).getRole().getId() != 2)
				instructors.remove(i);
		
		model.addObject("allSeason", seasons);
		model.addObject("allInstructor",instructors);
		model.addObject("allDepartment",departments);
		model.addObject("newLesson", new Lesson());

		return model;
	}
	
	/*
	 * Task : Lesson Add Page With Submit
	 * 
	 */
	@RequestMapping(value = "/admin/lesson/add", method = RequestMethod.POST)
	public ModelAndView lessonAddSubmit(@ModelAttribute("newLesson") Lesson lesson, @RequestParam("departmentId") Integer depId, @RequestParam("instructorId") Integer insId, @RequestParam("seasonId") Integer seasonId) {
		
		if (depId != -1 && insId != -1 && seasonId != -1){
			lesson.setDepartment(departmentServiceImpl.getById(depId));
			lesson.setInstructor(userServiceImpl.getById(insId));
			lesson.setSeason(seasonServiceImpl.getById(seasonId));
		}
		lessonServiceImpl.insert(lesson);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/admin/lesson");
		
		return model;
	}
	
	/*
	 * Task : Update Lesson
	 * 
	 */
	@RequestMapping(value = "/admin/lesson/update/{id}", method = RequestMethod.GET)
	public ModelAndView lessonUpdate(@PathVariable(value="id") final String id) {
	    Lesson lesson = lessonServiceImpl.getById(Integer.parseInt(id));
	    
		ModelAndView model = new ModelAndView();
		model.setViewName("view/admin/lesson/update");
		model.addObject("updateLesson", lesson);
		
		List<Department> departments = departmentServiceImpl.getAll();
		List<User> instructors = userServiceImpl.getAll();
		for(int i=0; i< instructors.size(); i++)
			if (instructors.get(i).getRole() == null || instructors.get(i).getRole().getId() != 2)
				instructors.remove(i);
		model.addObject("allInstructor",instructors);
		model.addObject("allDepartment",departments);
		
		return model;
	}
	
	/*
	 * Task : Update Lesson With Submit
	 * 
	 */
	@RequestMapping(value = "/admin/lesson/update/{id}", method = RequestMethod.POST)
	public ModelAndView lessonUpdateSubmit(@ModelAttribute("updateLesson") Lesson lesson, @PathVariable(value="id") final String id, @RequestParam("departmentId") Integer depId, @RequestParam("instructorId") Integer insId) {
		
		if (depId != -1 && insId != -1){
			lesson.setDepartment(departmentServiceImpl.getById(depId));
			lesson.setInstructor(userServiceImpl.getById(insId));
		}
		lessonServiceImpl.update(lesson);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/admin/lesson");
		
		return model;
	}
	
	/*
	 * Task : Delete Lesson
	 * 
	 */
	@RequestMapping(value = "/admin/lesson/delete/{id}", method = RequestMethod.GET)
	public ModelAndView lessonDelete(@PathVariable(value="id") final String id) {
		lessonServiceImpl.delete(Integer.parseInt(id));
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/admin/lesson");
		
		return model;
	}

	/*
	 * Task : Season List Page With Pagination
	 *
	 */
	@RequestMapping(value = "/admin/season", method = RequestMethod.GET)
	public ModelAndView seasonList(@RequestParam(value="page", required=false) Integer page) {

		page = (page != null) ? page : 1;
		int totalSize = seasonServiceImpl.getAll().size();
		int totalPage =  0;
		if (totalSize % recordsPerPage == 0)
			totalPage = totalSize / recordsPerPage;
		else
			totalPage = totalSize / recordsPerPage +1;
		List<Season> list = seasonServiceImpl.getAllWithPagination((page-1)*recordsPerPage, recordsPerPage);

		ModelAndView model = new ModelAndView();
		model.setViewName("view/admin/season/list");
		model.addObject("seasonList", list);
		model.addObject("totalPage", totalPage);
		model.addObject("currentPage", page);

		return model;
	}

	/*
	 * Task : Season Add Page
	 *
	 */
	@RequestMapping(value = "/admin/season/add", method = RequestMethod.GET)
	public ModelAndView seasonAdd() {
		ModelAndView model = new ModelAndView();
		model.setViewName("view/admin/season/add");

		model.addObject("newSeason", new Season());

		return model;
	}

	/*
	 * Task : Season Add Page With Submit
	 *
	 */
	@RequestMapping(value = "/admin/season/add", method = RequestMethod.POST)
	public ModelAndView seasonAddSubmit(@ModelAttribute("newSeason") @Validated Season season, BindingResult result) {

		ModelAndView model = new ModelAndView();
		
		if (result.hasErrors()) {
			System.out.println(result.getFieldError().getDefaultMessage());
		}else {

			seasonServiceImpl.insert(season);
			model.setViewName("redirect:/admin/season");
		}

		return model;
	}

	/*
	*  Datetime formatini formdan nasil tasiyacagi
	* */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
	
	/*
	 * Task : Update Season
	 * 
	 */
	@RequestMapping(value = "/admin/season/update/{id}", method = RequestMethod.GET)
	public ModelAndView seasonUpdate(@PathVariable(value="id") final String id) {
	    Season season = seasonServiceImpl.getById(Integer.parseInt(id));
	    
		ModelAndView model = new ModelAndView();
		model.setViewName("view/admin/season/update");
		model.addObject("updateSeason", season);
		
		return model;
	}
	
	/*
	 * Task : Update Season With Submit
	 * 
	 */
	@RequestMapping(value = "/admin/season/update/{id}", method = RequestMethod.POST)
	public ModelAndView seasonUpdateSubmit(@ModelAttribute("updateSeason") Season season ) {
		
		seasonServiceImpl.update(season);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/admin/season");
		
		return model;
	}
	
	/*
	 * Task : Delete Season
	 * 
	 */
	@RequestMapping(value = "/admin/season/delete/{id}", method = RequestMethod.GET)
	public ModelAndView seasonDelete(@PathVariable(value="id") final String id) {
		
		seasonServiceImpl.delete(Integer.parseInt(id));
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/admin/season");
		
		return model;
	}
	
	
}
