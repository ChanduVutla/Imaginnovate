package com.immaginovate.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.immaginovate.assessment.dto.EmployeeDTO;
import com.immaginovate.assessment.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
		
	@PostMapping("/createEmployee")
	public ResponseEntity<EmployeeDTO> CreateEmployee( @RequestBody @Valid EmployeeDTO employee)
	{
		return new ResponseEntity<>( employeeService.createEmployee(employee),HttpStatus.CREATED);
	}
	@GetMapping("/getTaxDeduction")
	public ResponseEntity<List<EmployeeDTO>> getTaxDeduction( )
	{
		return new ResponseEntity<>( employeeService.getTaxDeduction(),HttpStatus.OK);
	}

}
