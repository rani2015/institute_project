package com.institute.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.institute.dao.TeacherDAO;
import com.institute.model.Teacher;

@Service("teacherService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class TeacherServiceImpl implements TeacherService {
	@Autowired
	private TeacherDAO teacherDAO;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Teacher saveTeacher(Teacher teacher) {

		System.out.println("Teacher saved :  " + teacher);
		return teacherDAO.save(teacher);
	}

	@Override
	public Teacher getTeacherById(int teacherId) {
		System.out.println("Teacher getting  :  " + teacherId);
		return teacherDAO.getById(teacherId);
	}

	@Override
	public Teacher deleteTeacher(Teacher teacher) {

		return teacherDAO.delete(teacher);
	}

	@Override
	public List<Teacher> listAllTeacher() {

		return teacherDAO.findAll();
	}

}
