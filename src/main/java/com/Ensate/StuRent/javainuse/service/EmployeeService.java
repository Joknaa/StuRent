package com.Ensate.StuRent.javainuse.service;

import com.Ensate.StuRent.javainuse.model.Employee;

import java.util.List;


public interface EmployeeService {
	void insertEmployee(Employee emp);
	void insertEmployees(List<Employee> employees);
	List<Employee> getAllEmployees();
	void getEmployeeById(String empid);
}