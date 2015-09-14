package com.institute.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.institute.bean.CourseBean;
import com.institute.model.Course;
import com.institute.service.CourseService;

@Controller
public class CourseController  {
	@Autowired
	private CourseService courseServ;
	@RequestMapping(value="/coursepage",method=RequestMethod.POST)
	public ModelAndView course() {
		return  new ModelAndView("coursepage", "courseBean", new CourseBean());
	}
	@RequestMapping(value="/createCourse",method=RequestMethod.GET)
	public ModelAndView newCourse() {
		ModelAndView model=new ModelAndView();
		model.addObject("courseBean", new CourseBean());
		model.setViewName("createcourse");
	System.out.println("Here in listCourse");
	 return model;
	}
	@RequestMapping(value="/addCourse",method=RequestMethod.POST)
	public ModelAndView saveCourse(@ModelAttribute("courseBean")CourseBean courseBean,BindingResult result) {

		Course course=prepareModel(courseBean);
		courseServ.saveCourse(course);
		ModelAndView model=new ModelAndView();
		model.addObject("courseList", prepareListOfBean(courseServ.listAllCourse()));
		model.setViewName("coursepage");
	System.out.println("Here in listCourse");
	 return model;
	}
	@RequestMapping(value="/updateCourse",method=RequestMethod.POST)
	public ModelAndView updateCourse(@ModelAttribute("courseBean")CourseBean courseBean,BindingResult result) {

		Course course=prepareModel(courseBean);
		courseServ.saveCourse(course);
		ModelAndView model=new ModelAndView();
		model.addObject("courseList", prepareListOfBean(courseServ.listAllCourse()));
		model.setViewName("coursepage");
	System.out.println("Here in updateCourse");
	 return model;
	}
	@RequestMapping(value="/editCourse",method=RequestMethod.GET)
	public ModelAndView editCourse(@ModelAttribute("courseBean")CourseBean courseBean,BindingResult result) {
//		
//		CourseBean courseBean =new CourseBean();
//		courseBean.setCourseId(courseId);
		Course course=prepareModel(courseBean);
		ModelAndView model=new ModelAndView();
		System.out.println("value to edit "+course);
		model.setViewName("editcourse");
		System.out.println("getting values to edit course");
		 courseBean = prepareBean(courseServ.getCourseById(course.getCourseId()));
		 System.out.println("courseBean to edit "+prepareModel(courseBean));
		model.addObject("courseBean",courseBean);
		return model;
	}
	
	@RequestMapping(value="/courseById",method=RequestMethod.POST)
	public ModelAndView getCourseById(@ModelAttribute("courseBean")CourseBean courseBean,BindingResult result) {
	
		Course course=prepareModel(courseBean);
		Map<String,Object> model=new HashMap<String, Object>();
		model.put("course", prepareBean(courseServ.getCourseById(course.getCourseId())));
	//	model.put("courseList", prepareListOfBean(courseServ.listAllCourse()));
		 return new ModelAndView("redirect:/course.html");
	}



	@RequestMapping(value="/listCourse",method=RequestMethod.GET)
	public ModelAndView listAllCourse() {
			ModelAndView model=new ModelAndView();
			model.addObject("courseList", prepareListOfBean(courseServ.listAllCourse()));
			model.setViewName("coursepage");
		System.out.println("Here in listCourse");
		 return model;
	}
	@RequestMapping(value="/deleteCourse",method=RequestMethod.GET)
	public ModelAndView deleteCourse(@ModelAttribute("courseBean")CourseBean courseBean,BindingResult result) {
	
		Course course=prepareModel(courseBean);
		course=courseServ.getCourseById(course.getCourseId());
		 courseServ.deleteCourse(course);
		 System.out.println("course deleted "+course);
		 ModelAndView model=new ModelAndView();
			model.addObject("courseList", prepareListOfBean(courseServ.listAllCourse()));
			model.setViewName("coursepage");
		System.out.println("Here in listCourse");
		 return model;
	}

	private Object prepareListOfBean(List<Course> listAllCourse) {
		List<CourseBean> beans = null;
		if(listAllCourse!=null&& !listAllCourse.isEmpty()){
			beans = new ArrayList<CourseBean>();
			CourseBean courseBean = null;
			for (Course course : listAllCourse) {
				courseBean  =new CourseBean();
				courseBean.setCourseFee(course.getCourseFee());
				courseBean.setCourseHours(course.getCourseHours());
				courseBean.setCourseName(course.getCourseName());
				courseBean.setCourseId(course.getCourseId());
				beans.add(courseBean);
			}
			
		}
		return beans;
	}
	private CourseBean prepareBean(Course course) {
		CourseBean courseBean  =new CourseBean();
		courseBean.setCourseFee(course.getCourseFee());
		courseBean.setCourseHours(course.getCourseHours());
		courseBean.setCourseName(course.getCourseName());
		courseBean.setCourseId(course.getCourseId());
		return courseBean;
	}
	private Course prepareModel(CourseBean courseBean) {
		Course course =new Course();
		course.setCourseFee(courseBean.getCourseFee());
		course.setCourseHours(courseBean.getCourseHours());
		course.setCourseName(courseBean.getCourseName());
		course.setCourseId(courseBean.getCourseId());
		return course;
	}


}
