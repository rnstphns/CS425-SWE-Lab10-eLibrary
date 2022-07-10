package edu.miu.cs.cs425.eregistrar.service.impl;

import edu.miu.cs.cs425.eregistrar.model.Student;
import edu.miu.cs.cs425.eregistrar.repository.StudentRepository;
import edu.miu.cs.cs425.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student addNewStudent(Student student) {
        return studentRepository.save(student);
    }
    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student editStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student searchStudentsById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElse(null);
    }
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll(Sort.by("lastName", "dateOfEnrollment"));
    }

    @Override
    public List<Student> searchStudents(String searchString) {
        if(isDate(searchString)) {
            return studentRepository.findAllByDateOfEnrollment(LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE));
        }else{
            return studentRepository.findAllByFirstNameOrMiddleNameOrLastName(searchString, searchString, searchString);
        }
    }

    private boolean isDate(String searchString){
        boolean isParseableAsDate = false;
        try{
            LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE);
            isParseableAsDate = true;
        }catch(Exception exc){
            if(exc instanceof DateTimeParseException){
                isParseableAsDate = false;
            }
        }
        return isParseableAsDate;
    }


}
