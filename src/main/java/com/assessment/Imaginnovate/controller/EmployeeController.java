package com.assessment.Imaginnovate.controller;

import com.assessment.Imaginnovate.dto.EmployeeDTO;
import com.assessment.Imaginnovate.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/createEmployee")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody @Valid EmployeeDTO employeeDTO)
    {
        return new ResponseEntity<> (employeeService.createEmployee(employeeDTO), HttpStatus.CREATED);
    }
    @GetMapping("/getTaxDeductions")
    public ResponseEntity<List<EmployeeDTO>> getTaxDeductions()
    {
        return  ResponseEntity.ok(employeeService.getTaxDeductions());
    }
}
