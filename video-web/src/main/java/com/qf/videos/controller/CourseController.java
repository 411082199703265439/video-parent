package com.qf.videos.controller;

import com.qf.videos.pojo.Subject;
import com.qf.videos.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseController courseService;
    @Autowired
    private SubjectService subjectService;

    @RequestMapping("/course/{subjectId}")
    public String course(@PathVariable String subjectId, Model model) {
        Subject subject = subjectService.selectSubjectById(subjectId);
        model.addAttribute("subject", subject);
        return "/before/course";
    }
}
