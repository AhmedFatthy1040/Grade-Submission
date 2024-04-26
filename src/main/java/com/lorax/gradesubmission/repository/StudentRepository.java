package com.lorax.gradesubmission.repository;

import org.springframework.data.repository.CrudRepository;

import com.lorax.gradesubmission.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}