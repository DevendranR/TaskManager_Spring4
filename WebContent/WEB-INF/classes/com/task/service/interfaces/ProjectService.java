package com.task.service.interfaces;

import java.util.List;

import com.task.model.Projects;

public interface ProjectService {
	public List<Projects> fetchAllProjects() throws Exception;
}
