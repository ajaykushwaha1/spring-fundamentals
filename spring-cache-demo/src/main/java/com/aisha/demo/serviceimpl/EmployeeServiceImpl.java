package com.aisha.demo.serviceimpl;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisha.demo.dao.EmployeeDao;
import com.aisha.demo.model.Employee;
import com.aisha.demo.service.EmployeeService;

@Service("EmployeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public String getEmployee(Integer id) {
		System.out.println("inside getEmployee");
		if (id == null)
			return "ID can't null";

		Optional<Employee> employee = employeeDao.findById(id);
		if (employee.isPresent()) {
			Employee emp = employee.get();

			return emp.getUserName();
		} else {
			return "Employee Not Found";
		}

	}

	@Override
	public String createEmployee(Map<String, Object> valuemap) {
		try {
			Employee employee = new Employee();
			employee.setUserName(valuemap.get("username").toString());
			employee.setSalary((Integer) valuemap.get("salary"));
			employee.setDepartment((String) valuemap.get("department"));
			Employee employeeResponse = employeeDao.save(employee);
			if (!Objects.isNull(employeeResponse))
				return "Employee Created Sucessfully";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Unbale To Create Employee";

	}

	@Override
	public String updateEmployee(Map<String, Object> valuemap) {

		try {
			Employee user = employeeDao.findByUsername((String) valuemap.get("username"));
			if (!Objects.isNull(user)) {
				Integer user1 = employeeDao.updateEmployee((String) valuemap.get("department"),
						(String) valuemap.get("username"));
				if (user1 > 0)
					return "Employee Data Updated Successfully";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Unable To Update Employee Data";
	}

	@Override
	public void deletEmployeeById(Integer id) {
		Optional<Employee> user = employeeDao.findById(id);
		if (!Objects.isNull(user)) {
			employeeDao.deleteById(id);

		}

	}

}
