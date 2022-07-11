package edu.miu.cs.cs425.eregistrar.dto.restapi;

import edu.miu.cs.cs425.eregistrar.dto.StudentRequest;
import edu.miu.cs.cs425.eregistrar.exception.StudentNotFoundException;
import edu.miu.cs.cs425.eregistrar.model.Student;
import edu.miu.cs.cs425.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value={"/eregistrar/api/student"})
public class StudentRestController {

    @Autowired
    private StudentService studentService;
    @GetMapping(value = {"/list"})
    public ResponseEntity<List<Student>> listStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }
    @GetMapping(value="/get/{studentId}")
    public ResponseEntity<Student> getStudentId(@PathVariable Long studentId) throws StudentNotFoundException {
        return ResponseEntity.ok(studentService.getStudentsById(studentId));
    }
    @PostMapping(value={"/new"})
    public ResponseEntity <Student> addNewStudent(@Valid @RequestBody StudentRequest studentRequest){
        return new ResponseEntity<>(studentService.addNewStudent(studentRequest),
        HttpStatus.CREATED);
    }

    @PutMapping (value={"/edit/{studentId}"})
    public ResponseEntity<Student> updatePublisher(@Valid @RequestBody StudentRequest studentRequest,
                                                     @PathVariable Long studentId) {
        return new ResponseEntity<>(studentService.editStudent(studentRequest, studentId),
                HttpStatus.OK);
    }

    @DeleteMapping(value="/delete/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long studentId) throws StudentNotFoundException{
        var student = studentService.getStudentsById(studentId);
        if(student == null)
            throw new StudentNotFoundException(String.format("Student with ID %d not found"));
        studentService.deleteStudentById(studentId);
        return ResponseEntity.noContent().build();
    }


}
