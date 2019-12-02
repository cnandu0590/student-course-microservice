package com.sample.demo.service;

import java.util.List;

import com.sample.demo.model.CourseBean;

public interface CourseService {
	
	CourseBean getCourseById(Integer id);

	boolean save(CourseBean course);

    void deleteCourse(Integer id);
    
    public List<CourseBean> getCourseList();
}
