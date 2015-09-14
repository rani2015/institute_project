package com.institute.dao;

import java.util.List;

import com.institute.model.Teacher;

public interface TeacherDAO {
public Teacher save(Teacher teacher);
public Teacher getById(int teacherId);
public Teacher delete(Teacher teacher);
public List<Teacher> findAll();
}
