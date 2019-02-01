package com.task.resources;

import com.task.persistence.dao.impl.EmployeeDAOImpl;
import com.task.persistence.dao.impl.ProjectDAOImpl;
import com.task.persistence.dao.impl.TaskDAOImpl;
import com.task.persistence.dao.interfaces.EmployeeDAO;
import com.task.persistence.dao.interfaces.ProjectDAO;
import com.task.persistence.dao.interfaces.TaskDAO;
import com.task.service.impl.EmployeeServiceImpl;
import com.task.service.impl.ProjectServiceImpl;
import com.task.service.impl.TaskServiceImpl;
import com.task.service.interfaces.EmployeeService;
import com.task.service.interfaces.ProjectService;
import com.task.service.interfaces.TaskService;


public class Factory
{
	public static TaskDAO createTaskDAO(){
		return new TaskDAOImpl();
	}
	public static TaskService createTaskService(){
		return new TaskServiceImpl();
	}
	public static EmployeeDAO createEmployeeDAO(){
		return new EmployeeDAOImpl();
	}
	public static EmployeeService createEmployeeService(){
		return new EmployeeServiceImpl();
	}
	public static ProjectDAO createProjectDAO(){
		return new ProjectDAOImpl();
	}
	public static ProjectService createProjectService(){
		return new ProjectServiceImpl();
	}
}