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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.demo.model.StudentBean;
import com.sample.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService service;

	@PostMapping
	private ResponseEntity<Boolean> saveStudent(@RequestBody StudentBean student) {
		service.save(student);
		return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	private ResponseEntity<Void> deleteStudent(@PathVariable("id") Integer id) {
		service.deleteStudent(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("/{id}")
	private ResponseEntity<StudentBean> getStudent(@PathVariable("id") Integer id) {
		StudentBean bean = service.getStudentById(id);
		return new ResponseEntity<StudentBean>(bean, HttpStatus.OK);
	}

	@GetMapping("/get-all-students")
	private ResponseEntity<List<StudentBean>> getAllStudents() {
		List<StudentBean> list = service.getStudentList();
		return new ResponseEntity<List<StudentBean>>(list, HttpStatus.OK);
	}

	@GetMapping("/get-students-by-course")
	private ResponseEntity<List<StudentBean>> getAllStudentByCourse(
			@RequestParam(name = "id", required = false) int courseId) {
		List<StudentBean> list = service.getStudentList(courseId);
		return new ResponseEntity<List<StudentBean>>(list, HttpStatus.OK);
	}
}
