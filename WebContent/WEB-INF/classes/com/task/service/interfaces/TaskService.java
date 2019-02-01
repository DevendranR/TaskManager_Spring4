package com.task.service.interfaces;

import java.util.List;

import com.task.model.Tasks;

public interface TaskService {
	public void assignTasks(Tasks task) throws Exception;
	public List<Tasks> fetchTaskByProjects(String ProjectId) throws Exception;
}
