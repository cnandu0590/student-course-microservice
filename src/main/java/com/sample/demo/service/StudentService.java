package com.sample.demo.service;

import java.util.List;

import com.sample.demo.model.StudentBean;

public interface StudentService {

	
	StudentBean getStudentById(Integer id);

	boolean save(StudentBean student);

    void deleteStudent(Integer id);
    
    public List<StudentBean> getStudentList();

	List<StudentBean> getStudentList(int courseId);
    
    
}
