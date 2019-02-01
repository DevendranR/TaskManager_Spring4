package com.task.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.task.model.Tasks;
import com.task.persistence.dao.interfaces.TaskDAO;
import com.task.resources.Factory;
import com.task.service.interfaces.TaskService;
@Service("taskService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TaskServiceImpl implements TaskService{
	@Autowired
	TaskDAO taskDAO;
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void assignTasks(Tasks task) throws Exception {
		taskDAO.assignTasks(task);
		
	}

	@Override
	public List<Tasks> fetchTaskByProjects(String ProjectId) throws Exception {
		if(ProjectId.equals("ALL_PROJECTS")){
			return taskDAO.fetchAllTasks();
		}else{
			return taskDAO.fetchTaskByProjects(ProjectId);	
		}
		
		
	}

}
