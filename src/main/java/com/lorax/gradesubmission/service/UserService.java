package com.lorax.gradesubmission.service;


import com.lorax.gradesubmission.model.User;

public interface UserService {
    User getUser(Long id);
    User getUser(String username);
    User saveUser(User user);
}