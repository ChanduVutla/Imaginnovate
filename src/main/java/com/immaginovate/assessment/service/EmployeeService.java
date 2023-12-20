package com.immaginovate.assessment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.immaginovate.assessment.dto.EmployeeDTO;

@Service
public interface EmployeeService {

	public EmployeeDTO createEmployee(EmployeeDTO employee);

	public List<EmployeeDTO> getTaxDeduction();

}
