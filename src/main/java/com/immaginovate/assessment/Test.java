package com.immaginovate.assessment;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

import com.immaginovate.assessment.dto.EmployeeDTO;

public class Test {

	public static void main(String[] args) {
		Test test = new Test();
		test.getTaxdesuction();

	}
	
	private void getTaxdesuction() {
	/*	double totalSalary = employeeDto.getSalary()*12;
		int Year = java.time.Year.now().getValue();
		int difference = new Date() 
		
		Calendar calenderDate = Calendar.getInstance();
		calenderDate.setTime(new Date("2022-02-01")); */   
		
		 Date date = new Date();
	      // Getting year from date
		 
	      long year = date.getTime();
	      
			/*
			 * Month month = LocalDate.now().getMonth(); int monthValue =
			 * LocalDate.now().getMonthValue(); // Printing the year
			 * System.out.println("Year: " + year); System.out.println("month: " +
			 * month.toString()); System.out.println("monthValue: " + monthValue);
			 * 
			 * // Getting year from date
			 * 
			 * // Printing the year System.out.println("Year: " + year);
			 * System.out.println("month: " + month.toString());
			 * System.out.println("monthValue: " + monthValue);
			 */
		
		
		//double totalSalary = salary* 
	      
	     // String df = new SimpleDateFormat("yyyy-mm-dd").format(employeeDto.getDoj());	
			
			
			 LocalDate doj = LocalDate.parse("2022-01-01");
			 int dojYear = doj.getYear();
			 int dojDayMonth = doj.getDayOfMonth();
		      int currentYear = LocalDate.now().getYear();
		      if(currentYear>dojYear)
		      {
		    	  System.out.println(3000*12);
		      }
		      else
		      {
		    	  ((12-doj.getMonthValue())+3)*3000;
		      }
		
	}
}
