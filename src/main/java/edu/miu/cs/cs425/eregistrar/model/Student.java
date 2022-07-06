package edu.miu.cs.cs425.eregistrar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @NotNull
    @NotEmpty
    @NotBlank
    private String studentNumber;

    @NotNull
    @NotEmpty
    @NotBlank
    private String firstName;

    private String middleName;

    @NotNull
    @NotEmpty
    @NotBlank
    private String lastName;

    private double cgpa;

    @NotNull
    private LocalDate dateOfEnrollment;

//    @OneToOne
//    @JoinColumn(name = "transcript_id")
//    private Transcript transcript;
//
//    @ManyToOne
//    @JoinColumn(name="classroomId")
//    private Classroom currentClassroom;
}
