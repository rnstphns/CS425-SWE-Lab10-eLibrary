package edu.miu.cs.cs425.eregistrar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class StudentRequest {
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
