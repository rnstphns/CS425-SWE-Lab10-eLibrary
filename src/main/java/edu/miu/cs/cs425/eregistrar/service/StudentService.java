package edu.miu.cs.cs425.eregistrar.service;

import edu.miu.cs.cs425.eregistrar.dto.StudentRequest;
import edu.miu.cs.cs425.eregistrar.exception.StudentNotFoundException;
import edu.miu.cs.cs425.eregistrar.model.Student;

import java.util.List;

public interface StudentService {

    Student addNewStudent(StudentRequest studentRequest);
    void deleteStudentById(Long studentId);
    Student editStudent(StudentRequest studentRequest, Long studentId);
    Student getStudentsById(Long studentId) throws StudentNotFoundException;
    List<Student> getAllStudents();
}
