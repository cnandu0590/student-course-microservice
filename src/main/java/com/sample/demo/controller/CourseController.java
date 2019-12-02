package com.sample.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.demo.model.CourseBean;
import com.sample.demo.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private CourseService service;

	@PostMapping
	private ResponseEntity<Boolean> saveCourse(@RequestBody CourseBean course) {
		service.save(course);
		return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	private ResponseEntity<Void> deleteCourse(@PathVariable("id") Integer id) {
		service.deleteCourse(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("/{id}")
	private ResponseEntity<CourseBean> getCourseById(@PathVariable("id") Integer id) {
		CourseBean bean = service.getCourseById(id);
		return new ResponseEntity<CourseBean>(bean, HttpStatus.OK);
	}

	@GetMapping("/get-all-course")
	private ResponseEntity<List<CourseBean>> getAllCourse(){
		List<CourseBean> list = service.getCourseList();
		return new ResponseEntity<List<CourseBean>>(list,HttpStatus.OK);
	}
}
