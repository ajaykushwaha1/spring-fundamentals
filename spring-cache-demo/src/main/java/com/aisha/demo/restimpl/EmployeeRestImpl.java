package com.aisha.demo.restimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aisha.demo.rest.EmployeeRest;
import com.aisha.demo.service.EmployeeService;

@RestController	
@RequestMapping(path = "/employee")
public class EmployeeRestImpl implements EmployeeRest{
	
	@Autowired
	EmployeeService employeeService;
	
	@Override
	@GetMapping(path ="getEmployee")
	public String getEmployee(@RequestParam(name = "id" , required = true)Integer id) {
		return employeeService.getEmployee(id);
	}
	
/*	@Override
	@PostMapping(path ="createEmployee")
	public String createEmployee(@RequestBody(required = true) Map<String, Object> valuemap){
		return employeeService.createEmployee(valuemap);
	}
	
	@Override
	@PostMapping(path = "updateEmployeeData")
	public String updateEmployee(@RequestBody(required = true) Map<String, Object> valuemap){
		return employeeService.updateEmployee(valuemap);
	}
	
	@Override
	@GetMapping(path ="deleteEmployee")
	public void deletEmployeeById(@RequestParam(name = "id")Integer id){
		employeeService.deletEmployeeById(id);
	}
 
*/	
}
