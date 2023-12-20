package com.assessment.Imaginnovate.serviceImpl;

import com.assessment.Imaginnovate.dto.EmployeeDTO;
import com.assessment.Imaginnovate.entity.Employee;
import com.assessment.Imaginnovate.repository.EmployeeRepository;
import com.assessment.Imaginnovate.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    /**
     * @param employeeDTO
     * @return
     */
    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO,employee,"taxAmount","cessAmount");
        BeanUtils.copyProperties(employeeRepository.save(employee),employeeDTO,"taxAmount","cessAmount");
        return employeeDTO;
    }

    /**
     * @return
     */
    @Override
    public List<EmployeeDTO> getTaxDeductions() {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        List<Employee> empl= employeeRepository.findAll();
        //BeanUtils.copyProperties(empl,employeeDTOList);
        for(Employee emp : empl){
            EmployeeDTO empDTO = new EmployeeDTO();
            BeanUtils.copyProperties(emp,empDTO);
            employeeDTOList.add(empDTO);
        }
        employeeDTOList.stream().forEach(emp->
        {
            
            emp.setTaxAmount(getCalculatedTaxAmount(emp));
            emp.setCessAmount(getCalculatedCessAmount(emp));
        });
        return employeeDTOList;
    }

    private double getCalculatedCessAmount(EmployeeDTO employeeDTO) {
        long totalSalary = employeeDTO.getSalary()*12;
        if(totalSalary < 250000)
        {
            return 0.0;
        }
        else if(totalSalary>250000 && totalSalary<=300000)
        {
            return 300000 * 0.02;
        }
        else
        {
            return totalSalary * 0.02;
        }

    }

    private double getCalculatedTaxAmount(EmployeeDTO employeeDTO) {
        
       /* long totalSalary = employeeDTO.getSalary()*12;
        return getTaxAmount(totalSalary);*/
        double totalSalary = 0;
        LocalDate doj = LocalDate.parse(employeeDTO.getDateOfJoining());
        int dojYear = doj.getYear();
        int currentYear = LocalDate.now().getYear();
        if (currentYear > dojYear) {
            totalSalary = employeeDTO.getSalary() * 12;
        } else {
            double perdaySal = employeeDTO.getSalary() / 30;
            // if employee joined in the middle of the year
            double dojdate = (30 - doj.getDayOfMonth()) * perdaySal;
            totalSalary = dojdate + (12 - (doj.getMonthValue() + 1) + 3) * employeeDTO.getSalary();
        }
        return getTaxAmount(totalSalary);
    }
       // return  0.0;


    private double getTaxAmount(double totalSalary) {
        double taxAmount = 0.0;
        if (totalSalary <= 250000) {
            return 0.0;
        } else if (totalSalary <= 500000) {
            return 0.05 * (totalSalary - 250000);

        } else if (totalSalary <= 1000000) {
            return 0.1 * (totalSalary - 500000) + 12500;

        } else {
            return 0.2 * (totalSalary - 1000000) + 62500;
        }
    }
}
