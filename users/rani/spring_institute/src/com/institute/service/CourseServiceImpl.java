package com.institute.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.institute.dao.CourseDAO;
import com.institute.model.Course;

@Service("courseService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDAO courseDAO;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Course saveCourse(Course course) {

		System.out.println("Course saved :  " + course);
		return courseDAO.save(course);
	}

	@Override
	public Course getCourseById(String courseId) {

		return (Course) courseDAO.getById(courseId);
	}

	@Override
	public Course deleteCourse(Course course) {

		return courseDAO.delete(course);
	}

	@Override
	public List<Course> listAllCourse() {

		return courseDAO.findAll();
	}

}
