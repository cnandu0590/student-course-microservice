package com.sample.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.demo.entity.Course;
import com.sample.demo.entity.Student;
import com.sample.demo.model.CourseBean;
import com.sample.demo.model.StudentBean;
import com.sample.demo.repository.StudentRepository;
import com.sample.demo.service.StudentService;
import com.sample.demo.util.NameComparator;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repository;

	@Override
	public StudentBean getStudentById(Integer id) {
		StudentBean bean = new StudentBean();
		Optional<Student> student = repository.findById(id);
		if (student.isPresent()) {
			Student s = student.get();
			bean.setEmailAddress(s.getEmailAddress());
			bean.setFirstName(s.getFirstName());
			bean.setLastName(s.getLastName());
			bean.setId(s.getId());
			bean.setMobileNumber(s.getMobileNumber());
		}

		return bean;
	}

	@Override
	public boolean save(StudentBean student) {
		Student stu = new Student();
		stu.setEmailAddress(student.getEmailAddress());
		stu.setFirstName(student.getFirstName());
		stu.setLastName(student.getLastName());
		stu.setId(student.getId());
		stu.setMobileNumber(student.getMobileNumber());
		CourseBean bean = student.getCourse();
		Course course = new Course();
		course.setId(bean.getId());
		course.setName(bean.getName());
		stu.setCourse(course);
		repository.save(stu);
		return true;
	}

	@Override
	public void deleteStudent(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<StudentBean> getStudentList() {
		List<StudentBean> studentBeanList = new ArrayList<>();
		List<Student> studentList = repository.findAll();
		for (Student student : studentList) {
			StudentBean bean = new StudentBean();
			bean.setEmailAddress(student.getEmailAddress());
			bean.setFirstName(student.getFirstName());
			bean.setLastName(student.getLastName());
			bean.setId(student.getId());
			bean.setMobileNumber(student.getMobileNumber());
			CourseBean courseBean = new CourseBean();
			if(null !=  student.getCourse()) {
				courseBean.setId(student.getCourse().getId());
				courseBean.setName(student.getCourse().getName());
				courseBean.setDescription(student.getCourse().getDescription());
			}
			bean.setCourse(courseBean);
			studentBeanList.add(bean);
		}
		return studentBeanList;
	}

	@Override
	public List<StudentBean> getStudentList(int courseId) {
		List<StudentBean> studentBeanList = new ArrayList<>();
		Course course= new Course();
		course.setId(courseId);
		List<Student> studentList = repository.findByCourse(course);
		for (Student student : studentList) {
			StudentBean bean = new StudentBean();
			bean.setEmailAddress(student.getEmailAddress());
			bean.setFirstName(student.getFirstName());
			bean.setLastName(student.getLastName());
			bean.setId(student.getId());
			bean.setMobileNumber(student.getMobileNumber());
			CourseBean courseBean = new CourseBean();
			if(null !=  student.getCourse()) {
				courseBean.setId(student.getCourse().getId());
				courseBean.setName(student.getCourse().getName());
				courseBean.setDescription(student.getCourse().getDescription());
			}
			bean.setCourse(courseBean);
			studentBeanList.add(bean);
		}
		studentBeanList.sort(new NameComparator());
		return studentBeanList;
	}

}
