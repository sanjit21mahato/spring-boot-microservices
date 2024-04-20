package com.sam.springbootdemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.sam.springbootdemo.exception.EmployeeNotFoundException;
import com.sam.springbootdemo.model.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	/*lets use in memory ArrayList to save employee now we will use DB later*/
	List<Employee> employeeList = new ArrayList<>();
	
	@Override
	public Employee saveEmployee(Employee employee) {
		employee.setEmployeeId(UUID.randomUUID().toString());
		employeeList.add(employee);
		return employee;
	}
	
	@Override
	public List<Employee> getEmployees() {
		return employeeList;
	}
	
	@Override
	public Employee getEmployeeById(String employeeId) {
		/*It will give exception if id is not matching */
		/*return employeeList.stream().filter
				(employee->employee.getEmployeeId().equalsIgnoreCase(employeeId)).findFirst().get();*/
		
		//Handling exception
		/*return employeeList.stream()
				.filter(employee -> employee.getEmployeeId().equalsIgnoreCase(employeeId))
				.findFirst().orElseThrow(()-> new RuntimeException("Employee not found with id: "+ employeeId));*/
		/*But the above one is not correct way to handle exception using RuntimeTimeException, Let handle in proper way 
		 * by creating our custom exception class amd bean for storing error message */
		
		return employeeList.stream()
				.filter(employee -> employee.getEmployeeId().equalsIgnoreCase(employeeId))
				.findFirst().orElseThrow(()-> new EmployeeNotFoundException("Employee not found with id: "+ employeeId));
		
		
		
	}
}
