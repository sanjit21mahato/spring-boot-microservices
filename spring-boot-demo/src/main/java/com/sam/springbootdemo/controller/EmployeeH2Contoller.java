package com.sam.springbootdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sam.springbootdemo.model.Employee;
import com.sam.springbootdemo.service.IEmployeeService;

@RestController
@RequestMapping("/v2/employee")
public class EmployeeH2Contoller {
	
	@Autowired
	@Qualifier("employeeServiceH2Implementation")
	private IEmployeeService employeeService;
	
	@PostMapping("/saveEmployee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){

		employee =employeeService.saveEmployee(employee);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	@GetMapping("/getEmployees")
	public List<Employee> getEmployees(){
		return employeeService.getEmployees();
	}

}
