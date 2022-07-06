package edu.miu.cs.cs425.eregistrar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class NewStudentPageController {
    @GetMapping(value = {"/eregistrar/newstudent", "/eregistrar/new-student"})
    public String displayNewStudentPage(){
        return "home/students/newstudent";
    }
}
