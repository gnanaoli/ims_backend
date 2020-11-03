package com.fa.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fa.inventory.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee findByEmployeeId(String employeeId);

	List<Object> findByDepartment(String name);

	List<Object> findByDesignation(String designation);

	List<Object> findByPstate(String stateName);

	List<Object> findByPcity(String cityName);

	
}
