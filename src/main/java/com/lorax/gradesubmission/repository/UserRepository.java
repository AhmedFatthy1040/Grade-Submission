package com.lorax.gradesubmission.repository;

import org.springframework.data.repository.CrudRepository;

import com.lorax.gradesubmission.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}