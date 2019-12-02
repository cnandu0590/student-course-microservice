package com.sample.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.demo.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
