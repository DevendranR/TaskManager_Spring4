package com.task.persistence.dao.interfaces;

import java.util.List;

import com.task.model.Projects;

public interface ProjectDAO {
	public List<Projects> fetchAllProjects() throws Exception;
}
