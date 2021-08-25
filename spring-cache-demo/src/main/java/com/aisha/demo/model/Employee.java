package com.aisha.demo.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@NamedQuery(name = "Employee.findByUserName", query = "select u from Employee u where u.username=:name")
@NamedQuery(name = "Employee.updateEmployee", query = "update Employee u set u.department=:dept where u.username=:name")

@Entity
@Table(name = "Employee")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="emp")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name="empid_pk")
	private Integer id;
	
	@Basic
	@Column(name = "username")
	private String username;
	
	@Basic
	@Column(name = "salary")
	private Integer salary;
	

	@Basic
	@Column(name = "department")
	private String department;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", username=" + username + ", salary=" + salary + ", department=" + department
				+ "]";
	}

	

}
