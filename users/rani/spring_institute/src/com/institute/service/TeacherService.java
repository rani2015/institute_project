package com.institute.service;

import java.util.List;

import com.institute.model.Teacher;

public interface TeacherService {
public Teacher saveTeacher(Teacher teacher);
public Teacher getTeacherById(int teacherId);
public Teacher deleteTeacher(Teacher teacher);
public List<Teacher> listAllTeacher();
}
