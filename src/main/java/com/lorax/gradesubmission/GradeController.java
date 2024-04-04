package com.lorax.gradesubmission;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class GradeController {

    List<Grade> studentGrades = new ArrayList<>();

    @GetMapping("/")
    public String gradeForm(Model model) {
        model.addAttribute("grade", new Grade());
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitFrom(Grade grade) {
        studentGrades.add(grade);
        return "redirect:/grades";
    }

    @GetMapping("/grades")
    public String getGrades(Model model) {
        model.addAttribute("grades", studentGrades);
        return "grades";
    }
}