package com.sample.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.demo.entity.Course;
import com.sample.demo.model.CourseBean;
import com.sample.demo.repository.CourseRepository;
import com.sample.demo.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository repository;

	@Override
	public CourseBean getCourseById(Integer id) {
		Optional<Course> course = repository.findById(id);
		CourseBean bean = new CourseBean();
		if (course.isPresent()) {
			Course cou = course.get();
			bean.setDescription(cou.getDescription());
			bean.setId(cou.getId());
			bean.setName(cou.getName());
		}

		return bean;
	}

	@Override
	public boolean save(CourseBean course) {
		Course cou = new Course();
		cou.setDescription(course.getDescription());
		cou.setId(course.getId());
		cou.setName(cou.getName());
		repository.save(cou);
		return false;
	}

	@Override
	public void deleteCourse(Integer id) {
		repository.deleteById(id);

	}

	@Override
	public List<CourseBean> getCourseList() {
		List<CourseBean> courseList = new ArrayList<>();
		List<Course> list = repository.findAll();
		for (Course course : list) {
			CourseBean bean = new CourseBean();
			bean.setDescription(course.getDescription());
			bean.setId(course.getId());
			bean.setName(course.getName());
			courseList.add(bean);

		}
		return courseList;
	}

}
