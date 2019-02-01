package com.task.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.task.model.Employee;
import com.task.persistence.dao.interfaces.EmployeeDAO;
import com.task.service.interfaces.EmployeeService;
@Service("employeeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	 private EmployeeDAO employeeDAO;
	
	@Override
	public List<Employee> fetchEmployeeByProject(String projectId) throws Exception {
		List<Employee> employeeDetails = employeeDAO.fetchEmployeeByProject(projectId);
		return employeeDetails;
	}

}
