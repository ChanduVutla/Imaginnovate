package com.assessment.Imaginnovate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Entity
@Table(name="Employee")
public class Employee {
    @Id
    private long empId;
    private String firstName;
    private String lastName;
    private String Email;
    private List<String> phoneNumber;
    private String dateOfJoining;
    private long salary;


}
