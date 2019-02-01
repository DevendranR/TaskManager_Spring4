package com.task.persistence.dao.interfaces;

import java.util.List;

import com.task.model.Tasks;

public interface TaskDAO {
	public void assignTasks(Tasks task) throws Exception;
	public List<Tasks> fetchTaskByProjects(String ProjectId) throws Exception;
	public List<Tasks> fetchAllTasks() throws Exception;
}
