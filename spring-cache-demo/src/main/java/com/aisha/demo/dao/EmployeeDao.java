package com.aisha.demo.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import com.aisha.demo.model.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
	Employee findByUsername(@Param("name") String username);

	@Transactional
	@Modifying
	Integer updateEmployee(@Param("dept") String department, @Param("name") String username);

}
