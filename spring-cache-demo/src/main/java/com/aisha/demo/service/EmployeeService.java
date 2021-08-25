package com.aisha.demo.service;

import java.util.Map;

public interface EmployeeService {
	String getEmployee(Integer id);

	String createEmployee(Map<String, Object> valuemap);

	String updateEmployee(Map<String, Object> valuemap);

	void deletEmployeeById(Integer id);
}
