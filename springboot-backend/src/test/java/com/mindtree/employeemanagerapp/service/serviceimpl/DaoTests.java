package com.mindtree.employeemanagerapp.service.serviceimpl;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mindtree.employeemanagerapp.model.Employee;
import com.mindtree.employeemanagerapp.repository.EmployeeRepository;
import com.mindtree.employeemanagerapp.service.EmployeeService;
 
 
@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DaoTests {
 
  @Autowired
  EmployeeRepository employeeRepository;
  @MockBean
  EmployeeService employeeservice;
 
  @Test
  public void addNewEmployee() {
    Employee employee = new Employee("Bhanu","Yeswamth","bhanu@gmail.com");
    employeeRepository.save(employee);
    List<Employee> employees = employeeRepository.findAll();
    assertEquals(4, employees.size());
  }
  
  @Test
  public void findById() {
    employeeRepository.findById(2L).get();   
    assertEquals("manu", employeeRepository.findById(2L).get().getFirstName());
  }
  
  
  @Test
  public void findAll() {
	  Employee employee = new Employee("Bhanu","Yeswamth","bhanu@gmail.com");
		Employee employee1 = new Employee("manu","manu","manu@gmail.com");
		Employee employee2 = new Employee("sumedha","vaishnavi","sumedha@gmail.com");
		List<Employee> employees = Arrays.asList(employee,employee1,employee2);
		Mockito.when(employeeservice.getAllEmployees()).thenReturn(employees);
	    assertEquals(3, employeeservice.getAllEmployees().size());
	  }
  
  
  
  @Test
  public void deleteEmployeeById() {
    employeeRepository.deleteById(2L);
    List<Employee> employees = employeeRepository.findAll();
    for (Employee employee : employees) {
		System.out.println(employee.getFirstName());
	}
    assertEquals(2, employees.size());
  }
  
  
  
  
  
 
  
  
}
	
	
	
	
