package com.lorax.gradesubmission.service;

import java.util.List;

import com.lorax.gradesubmission.model.Course;

public interface CourseService {
    Course getCourse(Long id);
    Course saveCourse(Course course);
    void deleteCourse(Long id);
    List<Course> getCourses();
}