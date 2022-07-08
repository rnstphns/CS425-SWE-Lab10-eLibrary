package edu.miu.cs.cs425.eregistrar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
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


    @NotBlank
    private String studentNumber;


    @NotBlank
    private String firstName;

    private String middleName;


    @NotBlank
    private String lastName;

    @Nullable
    private Double cgpa;

    @NotNull
//    @PastOrPresent
    //TODO change back to LocalDate
    private String dateOfEnrollment;

    @NotNull
    private boolean isInternational;
}
