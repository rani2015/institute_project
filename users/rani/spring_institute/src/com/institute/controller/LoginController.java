package com.institute.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.institute.bean.LoginBean;
import com.institute.model.Login;
import com.institute.service.LoginService;


@Controller
public class LoginController  {
	@Autowired
	private LoginService loginServ;

	
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView login(){
		//model.addAttribute("userBean", new UserBean());
		return new ModelAndView("login", "loginBean", new LoginBean());
	}
	@RequestMapping(value="/loginUser",method=RequestMethod.POST)
	public ModelAndView onSubmit(HttpSession session,@ModelAttribute("userBean")LoginBean loginBean,BindingResult result) {

		Login login=prepareModel(loginBean);
		boolean isUserValid=loginServ.validateUser(login);
		String url="listAll";
		if(isUserValid)
			url="welcome";
		else 
			url="error";
		ModelAndView model = new ModelAndView();
		session.setAttribute("loginBean", prepareBean(login));
		model.setViewName(url);
		model.addObject("loginBean", prepareBean(login));
			
		return model; 
	}
	@RequestMapping(value="/welcome",method=RequestMethod.GET)
	public ModelAndView home(HttpSession session) {
		
		return new ModelAndView("welcome", "loginBean", session.getAttribute("loginBean"));
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.POST)
	public String logOut(@ModelAttribute("loginBean")LoginBean loginBean,BindingResult result) {

		Login login=prepareModel(loginBean);
		boolean isUserLoggedOut=loginServ.logoutUser(login);
		Map<String,Object> model=new HashMap<String, Object>();
		if(isUserLoggedOut)
		model.put("successMsg", login.getUserId()+" : Logged Out Successfully");
		
		return "logout";
	}
		private LoginBean prepareBean(Login login) {
		LoginBean loginBean  =new LoginBean();
		loginBean.setPassword(login.getPassword());
		loginBean.setUserId(login.getUserId());
		
		return loginBean;
	}
	private Login prepareModel(LoginBean loginBean) {
		Login user =new Login();
		user.setPassword(loginBean.getPassword());
		user.setUserId(loginBean.getUserId());
		
		return user;
	}

}
