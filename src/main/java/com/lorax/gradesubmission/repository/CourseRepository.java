package com.lorax.gradesubmission.repository;

import org.springframework.data.repository.CrudRepository;

import com.lorax.gradesubmission.model.Course;

public interface CourseRepository extends CrudRepository<Course, Long>{

}