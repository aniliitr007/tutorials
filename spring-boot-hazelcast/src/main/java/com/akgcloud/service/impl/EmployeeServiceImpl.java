package com.akgcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.akgcloud.dao.EmployeeDao;
import com.akgcloud.model.Employee;
import com.akgcloud.service.EmployeeService;

@Service
@CacheConfig(cacheNames = "employees")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public void insertEmployee(Employee employee) {
		employeeDao.insertEmployee(employee);
	}

	@Override
	public void insertEmployees(List<Employee> employees) {
		employeeDao.insertEmployees(employees);
	}

	@Override
	@Cacheable()
	public List<Employee> getAllEmployees() {
		System.out.println("Inside the service layer");
		return employeeDao.getAllEmployees();

	}

	@Override
	public void getEmployeeById(String empId) {
		Employee employee = employeeDao.getEmployeeById(empId);
		System.out.println(employee);
	}

}