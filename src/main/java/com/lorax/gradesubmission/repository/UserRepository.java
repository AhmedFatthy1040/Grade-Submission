package com.lorax.gradesubmission.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.lorax.gradesubmission.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	Optional<User> findByUsername(String username);
}