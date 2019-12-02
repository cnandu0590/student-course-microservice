package com.sample.demo.model;

import java.util.HashSet;
import java.util.Set;

import com.sample.demo.entity.Student;

public class CourseBean {
	private int id;
	private String name;
	private String description;
	private Set<StudentBean> studentList = new HashSet<StudentBean>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<StudentBean> getStudentList() {
		return studentList;
	}

	public void setStudentList(Set<StudentBean> studentList) {
		this.studentList = studentList;
	}

}
