package com.assessment.Imaginnovate.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class EmployeeDTO {

        @NotNull(message="The employeeId shouldn't be null")
        private long empId;
        @NotBlank(message="The firstName shouldn't be null or Empty")
        private String firstName;
        @NotBlank(message="The lastName shouldn't be null or Empty")
        private String lastName;
        @Email(message = "The Email should be in email format")
        private String email;
        @NotEmpty
        private List<@Pattern(regexp = "^\\d{10}$",message = "The Email should be in email format") String> phoneNumber;
        @NotBlank(message="The dateofJoining shouldn't be null or Empty")
        private String dateOfJoining;
        @NotNull(message="The Salary shouldn't be null")
        private long salary;
        private double taxAmount;
        private double cessAmount;

    }

