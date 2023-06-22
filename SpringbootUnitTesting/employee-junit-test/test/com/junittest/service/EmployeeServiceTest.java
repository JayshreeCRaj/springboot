package com.junittest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

//import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.junittest.Employee;

class EmployeeServiceTest {

	@Test
	@DisplayName("PositiveTestCase")
	void getEmployeeDetailsTest() {
		EmployeeService empService = new EmployeeService();
		
		Employee emp = new Employee();
		emp.setName("Arjun");
		Employee updateEmployee = empService.getEmployeeDetails(emp);
		assertEquals(updateEmployee.getName(), emp.getName());
	}
	
	@Test
	void getEmployeeDetailsTestNegative() {
		EmployeeService empService = new EmployeeService();
		
		Employee emp = new Employee();
		emp.setName("Arjun");
		Employee updateEmployee = empService.getEmployeeDetails(emp);
		assertNotEquals(updateEmployee.getName(), "Arya");
	}
	
	@Test
	//@Disabled
	//Enable only if the test case need to be disabled
	void getEmployeeDetailsTestNull() {
		EmployeeService empService = new EmployeeService();
		
		Employee emp = new Employee();
		emp.setName(null);
		assertThrows(NullPointerException.class, ()->empService.getEmployeeDetails(emp));
	}
	

}
