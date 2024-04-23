package com.lorax.gradesubmission.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lorax.gradesubmission.Grade;
import com.lorax.gradesubmission.service.GradeService;

import jakarta.validation.Valid;


@Controller
public class GradeController {

    @Autowired
    GradeService gradeService;

    @GetMapping("/")
    public String gradeForm(Model model, @RequestParam(required = false) String id) {
        model.addAttribute("grade", gradeService.getGradeById(id));
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitFrom(@Valid Grade grade, BindingResult result) {
        if (result.hasErrors()) {
            return "form";
        }

        gradeService.submitGrade(grade);

        return "redirect:/grades";
    }

    @GetMapping("/grades")
    public String getGrades(Model model) {
        model.addAttribute("grades", gradeService.getGrades());
        return "grades";
    }
}