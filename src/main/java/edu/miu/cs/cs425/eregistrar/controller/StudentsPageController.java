package edu.miu.cs.cs425.eregistrar.controller;

import edu.miu.cs.cs425.eregistrar.model.Student;
import edu.miu.cs.cs425.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value={"/eregistrar/students"})
public class StudentsPageController {

    @Autowired
    private StudentService studentService;
    @GetMapping(value = {"/students", "/all-students"})
    public ModelAndView displayStudents(){
        var students = studentService.getAllStudents();
        var modelAndView = new ModelAndView();
        modelAndView.addObject("students", students);
        modelAndView.setViewName("students/students");
        return modelAndView;
    }
    @GetMapping(value = {"/newstudent", "/new-student", "/new"})
    public String displayNewStudentForm(Model model){
        var newStudent = new Student();
        model.addAttribute("student", newStudent);
        return "students/newstudent";
    }
    @PostMapping(value={"/new"})
    public String addNewStudent(@Valid @ModelAttribute("student") Student student,
                                BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("student", student);
            model.addAttribute("error", bindingResult.getAllErrors());

            System.out.println("form redirect in error");
            System.out.println(bindingResult.getAllErrors());

            return "students/newstudent";
        } else {
            studentService.addNewStudent(student);
            return "redirect:/eregistrar/students/all-students";
        }
    }
    @GetMapping(value={"/edit/{studentId}"})
    public String displayEditStudentForm(@PathVariable Long studentId, Model model){
        var student = studentService.searchStudentsById(studentId);
        if (student != null) {
            model.addAttribute("student", student);
            return "/students/edit";
        }else{
            return "redirect:/eregistrar/students/all-students";
        }
    }

    @PostMapping(value={"/update"})
    public String updateStudent(@Valid @ModelAttribute("student") Student student,
                                BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("student", student);
            model.addAttribute("error", bindingResult.getAllErrors());
            return "students/edit";
        } else {
            studentService.addNewStudent(student);
            return "redirect:/eregistrar/students/all-students";
        }
    }

    @GetMapping(value="/delete/{studentId}")
    public String deleteStudent(@PathVariable Long studentId, Model model){
        studentService.deleteStudentById(studentId);
        return "redirect:/eregistrar/students/all-students";
    }

    @GetMapping(value="/search")
    public ModelAndView searchStudents(@RequestParam String searchString){
        ModelAndView modelAndView = new ModelAndView();
        List<Student> students = studentService.searchStudents(searchString);
        modelAndView.addObject("students", students);
        modelAndView.addObject("searchstring", searchString);
        modelAndView.addObject("studentsCount", students.size());
        modelAndView.setViewName("students/students");
        return modelAndView;
    }
}
