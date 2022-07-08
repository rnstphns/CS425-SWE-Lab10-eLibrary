package edu.miu.cs.cs425.eregistrar.repository;

import edu.miu.cs.cs425.eregistrar.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> searchStudentsByLastName(String lastName);
    List<Student> findAllByDateOfEnrollment(LocalDate dateOfEnrollment);
    List<Student> findAllByStudentNumber(String studentNumber);
    List<Student> findAllByFirstNameOrMiddleNameOrLastName(String firstName, String middleName, String lastName);

}
