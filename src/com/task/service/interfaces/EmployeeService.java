package com.task.service.interfaces;

import java.util.List;

import com.task.model.Employee;

public interface EmployeeService {
	public List<Employee> fetchEmployeeByProject(String projectId) throws Exception;
}
