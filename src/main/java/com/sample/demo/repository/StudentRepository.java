package com.sample.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.demo.entity.Course;
import com.sample.demo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	List<Student> findByCourse(Course course);

}
