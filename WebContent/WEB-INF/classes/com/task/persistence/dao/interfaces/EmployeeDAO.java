package com.task.persistence.dao.interfaces;

import java.util.List;

import com.task.model.Employee;

public interface EmployeeDAO {
	public List<Employee> fetchEmployeeByProject(String projectId) throws Exception;
}
