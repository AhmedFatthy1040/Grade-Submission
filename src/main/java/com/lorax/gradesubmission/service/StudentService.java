package com.lorax.gradesubmission.service;

import java.util.List;

import com.lorax.gradesubmission.model.Student;

public interface StudentService {
    Student getStudent(Long id);
    Student saveStudent(Student student);
    void deleteStudent(Long id);
    List<Student> getStudents();
}