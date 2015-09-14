package com.institute.dao;

import java.util.List;

import com.institute.model.Section;

public interface SectionDAO {
public Section save(Section section);
public Section getById(int id);
public Section delete(Section section);
public List<Section> findAll();
}
