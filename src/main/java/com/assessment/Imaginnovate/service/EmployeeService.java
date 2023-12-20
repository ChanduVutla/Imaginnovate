package com.assessment.Imaginnovate.service;

import com.assessment.Imaginnovate.dto.EmployeeDTO;
import com.assessment.Imaginnovate.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

     public EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    public List<EmployeeDTO> getTaxDeductions();
    }
