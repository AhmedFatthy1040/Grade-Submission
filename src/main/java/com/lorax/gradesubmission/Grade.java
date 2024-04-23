package com.lorax.gradesubmission;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;;
public class Grade {
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Subject is mandatory")
    private String subject;
    @Score(message = "The entered score is invalid!")
    private String score;
    private String id;

    public Grade() {
        this.id = UUID.randomUUID().toString();
    }

    public Grade(String name, String subject, String score) {
        this.name = name;
        this.subject = subject;
        this.score = score;
        this.id = UUID.randomUUID().toString();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getScore() {
        return this.score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}