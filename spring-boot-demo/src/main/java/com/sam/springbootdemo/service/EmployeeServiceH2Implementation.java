package com.sam.springbootdemo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.springbootdemo.entity.EmployeeEntity;
import com.sam.springbootdemo.model.Employee;
import com.sam.springbootdemo.repository.IEmployeeRepository;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
public class EmployeeServiceH2Implementation implements IEmployeeService{
	
	@Autowired
	private IEmployeeRepository employeeRespository;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		employee.setEmployeeId(UUID.randomUUID().toString());
		EmployeeEntity entity = new EmployeeEntity();
		BeanUtils.copyProperties(employee, entity);
		entity = employeeRespository.save(entity);
		return employee;
	}

	@Override
	public List<Employee> getEmployees() {
		List<EmployeeEntity> list=employeeRespository.findAll();
		List<Employee> employeeList = new ArrayList<Employee>();
		/*for(EmployeeEntity entity: list){
			Employee e = new Employee();
			BeanUtils.copyProperties(entity, e);
			employeeList.add(e);
		}*/
		
		employeeList = list.stream().map(employeeEntity->{
			Employee e = new Employee();
			BeanUtils.copyProperties(employeeEntity, e);
			return e;
		}).collect(Collectors.toList());
				
				
		return employeeList;
	}

	@Override
	public Employee getEmployeeById(String employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
