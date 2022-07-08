package edu.miu.cs.cs425.eregistrar.service.impl;

import edu.miu.cs.cs425.eregistrar.dto.StudentRequest;
import edu.miu.cs.cs425.eregistrar.exception.StudentNotFoundException;
import edu.miu.cs.cs425.eregistrar.model.Student;
import edu.miu.cs.cs425.eregistrar.repository.StudentRepository;
import edu.miu.cs.cs425.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student addNewStudent(StudentRequest studentRequest) {
        var newStudent = Student.build(null, studentRequest.getStudentNumber(),
                studentRequest.getFirstName(), studentRequest.getMiddleName(), studentRequest.getLastName(),
                studentRequest.getCgpa(), studentRequest.getDateOfEnrollment(), studentRequest.isInternational());
        return studentRepository.save(newStudent);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student editStudent(StudentRequest updatedStudentRequest, Long studentId) {
        Student updatedStudent = Student.build(studentId, updatedStudentRequest.getStudentNumber(),
                updatedStudentRequest.getFirstName(), updatedStudentRequest.getMiddleName(), updatedStudentRequest.getLastName(),
                updatedStudentRequest.getCgpa(), updatedStudentRequest.getDateOfEnrollment(), updatedStudentRequest.isInternational());
        return studentRepository.save(updatedStudent);
    }

    @Override
    public Student getStudentsById(Long studentId) throws StudentNotFoundException{
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException(String.format("Student with ID: %d, is not found", studentId)));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll(Sort.by("lastName", "dateOfEnrollment"));
    }


}
