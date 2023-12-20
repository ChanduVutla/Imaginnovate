package com.immaginovate.assessment.serviceimpl;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.immaginovate.assessment.dto.EmployeeDTO;
import com.immaginovate.assessment.entity.Employee;
import com.immaginovate.assessment.repository.EmployeeRepository;
import com.immaginovate.assessment.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	

	@Override
	public EmployeeDTO createEmployee(EmployeeDTO employeeDto) {
		 
		Employee employee = new Employee();
		try {
			BeanUtils.copyProperties(employee, employeeDto);
			System.out.println(employee);
			BeanUtils.copyProperties(employeeDto,employeeRepository.save(employee) );
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		  return employeeDto;
	}



	@Override
	public List<EmployeeDTO> getTaxDeduction() {
		EmployeeDTO employeeDto = null;
		List<EmployeeDTO>employeeDtoList =  new ArrayList<EmployeeDTO>();
		List<Employee>employeeList = employeeRepository.findAll();
		for(Employee employee :employeeList)
		{
			employeeDto =  new EmployeeDTO();
			try {
				BeanUtils.copyProperties(employeeDto, employee);
			} catch (IllegalAccessException | InvocationTargetException e) {
				
				e.getMessage();
			}
			getTaxdesuction(employeeDto);  
			employeeDtoList.add(employeeDto);
		}
		return employeeDtoList;
		
	}



	
	  private void getTaxdesuction(EmployeeDTO employeeDto) { 
		  
		String df = new SimpleDateFormat("yyyy-mm-dd").format(employeeDto.getDoj());	
		
		 double totalSalary = 0;
		 LocalDate doj = LocalDate.parse(df);
		 int dojYear = doj.getYear();
		  int currentYear = LocalDate.now().getYear();
	      if(currentYear>dojYear)
	      {
	    	  totalSalary = employeeDto.getSalary()*12;
	      }
	      else
	      {
	    	  double perdaySal = employeeDto.getSalary()/30;
	    	  //if employee joined in the middle of the year
	    	  double dojdate = (30-doj.getDayOfMonth())*perdaySal;
	    	 totalSalary = dojdate+(12-(doj.getMonthValue()-1)+3)*employeeDto.getSalary();
	      }
	      getTaxamount(totalSalary,employeeDto);
	  }


		/*
		 * No Tax for <=250000
		 * 
		 * 5% Tax for >250000 and <=500000
		 * 
		 * 10% Tax for >500000 and <=1000000
		 * 
		 * 20% Tax for >1000000
		 */
	private void getTaxamount(double totalSalary, EmployeeDTO employeeDto) {
		double taxAmount = 0.0;
		if(totalSalary<=250000)
		{
			employeeDto.setTaxAmount(0.0);
		}
		else if(totalSalary<=500000)
		{
			taxAmount = 0.05 * (totalSalary-250000);
			employeeDto.setTaxAmount(taxAmount);
		}
		else if (totalSalary<=1000000)
		{
			employeeDto.setTaxAmount( 0.1*(totalSalary-500000)+12500);
			
		}
		else
		{
			employeeDto.setTaxAmount(0.2*(totalSalary-1000000)+62500);
		}
		
	}
	 

}
