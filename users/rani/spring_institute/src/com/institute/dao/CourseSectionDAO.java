package com.institute.dao;

import java.util.List;

import com.institute.model.CourseSection;

public interface CourseSectionDAO {
public CourseSection save(CourseSection courseSection);
public CourseSection getById(int id);
public CourseSection delete(CourseSection courseSection);
public List<CourseSection> findAll();
}
