package edu.miu.cs.cs425.eregistrar.service;

import edu.miu.cs.cs425.eregistrar.model.Student;

import java.util.List;

public interface StudentService {

    Student addNewStudent(Student student);
    void deleteStudentById(Long studentId);
    Student editStudent(Student student);
    Student searchStudentsById(Long studentId);
    List<Student> getAllStudents();
}
