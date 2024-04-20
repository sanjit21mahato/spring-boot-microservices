package com.sam.springbootdemo.service;

import java.util.List;

import com.sam.springbootdemo.model.Employee;

public interface IEmployeeService {

	public Employee saveEmployee(Employee employee);

	public List<Employee> getEmployees();

	public Employee getEmployeeById(String employeeId);

}
