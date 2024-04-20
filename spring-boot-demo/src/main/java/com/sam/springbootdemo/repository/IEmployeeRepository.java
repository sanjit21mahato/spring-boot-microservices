package com.sam.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sam.springbootdemo.entity.EmployeeEntity;


@Repository
public interface IEmployeeRepository extends JpaRepository<EmployeeEntity, String>{
	

}
