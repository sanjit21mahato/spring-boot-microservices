package com.sam.springbootdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sam.springbootdemo.exception.EmployeeNotFoundException;
import com.sam.springbootdemo.model.Employee;
import com.sam.springbootdemo.model.EmployeeErrorResponse;
import com.sam.springbootdemo.service.IEmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	@Qualifier("employeeServiceImpl")
	private IEmployeeService employeeService;

	@PostMapping("/saveEmployee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		// Employee employee = new Employee();
		employee = employeeService.saveEmployee(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	/*@GetMapping(value="/getEmployees", produces = {"application/xml"})*/
	@GetMapping("/getEmployees")
	public ResponseEntity<List<Employee>> getEmployees() {
		List<Employee> employeeList = new ArrayList<>();
		employeeList = employeeService.getEmployees();
		return new ResponseEntity<>(employeeList, HttpStatus.OK);
	}

	@GetMapping("/getEmployeeById/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") String employeeId) {
		Employee employee = new Employee();
		employee = employeeService.getEmployeeById(employeeId);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	
	/*This way of handling exception becomes difficut in real project as we have many controller
	so lets have a seperate class for handling exception*/
	
	/*@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<EmployeeErrorResponse> handleEmployeeExceptions(EmployeeNotFoundException exception){
		
		EmployeeErrorResponse errorResponse = new EmployeeErrorResponse();
		errorResponse.setErrorMessage(exception.getMessage());
		errorResponse.setStatus(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}*/

}
