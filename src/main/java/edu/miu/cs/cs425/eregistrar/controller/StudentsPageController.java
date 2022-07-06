package edu.miu.cs.cs425.eregistrar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentsPageController {
    @GetMapping(value = {"/eregistrar/students", "/eregistrar/all-students"})
    public String displayStudentsPage(){
        return "students/students";
    }
}
