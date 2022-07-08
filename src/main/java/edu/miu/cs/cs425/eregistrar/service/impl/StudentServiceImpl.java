package edu.miu.cs.cs425.eregistrar.service.impl;

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

}
