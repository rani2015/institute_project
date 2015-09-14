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

import com.institute.bean.TeacherBean;
import com.institute.model.Teacher;
import com.institute.service.TeacherService;

@Controller
public class TeacherController  {
	@Autowired
	private TeacherService teacherServ;

	@RequestMapping(value="/teacherSave",method=RequestMethod.POST)
	public ModelAndView saveTeacher(@ModelAttribute("command")TeacherBean teacherBean,BindingResult result) {

		Teacher teacher=prepareModel(teacherBean);
		teacherServ.saveTeacher(teacher);
		return new ModelAndView("redirect:/add.html");
	}
	private TeacherBean prepareBean(Teacher teacher) {
		TeacherBean teacherBean  =new TeacherBean();
		
		teacherBean.setTeacherPhoneNo(teacher.getTeacherPhoneNo());
		teacherBean.setTeacherLastName(teacher.getTeacherLastName());
		
		
		teacherBean.setTeacherFirstName(teacher.getTeacherFirstName());
		teacherBean.setTeacherEmailId(teacher.getTeacherEmailId());
		
		teacherBean.setTeacherCellNo(teacher.getTeacherCellNo());
		
		return teacherBean;
	}
	private Teacher prepareModel(TeacherBean teacherBean) {
		Teacher teacher =new Teacher();
		teacher.setTeacherId(teacherBean.getTeacherId());
		teacher.setTeacherPhoneNo(teacherBean.getTeacherPhoneNo());
		teacher.setTeacherLastName(teacherBean.getTeacherLastName());
		
		teacher.setTeacherFirstName(teacherBean.getTeacherFirstName());
		teacher.setTeacherEmailId(teacherBean.getTeacherEmailId());
		
		teacher.setTeacherCellNo(teacherBean.getTeacherCellNo());
		
		return teacher;
	}

	@RequestMapping(value="/teacherById",method=RequestMethod.POST)
	public ModelAndView getTeacherById(@ModelAttribute("command")TeacherBean teacherBean,BindingResult result) {
	
		Teacher teacher=prepareModel(teacherBean);
		Map<String,Object> model=new HashMap<String, Object>();
		model.put("teacher", prepareBean(teacherServ.getTeacherById(teacher.getTeacherId())));
		model.put("listTeacher", prepareListOfBean(teacherServ.listAllTeacher()));
		 return new ModelAndView("redirect:/teacher.html");
	}

	@RequestMapping(value="/deleteTeacher",method=RequestMethod.POST)
	public ModelAndView deleteTeacher(@ModelAttribute("command")TeacherBean teacherBean,BindingResult result) {
	
		Teacher teacher=prepareModel(teacherBean);
		 teacherServ.deleteTeacher(teacher);
		 Map<String,Object> model=new HashMap<String, Object>();
			model.put("teacher", null);
			model.put("listTeacher", prepareListOfBean(teacherServ.listAllTeacher()));
		 return new ModelAndView("redirect:/listTeacher.jsp");
	}

	@RequestMapping(value="/listTeacher",method=RequestMethod.GET)
	public ModelAndView listAllTeacher() {
			Map<String,Object> model=new HashMap<String, Object>();
			model.put("listTeacher", prepareListOfBean(teacherServ.listAllTeacher()));
		
		 return new ModelAndView("redirect:/listTeacher.jsp");
	}

	private Object prepareListOfBean(List<Teacher> listAllTeacher) {
		List<TeacherBean> beans = null;
		if(listAllTeacher!=null&& !listAllTeacher.isEmpty()){
			beans = new ArrayList<TeacherBean>();
			TeacherBean teacherBean = null;
			for (Teacher teacher : listAllTeacher) {
				teacherBean  =new TeacherBean();
				teacherBean.setTeacherId(teacher.getTeacherId());
				teacherBean.setTeacherPhoneNo(teacher.getTeacherPhoneNo());
				teacherBean.setTeacherLastName(teacher.getTeacherLastName());
				teacherBean.setTeacherFirstName(teacher.getTeacherFirstName());
				teacherBean.setTeacherEmailId(teacher.getTeacherEmailId());
				teacherBean.setTeacherCellNo(teacher.getTeacherCellNo());
				beans.add(teacherBean);
			}
			
		}
		return beans;
	}

}
